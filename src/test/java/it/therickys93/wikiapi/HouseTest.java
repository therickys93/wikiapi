package it.therickys93.wikiapi;

import static org.junit.Assert.*;
import org.junit.Test;

import it.therickys93.wikiapi.model.House;
import it.therickys93.wikiapi.model.Led;

public class HouseTest {

	@Test
	public void testContructor(){
		House house = new House();
		assertNotNull(house.toString());
	}
	
	@Test
	public void testCountLeds(){
		House house = new House();
		assertEquals(0, house.getLedCount());
	}
	
	@Test
	public void testAddLed(){
		House house = new House();
		house.addLed(new Led("luce rossa", "arduino", 10));
		house.addLed(new Led("luce gialla", "arduino", 11));
		house.addLed(new Led("luce verde", "arduino", 12));
		assertEquals(3, house.getLedCount());
	}
	
	@Test
	public void testToString(){
		House house = new House();
		house.addLed(new Led("luce rossa", "arduino", 10));
		house.addLed(new Led("luce gialla", "arduino", 11));
		assertEquals("House [leds="
				+ "[Led [name=luce rossa, key=arduino, position=10], "
				+ "Led [name=luce gialla, key=arduino, position=11]"
				+ "]]", house.toString());
	}
	
	@Test
	public void testLedMustBeUnique(){
		House house = new House();
		assertTrue(house.addLed(new Led("luce rossa", "arduino", 10)));
		assertFalse(house.addLed(new Led("luce rossa", "chiave", 11)));  // stesso nome
		assertFalse(house.addLed(new Led("luce bianca", "arduino", 10))); // stessa combinazione di posto e chiave
		assertEquals(1, house.getLedCount());
	}
	
	@Test
	public void testGetLedByName(){
		House house = new House();
		house.addLed(new Led("luce rossa", "arduino", 10));
		house.addLed(new Led("luce gialla", "arduino", 11));
		assertEquals(2, house.getLedCount());
		Led red = house.getLedByName("luce rossa");
		assertEquals("Led [name=luce rossa, key=arduino, position=10]", red.toString());
		assertNull(house.getLedByName("luce verde"));
	}
	
	@Test
	public void testToJson(){
		House house = new House();
		house.addLed(new Led("luce rossa", "arduino", 10));
		house.addLed(new Led("luce gialla", "arduino", 11));
		assertEquals("[{\"name\":\"luce rossa\",\"key\":\"arduino\",\"position\":10}"
				+ ",{\"name\":\"luce gialla\",\"key\":\"arduino\",\"position\":11}]", house.toJson().toString());
	}
		
	@Test
	public void testFromJson(){
		House house = House.fromJson("[{\"name\":\"luce rossa\",\"key\":\"arduino\",\"position\":10},"
				+ "{\"name\":\"luce gialla\",\"key\":\"arduino\",\"position\":11}]");
		assertEquals(2, house.getLedCount());
		Led red = house.getLedByName("luce rossa");
		assertEquals("Led [name=luce rossa, key=arduino, position=10]", red.toString());
		Led yellow = house.getLedByName("luce gialla");
		assertEquals("Led [name=luce gialla, key=arduino, position=11]", yellow.toString());
	}
	
}
