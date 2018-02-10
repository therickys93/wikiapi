package it.therickys93.wikiapi;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import it.therickys93.wikiapi.controller.Download;

public class DownloadTest {

	@Test
	public void testMethod(){
		Download download = new Download();
		assertEquals("GET", download.method());
	}
	
	@Test
	public void testEndpoint(){
		Download download = new Download();
		assertEquals("/download", download.endpoint());
	}
	
}
