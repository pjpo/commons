package com.github.pjpo.commons.ioutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class WriterToReaderTest {

    @Test
    public void testApp() throws IOException, InterruptedException, ExecutionException {
    	String toWrite = "Bonjour";
    	StringBuilder result = new StringBuilder();
    	
    	try (
    			WriterToReader wtr = new WriterToReader();
    			Reader reader = wtr.getReader();
    			BufferedReader bReader = new BufferedReader(reader);
    			) {

	    	Future<Boolean> future = Executors.newSingleThreadExecutor().submit(
	    			() -> {
	    				wtr.write(toWrite);
	    				wtr.close();
	    				return true;
	    			});
	    	
	    	String readed = null;
	    	while ((readed = bReader.readLine()) != null) {
	    		result.append(readed);
	    	}
	    	
	    	future.get();
    	}
        Assert.assertEquals(toWrite, result.toString());
    }

    @Test
    public void testApp2() {
    	String toWrite = "Bonjour";
    	StringBuilder result = new StringBuilder();
    	Boolean executionException = false;
    	
    	try (
    			WriterToReader wtr = new WriterToReader();
    			Reader reader = wtr.getReader();
    			BufferedReader bReader = new BufferedReader(reader);
    			) {

	    	Future<Boolean> future = Executors.newSingleThreadExecutor().submit(
	    			() -> {
	    		    	String readed = null;
	    		    	while ((readed = bReader.readLine()) != null) {
	    		    		result.append(readed);
	    		    	}
	    		    	return true;
	    			});
	    	
			wtr.write(toWrite);
			future.cancel(true);
			
			future.get();
	    	
    	} catch (CancellationException e) {
			executionException = true;
		} catch (Throwable e) {
			executionException = false;
		}
    	Assert.assertEquals(true, executionException);
    }

}
