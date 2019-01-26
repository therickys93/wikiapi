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
	
	@Test
	public void testJson(){
		On on = new On("key", 2);
		assertNull(on.toJson());
	}
	
	private Led createLed(){
		Led led = new Led();
		led.setName("name");
		led.setKey("key");
		led.setPosition(1);
		return led;
	}
	
	@Test
	public void testTypeOne() {
		On on = new On("key", 2);
		assertEquals("Accendi", on.getType());
	}
	
	@Test
	public void testTypeTwo() {
		On on = new On(createLed());
		assertEquals("Accendi", on.getType());
	}
	
	@Test
	public void testLedOne() {
		On on = new On("key", 2);
		assertNull(on.getLed());
	}
	
	@Test
	public void testLedTwo() {
		On on = new On(createLed());
		assertEquals(createLed().toString(), on.getLed().toString());
	}
	
	@Test
	public void testKeyOne() {
		On on = new On("key", 2);
		assertEquals("key", on.getKey());
	}
	
	@Test
	public void testKeyTwo() {
		On on = new On(createLed());
		assertEquals("key", on.getKey());
	}
	
	@Test
	public void testPositionOne() {
		On on = new On("key", 2);
		assertEquals(2, on.getPosition());
	}
	
	@Test
	public void testPositionTwo() {
		On on = new On(createLed());
		assertEquals(1, on.getPosition());
	}
	
}
