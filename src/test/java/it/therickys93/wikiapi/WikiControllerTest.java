package it.therickys93.wikiapi;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;

import it.therickys93.wikiapi.controller.Download;
import it.therickys93.wikiapi.controller.Home;
import it.therickys93.wikiapi.controller.Init;
import it.therickys93.wikiapi.controller.Off;
import it.therickys93.wikiapi.controller.On;
import it.therickys93.wikiapi.controller.OpenClose;
import it.therickys93.wikiapi.controller.Reset;
import it.therickys93.wikiapi.controller.Response;
import it.therickys93.wikiapi.controller.Sensors;
import it.therickys93.wikiapi.controller.Status;
import it.therickys93.wikiapi.controller.Upload;
import it.therickys93.wikiapi.controller.Version;
import it.therickys93.wikiapi.controller.WikiController;
import it.therickys93.wikiapi.model.House;
import it.therickys93.wikiapi.model.Sensor;

public class WikiControllerTest {
	
	@Test
	public void testOne(){
		assertEquals(1, 1);
	}
	
	@Test
	public void parseResponse(){
		Response status = Response.parseSuccess("{\"success\":true}");
		assertTrue(status.ok());
		assertNull(status.message());
		status = Response.parseSuccess("{\"success\":false}");
		assertFalse(status.ok());
		assertNull(status.message());
		status = Response.parseSuccess("{\"success\":true,\"status\":\"00\"}");
		assertTrue(status.ok());
		assertEquals("00", status.message());
	}
	
	public void testHome() throws IOException{
		WikiController wikicontroller = new WikiController("http://localhost:3000");
		String response = wikicontroller.execute(new Home());
		assertEquals("", response);
	}
	
	public void testReset() throws IOException{
		WikiController wikicontroller = new WikiController("http://localhost:3000");
		String response = wikicontroller.execute(new Reset("arduino"));
		assertEquals("", response);
	}
	
	public void testInit() throws IOException{
		WikiController wikicontroller = new WikiController("http://localhost:8080");
		String response = wikicontroller.execute(new Init("arduino"));
		assertEquals("", response);
	}
	
	public void testStatus() throws IOException{
		WikiController wikicontroller = new WikiController("http://localhost:3000");
		String response = wikicontroller.execute(new Status("key"));
		assertEquals("", response);
	}
	
	public void testStatusWithPosition() throws IOException {
		WikiController wikicontroller = new WikiController("http://localhost:8080");
		String response = wikicontroller.execute(new Status("pippo", 1));
		assertEquals("", response);
	}
	
	public void testOn() throws IOException{
		WikiController wikicontroller = new WikiController("http://localhost:3000");
		String response = wikicontroller.execute(new On("arduino", 0));
		assertEquals("", response);
	}
	
	public void testOff() throws IOException{
		WikiController wikicontroller = new WikiController("http://localhost:3000");
		String response = wikicontroller.execute(new Off("arduino", 1));
		assertEquals("", response);
	}
	
	public void testOpenClose() throws IOException {
		WikiController wikicontroller = new WikiController("http://localhost:3000");
		String response = wikicontroller.execute(new OpenClose("arduino", 1));
		assertEquals("", response);
	}
	
	public void testUsage() throws IOException{
		WikiController wikicontroller = new WikiController("http://localhost:3000");
		String response = wikicontroller.execute(new Home());
		assertEquals("", response);
		Response status = Response.parseSuccess(response);
		assertTrue(status.ok());
	}
	
	public void testDownload() throws IOException {
		WikiController wikicontroller = new WikiController("http://localhost:3000");
		String response = wikicontroller.execute(new Download());
		House house = House.fromJson(response);
		assertNotEquals("", house.toJson().toString());
	}
	
	public void testUpload() throws IOException {
		WikiController wikicontroller = new WikiController("http://localhost:3000");
		String response = wikicontroller.execute(new Upload(createHouse()));
		assertEquals("", response);
		Response status = Response.parseSuccess(response);
		assertTrue(status.ok());
	}
	
	public void testSensors() throws IOException {
		WikiController wikicontroller = new WikiController("http://localhost:8080");
		String response = wikicontroller.execute(new Sensors(new Sensor("name", "key", 1)));
		assertEquals("", response);
	}
	
	public void testVersion() throws IOException {
		WikiController wikicontroller = new WikiController("http://localhost");
		String response = wikicontroller.execute(new Version());
		assertEquals("", response);
	}
	
	private House createHouse() {
		return House.fromJson("[{\"name\":\"luce rossa\",\"key\":\"arduino\",\"position\":10},"
				+ "{\"name\":\"luce gialla\",\"key\":\"arduino\",\"position\":11}]");
	}
}
