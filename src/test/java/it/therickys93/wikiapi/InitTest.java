package it.therickys93.wikiapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import it.therickys93.wikiapi.controller.Init;

public class InitTest {

	@Test
	public void testMethod(){
		Init init = new Init("key");
		assertEquals("GET", init.method());
	}
	
	@Test
	public void testEndpoint(){
		Init init = new Init("key");
		assertEquals("/init/key", init.endpoint());
	}
	
	@Test
	public void testJson(){
		Init init = new Init("key");
		assertNull(init.toJson());
	}
	
	@Test
	public void testType() {
		Init init = new Init("key");
		assertEquals("Init", init.getType());
	}
	
	@Test
	public void testLed() {
		Init init = new Init("key");
		assertNull(init.getLed());
	}
	
	@Test
	public void testKey() {
		Init init = new Init("key");
		assertEquals("key", init.getKey());
	}
	
	@Test
	public void testPosition() {
		Init init = new Init("key");
		assertEquals(-1, init.getPosition());
	}
}
