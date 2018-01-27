package it.therickys93.wikiapi;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;

import it.therickys93.wikiapi.controller.Home;
import it.therickys93.wikiapi.controller.Off;
import it.therickys93.wikiapi.controller.On;
import it.therickys93.wikiapi.controller.Reset;
import it.therickys93.wikiapi.controller.Response;
import it.therickys93.wikiapi.controller.Status;
import it.therickys93.wikiapi.controller.WikiRequest;

public class WikiRequestTest {
	
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
		WikiRequest wikicontroller = new WikiRequest("http://localhost:3000");
		String response = wikicontroller.execute(new Home());
		assertEquals("", response);
	}
	
	public void testReset() throws IOException{
		WikiRequest wikicontroller = new WikiRequest("http://localhost:3000");
		String response = wikicontroller.execute(new Reset("arduino"));
		assertEquals("", response);
	}
	
	public void testStatus() throws IOException{
		WikiRequest wikicontroller = new WikiRequest("http://localhost:3000");
		String response = wikicontroller.execute(new Status("key"));
		assertEquals("", response);
	}
	
	public void testOn() throws IOException{
		WikiRequest wikicontroller = new WikiRequest("http://localhost:3000");
		String response = wikicontroller.execute(new On("arduino", 0));
		assertEquals("", response);
	}
	
	public void testOff() throws IOException{
		WikiRequest wikicontroller = new WikiRequest("http://localhost:3000");
		String response = wikicontroller.execute(new Off("arduino", 1));
		assertEquals("", response);
	}
	
	public void testUsage() throws IOException{
		WikiRequest wikicontroller = new WikiRequest("http://localhost:3000");
		String response = wikicontroller.execute(new Home());
		assertEquals("", response);
		Response status = Response.parseSuccess(response);
		assertTrue(status.ok());
	}
}
