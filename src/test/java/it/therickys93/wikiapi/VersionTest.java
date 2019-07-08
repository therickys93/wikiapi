package it.therickys93.wikiapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import it.therickys93.wikiapi.controller.Version;

public class VersionTest {

	@Test
	public void testMethod(){
		Version version = new Version();
		assertEquals("GET", version.method());
	}
	
	@Test
	public void testEndpoint(){
		Version version = new Version();
		assertEquals("/version", version.endpoint());
	}
	
	@Test
	public void testJson(){
		Version version = new Version();
		assertNull(version.toJson());
	}
	
	@Test
	public void testType() {
		Version version = new Version();
		assertEquals("Versione", version.getType());
	}
	
	@Test
	public void testLed() {
		Version version = new Version();
		assertNull(version.getLed());
	}
	
	@Test
	public void testKey() {
		Version version = new Version();
		assertNull(version.getKey());
	}
	
	@Test
	public void testPosition() {
		Version version = new Version();
		assertEquals(-1, version.getPosition());
	}
	
}
