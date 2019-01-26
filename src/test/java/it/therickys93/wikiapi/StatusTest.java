package it.therickys93.wikiapi;

import static org.junit.Assert.*;
import org.junit.Test;

import it.therickys93.wikiapi.controller.Status;

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
	
	@Test
	public void testJson(){
		Status status = new Status("key");
		assertNull(status.toJson());
	}
	
	@Test
	public void testType() {
		Status status = new Status("key");
		assertEquals("Status", status.getType());
	}
	
	@Test
	public void testLed() {
		Status status = new Status("key");
		assertNull(status.getLed());
	}
	
	@Test
	public void testKey() {
		Status status = new Status("key");
		assertEquals("key", status.getKey());
	}
	
	@Test
	public void testPosition(){
		Status status = new Status("key");
		assertEquals(-1, status.getPosition());
	}
	
}
