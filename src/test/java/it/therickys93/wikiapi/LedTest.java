package it.therickys93.wikiapi;

import static org.junit.Assert.*;
import org.junit.Test;

import com.google.gson.JsonObject;

import it.therickys93.wikiapi.model.Led;

public class LedTest {

	@Test
	public void testContructor(){
		Led home = new Led();
		assertNotNull(home.toString());
	}
	
	@Test
	public void testNotEmptyContructor(){
		Led home = new Led("name", "key", 2);
		assertNotNull(home.toString());
	}
	
	@Test
	public void testGetter(){
		Led home = new Led();
		assertEquals("name", home.getName());
		assertEquals("key", home.getKey());
		assertEquals(0, home.getPosition());
		home = new Led("nome", "chiave", 10);
		assertEquals("nome", home.getName());
		assertEquals("chiave", home.getKey());
		assertEquals(10, home.getPosition());
		
	}
	
	@Test
	public void testJson(){
		Led home = new Led("luce rossa", "arduino", 10);
		JsonObject json = home.toJson();
		assertEquals("{\"name\":\"luce rossa\",\"key\":\"arduino\",\"position\":10}", json.toString());
	}
	
	@Test
	public void testToString(){
		Led led = new Led("luce rossa", "arduino", 10);
		assertEquals("Led [name=luce rossa, key=arduino, position=10]", led.toString());
	}
	
	@Test
	public void testSetter(){
		Led led = new Led();
		led.setName("luce rossa");
		assertEquals("luce rossa", led.getName());
		led.setKey("arduino");
		assertEquals("arduino", led.getKey());
		led.setPosition(10);
		assertEquals(10, led.getPosition());
		assertEquals("Led [name=luce rossa, key=arduino, position=10]", led.toString());
	}
	
	@Test
	public void testFromJson(){
		Led led = Led.fromJson("{\"name\":\"luce rossa\",\"key\":\"arduino\",\"position\":10}");
		assertEquals("luce rossa", led.getName());
		assertEquals("arduino", led.getKey());
		assertEquals(10, led.getPosition());
	}
}
