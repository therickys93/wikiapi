package it.therickys93.wikiapi;

import static org.junit.Assert.*;

import org.junit.Test;

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
	
}
