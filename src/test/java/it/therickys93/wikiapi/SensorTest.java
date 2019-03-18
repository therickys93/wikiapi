package it.therickys93.wikiapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.google.gson.JsonObject;

import it.therickys93.wikiapi.model.Sensor;

public class SensorTest {
	@Test
	public void testContructor(){
		Sensor sensor = new Sensor();
		assertNotNull(sensor.toString());
	}
	
	@Test
	public void testNotEmptyContructor(){
		Sensor sensor = new Sensor("name", "key", 2);
		assertNotNull(sensor.toString());
	}
	
	@Test
	public void testGetter(){
		Sensor sensor = new Sensor();
		assertEquals("name", sensor.getName());
		assertEquals("key", sensor.getKey());
		assertEquals(0, sensor.getPosition());
		sensor = new Sensor("nome", "chiave", 10);
		assertEquals("nome", sensor.getName());
		assertEquals("chiave", sensor.getKey());
		assertEquals(10, sensor.getPosition());
		
	}
	
	@Test
	public void testJson(){
		Sensor sensor = new Sensor("luce rossa", "arduino", 10);
		JsonObject json = sensor.toJson();
		assertEquals("{\"name\":\"luce rossa\",\"key\":\"arduino\",\"position\":10}", json.toString());
	}
	
	@Test
	public void testToString(){
		Sensor sensor = new Sensor("luce rossa", "arduino", 10);
		assertEquals("Sensor [name=luce rossa, key=arduino, position=10]", sensor.toString());
	}
	
	@Test
	public void testSetter(){
		Sensor sensor = new Sensor();
		sensor.setName("luce rossa");
		assertEquals("luce rossa", sensor.getName());
		sensor.setKey("arduino");
		assertEquals("arduino", sensor.getKey());
		sensor.setPosition(10);
		assertEquals(10, sensor.getPosition());
		assertEquals("Sensor [name=luce rossa, key=arduino, position=10]", sensor.toString());
	}
	
	@Test
	public void testFromJson(){
		Sensor sensor = Sensor.fromJson("{\"name\":\"luce rossa\",\"key\":\"arduino\",\"position\":10}");
		assertEquals("luce rossa", sensor.getName());
		assertEquals("arduino", sensor.getKey());
		assertEquals(10, sensor.getPosition());
	}

}
