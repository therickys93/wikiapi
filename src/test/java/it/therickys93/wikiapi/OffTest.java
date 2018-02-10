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
	
}
