package it.therickys93.wikiapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
	
	@Test
	public void testJson(){
		Download download = new Download();
		assertNull(download.toJson());
	}
	
	@Test
	public void testType() {
		Download download = new Download();
		assertEquals("Scarica", download.getType());
	}
	
	@Test
	public void testLed() {
		Download download = new Download();
		assertNull(download.getLed());
	}
	
	@Test
	public void testKey() {
		Download download = new Download();
		assertNull(download.getKey());
	}
	
	@Test
	public void testPosition() {
		Download download = new Download();
		assertEquals(-1, download.getPosition());
	}
	
}
