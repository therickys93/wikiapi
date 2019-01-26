package it.therickys93.wikiapi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.therickys93.wikiapi.controller.Home;

public class HomeTest {
	
	@Test
	public void testMethod(){
		Home home = new Home();
		assertEquals("GET", home.method());
	}
	
	@Test
	public void testEndpoint(){
		Home home = new Home();
		assertEquals("/", home.endpoint());
	}
	
	@Test
	public void testJson(){
		Home home = new Home();
		assertNull(home.toJson());
	}
	
	@Test
	public void testType() {
		Home home = new Home();
		assertEquals("Home", home.getType());
	}
	
	@Test
	public void testLed() {
		Home home = new Home();
		assertNull(home.getLed());
	}
	
	@Test
	public void testKey() {
		Home home = new Home();
		assertNull(home.getKey());
	}
	
	@Test
	public void testPosition(){
		Home home = new Home();
		assertEquals(-1, home.getPosition());
	}
}
