package it.therickys93.wikiapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import it.therickys93.wikiapi.controller.Upload;
import it.therickys93.wikiapi.model.House;

public class UploadTest {
	
	@Test
	public void testMethod(){
		Upload upload = new Upload(null);
		assertEquals("POST", upload.method());
	}
	
	@Test
	public void testEndpoint(){
		Upload upload = new Upload(null);
		assertEquals("/upload", upload.endpoint());
	}
	
	@Test
	public void testJson(){
		Upload upload = new Upload(createHouse());
		assertEquals("[{\"name\":\"luce rossa\",\"key\":\"arduino\",\"position\":10},"
				+ "{\"name\":\"luce gialla\",\"key\":\"arduino\",\"position\":11}]", upload.toJson().toString());
	}
	
	private House createHouse() {
		return House.fromJson("[{\"name\":\"luce rossa\",\"key\":\"arduino\",\"position\":10},"
				+ "{\"name\":\"luce gialla\",\"key\":\"arduino\",\"position\":11}]");
	}
	
	@Test
	public void testType() {
		Upload upload = new Upload(null);
		assertEquals("Carica", upload.getType());
	}
	
	@Test
	public void testLed() {
		Upload upload = new Upload(null);
		assertNull(upload.getLed());
	}
	
	@Test
	public void testKey() {
		Upload upload = new Upload(null);
		assertNull(upload.getKey());
	}
	
	@Test
	public void testPosition() {
		Upload upload = new Upload(null);
		assertEquals(-1, upload.getPosition());
	}
	
}
