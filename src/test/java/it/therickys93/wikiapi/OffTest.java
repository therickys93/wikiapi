package it.therickys93.wikiapi;

import static org.junit.Assert.*;
import org.junit.Test;

public class OffTest {

	@Test
	public void testMethod(){
		Off off = new Off("key", 2);
		assertEquals("GET", off.method());
	}
	
	@Test
	public void testEndpoint(){
		Off off = new Off("key", 2);
		assertEquals("/off/key/2", off.endpoint());
	}
	
}
