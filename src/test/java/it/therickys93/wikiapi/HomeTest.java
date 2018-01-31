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
	
}
