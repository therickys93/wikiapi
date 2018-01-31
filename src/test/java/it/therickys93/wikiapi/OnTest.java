package it.therickys93.wikiapi;

import static org.junit.Assert.*;
import org.junit.Test;

import it.therickys93.wikiapi.controller.On;
import it.therickys93.wikiapi.model.Led;

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
	
	@Test
	public void testWithLedConstructor(){
		On on = new On(createLed());
		assertEquals("/on/key/1", on.endpoint());
	}
	
	private Led createLed(){
		Led led = new Led();
		led.setName("name");
		led.setKey("key");
		led.setPosition(1);
		return led;
	}
	
}
