package com.github.pjpo.commons.ioutils;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.concurrent.Executors;

import org.junit.Assert;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class WriterToReaderTest {

    @org.junit.Test
    public void testApp() {
    	String toWrite = "Bonjour";
    	
    	WriterToReader wtr = new WriterToReader();
    	Reader reader = wtr.getReader();
    	BufferedReader bReader = new BufferedReader(reader);

    	Executors.newSingleThreadExecutor().submit(
    			() -> {
    				wtr.write(toWrite);
    				wtr.close();
    			});
    	
    	StringBuilder result = new StringBuilder();
    	String readed = null;
    	while ((readed = bReader.readLine()) != null) {
    		result.append(readed);
    	}
    	
        Assert.assertEquals(toWrite, result.toString());
    }
}
