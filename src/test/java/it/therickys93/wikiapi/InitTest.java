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
	
}
