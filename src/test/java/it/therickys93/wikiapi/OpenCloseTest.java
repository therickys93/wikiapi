package it.therickys93.wikiapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import it.therickys93.wikiapi.controller.OpenClose;
import it.therickys93.wikiapi.model.Led;

public class OpenCloseTest {

	@Test
	public void testMethod(){
		OpenClose openclose = new OpenClose("key", 1);
		assertEquals("GET", openclose.method());
	}
	
	@Test
	public void testEndpoint(){
		OpenClose openclose = new OpenClose("key", 1);
		assertEquals("/openclose/key/1", openclose.endpoint());
	}
	
	@Test
	public void testWithLedConstructor(){
		OpenClose openclose = new OpenClose(createLed());
		assertEquals("/openclose/key/1", openclose.endpoint());
	}
	
	@Test
	public void testJson(){
		OpenClose openclose = new OpenClose("key", 2);
		assertNull(openclose.toJson());
	}
	
	private Led createLed(){
		Led led = new Led();
		led.setName("name");
		led.setKey("key");
		led.setPosition(1);
		return led;
	}
	
}
