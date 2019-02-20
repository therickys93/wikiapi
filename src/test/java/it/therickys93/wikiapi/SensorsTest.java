package it.therickys93.wikiapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import it.therickys93.wikiapi.controller.Sensors;
import it.therickys93.wikiapi.model.Sensor;

public class SensorsTest {
	@Test
	public void testMethod(){
		Sensors sensors = new Sensors("key");
		assertEquals("GET", sensors.method());
	}
	
	@Test
	public void testEndpoint(){
		Sensors sensors = new Sensors("key");
		assertEquals("/sensors/key", sensors.endpoint());
	}
	
	@Test
	public void testJson(){
		Sensors sensors = new Sensors("key");
		assertNull(sensors.toJson());
	}
	
	@Test
	public void testType() {
		Sensors sensors = new Sensors("key");
		assertEquals("Sensors", sensors.getType());
	}
	
	@Test
	public void testSensor() {
		Sensors sensors = new Sensors("key");
		assertNull(sensors.getSensor());
	}
	
	@Test
	public void testKey() {
		Sensors sensors = new Sensors("key");
		assertEquals("key", sensors.getKey());
	}
	
	@Test
	public void testPosition(){
		Sensors sensors = new Sensors("key");
		assertEquals(-1, sensors.getPosition());
	}
	
	@Test
	public void testStatusWithPosition() {
		Sensors sensors = new Sensors("key", 1);
		assertEquals("GET", sensors.method());
		assertEquals("/sensors/key/1", sensors.endpoint());
		assertNull(sensors.toJson());
		assertEquals("Sensors", sensors.getType());
		assertNull(sensors.getSensor());
		assertNull(sensors.getLed());
		assertEquals("key", sensors.getKey());
		assertEquals(1, sensors.getPosition());
	}
	
	@Test
	public void testStatusWithSensor() {
		Sensors sensors = new Sensors(new Sensor("pippo", "key", 2));
		assertEquals("GET", sensors.method());
		assertEquals("/sensors/key/2", sensors.endpoint());
		assertNull(sensors.toJson());
		assertEquals("Sensors", sensors.getType());
		assertNull(sensors.getLed());
		assertNotNull(sensors.getSensor());
		assertEquals("key", sensors.getKey());
		assertEquals(2, sensors.getPosition());
	}
}
