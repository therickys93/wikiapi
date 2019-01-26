package it.therickys93.wikiapi;

import static org.junit.Assert.*;
import org.junit.Test;

import it.therickys93.wikiapi.controller.Off;
import it.therickys93.wikiapi.model.Led;

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
	
	@Test
	public void testJson(){
		Off off = new Off("key", 2);
		assertNull(off.toJson());
	}
	
	@Test
	public void testWithLedContructor() {
		Off off = new Off(createLed());
		assertEquals("/off/key/2", off.endpoint());
	}
	
	private Led createLed(){
		Led led = new Led();
		led.setName("name");
		led.setKey("key");
		led.setPosition(2);
		return led;
	}
	
	@Test
	public void testTypeOne() {
		Off off = new Off("key", 2);
		assertEquals("Spegni", off.getType());
	}
	
	@Test
	public void testTypeTwo() {
		Off off = new Off(createLed());
		assertEquals("Spegni", off.getType());
	}
	
	@Test
	public void testLedOne() {
		Off off = new Off("key", 2);
		assertNull(off.getLed());
	}
	
	@Test
	public void testLedTwo() {
		Off off = new Off(createLed());
		assertEquals(createLed().toString(), off.getLed().toString());
	}
	
	@Test
	public void testKeyOne() {
		Off off = new Off("key", 2);
		assertEquals("key", off.getKey());
	}
	
	@Test
	public void testKeyTwo() {
		Off off = new Off(createLed());
		assertEquals("key", off.getKey());
	}
	
	@Test
	public void testPositionOne() {
		Off off = new Off("key", 2);
		assertEquals(2, off.getPosition());
	}
	
	@Test
	public void testPositionTwo() {
		Off off = new Off(createLed());
		assertEquals(2, off.getPosition());
	}
	
}
