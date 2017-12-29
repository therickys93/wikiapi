package it.therickys93.wikiapi;

import static org.junit.Assert.*;
import org.junit.Test;

public class OnTest {

	@Test
	public void testMethod(){
		On on = new On("key", 1);
		assertEquals("GET", on.method());
	}
	
	@Test
	public void testEndpoint(){
		On on = new On("key", 1);
		assertEquals("/on/key/1", on.endpoint());
	}
	
}
