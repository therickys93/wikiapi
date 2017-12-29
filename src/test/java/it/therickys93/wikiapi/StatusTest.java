package it.therickys93.wikiapi;

import static org.junit.Assert.*;
import org.junit.Test;

public class StatusTest {

	@Test
	public void testMethod(){
		Status status = new Status("key");
		assertEquals("GET", status.method());
	}
	
	@Test
	public void testEndpoint(){
		Status status = new Status("key");
		assertEquals("/status/key", status.endpoint());
	}
	
}
