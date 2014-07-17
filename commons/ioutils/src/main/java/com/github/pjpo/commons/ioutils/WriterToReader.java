package com.github.pjpo.commons.ioutils;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class WriterToReader extends Writer implements AutoCloseable {

	private final StringBuffer buffer = new StringBuffer();
	
	private final Reader reader = new WriterReader();
	
	private static int MAX_BUFFER = 2048;
	
	private boolean closed = false;
	
	public WriterToReader() {
		super();
	}

	public WriterToReader(Object lock) {
		super(lock);
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		synchronized(lock) {
			// CAN'T WRITE ON CLOSED WRITER
			if (closed)
				throw new IOException("writer closed");
			
			// ADDS THE CHARS TO BUFFER
			buffer.append(cbuf, off, len);
		
			// WAIT UNTIL SIZE OF CHARS LESS THAN MAX_BUFFER
			waitUntil(MAX_BUFFER);
		}
	}

	@Override
	public void flush() throws IOException {
		synchronized(lock) {
			// CAN'T FLUSH ON CLOSED WRITER
			if (closed)
				throw new IOException("writer closed");

			// WAIT UNTIL NO ELEMENT REMAINS TO READ
			waitUntil(0);
		}
	}

	public Reader getReader() {
		return reader;
	}
	
	@Override
	public void close() throws IOException {
		synchronized(lock) {
			closed = true;
		}
	}

	private void waitUntil(final int remaining) throws IOException {
		synchronized(lock) {
			while (buffer.length() > remaining) {
				// NOTIFY THAT WE HAVE REMAINING LINES TO READ
				lock.notifyAll();
				try {
					lock.wait();
				} catch (InterruptedException e) {
					throw new IOException(e);
				}
			}
		}
	}
	
	private class WriterReader extends Reader implements AutoCloseable {

		public int read(char[] cbuf, int off, int len) throws IOException {
			synchronized(lock) {
				// WAIT WHILE SOME CHARS STAY TO READ IF STREAM IS NOT CLOSED
				while (buffer.length() == 0 && !closed) {
					// NOTIFY THAT WE WANT MORE LINES
					lock.notifyAll();
					try {
						lock.wait();
					} catch (InterruptedException e) {
						throw new IOException(e);
					}
				}
				
				if (buffer.length() != 0) {
					// IF BUFFER HAS REMAINING ELEMENTS, FILL CHARS ARRAY
					int copiedBuffer = len > buffer.length() ? buffer.length() : len;
					buffer.getChars(0, copiedBuffer, cbuf, off);
					buffer.delete(0, copiedBuffer);
					return copiedBuffer;
				} else {
					// THE STREAM HAS BEEN CLOSED
					return -1;
				}
			}
		}

		@Override
		public void close() throws IOException {
			synchronized (lock) {
				// FLUSHES THE BUFFER AND CLOSES THE STREAM
				buffer.delete(0, buffer.length());
				closed = true;
			}
		}
		
	}
	
}
