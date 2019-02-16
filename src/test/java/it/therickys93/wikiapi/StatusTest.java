package it.therickys93.wikiapi;

import static org.junit.Assert.*;
import org.junit.Test;

import it.therickys93.wikiapi.controller.Status;
import it.therickys93.wikiapi.model.Led;

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
	
	@Test
	public void testStatusWithPosition() {
		Status status = new Status("key", 1);
		assertEquals("GET", status.method());
		assertEquals("/status/key/1", status.endpoint());
		assertNull(status.toJson());
		assertEquals("Status", status.getType());
		assertNull(status.getLed());
		assertEquals("key", status.getKey());
		assertEquals(1, status.getPosition());
	}
	
	@Test
	public void testStatusWithLed() {
		Status status = new Status(new Led("pippo", "key", 2));
		assertEquals("GET", status.method());
		assertEquals("/status/key/2", status.endpoint());
		assertNull(status.toJson());
		assertEquals("Status", status.getType());
		assertNotNull(status.getLed());
		assertEquals("key", status.getKey());
		assertEquals(2, status.getPosition());
	}
	
}
