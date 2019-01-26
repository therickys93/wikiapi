package it.therickys93.wikiapi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.therickys93.wikiapi.controller.Reset;

public class ResetTest {

	@Test
	public void testMethod(){
		Reset reset = new Reset("key");
		assertEquals("GET", reset.method());
	}
	
	@Test
	public void testEndpoint(){
		Reset reset = new Reset("key");
		assertEquals("/reset/key", reset.endpoint());
	}
	
	@Test
	public void testJson(){
		Reset reset = new Reset("key");
		assertNull(reset.toJson());
	}
	
	@Test
	public void testType() {
		Reset reset = new Reset("key");
		assertEquals("Reset", reset.getType());
	}
	
	@Test
	public void testLed() {
		Reset reset = new Reset("key");
		assertNull(reset.getLed());
	}
	
	@Test
	public void testKey() {
		Reset reset = new Reset("key");
		assertEquals("key", reset.getKey());
	}
	
	@Test
	public void testPosition() {
		Reset reset = new Reset("key");
		assertEquals(-1, reset.getPosition());
	}
	
}
