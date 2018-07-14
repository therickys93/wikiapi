package it.therickys93.wikiapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import it.therickys93.wikiapi.controller.WikiRequest;
import it.therickys93.wikiapi.controller.WikiResponse;

public class WikiRequestAndResponseTest {

	@Test
	public void testReadRequest() {
		assertEquals("ciao", WikiRequest.readMessage("{\"request\":\"ciao\"}"));
		assertNull(WikiRequest.readMessage(""));
	}
	
	@Test
	public void testWriteRequest(){
		assertEquals("{\"request\":\"ciao\"}", WikiRequest.writeMessage("ciao"));
		assertEquals("{\"request\":\"\"}", WikiRequest.writeMessage(""));
	}
	
	@Test
	public void testSendResponse() {
		assertEquals(createWikiResponse("ciao"), WikiResponse.sendMessage("ciao"));
	}
	
	@Test
	public void testWriteMessage(){
		assertEquals("{\"response\":\"ciao\"}", WikiResponse.writeMessage("ciao"));
		assertEquals("{\"response\":\"\"}", WikiResponse.writeMessage(""));
	}
	
	@Test
	public void testReadMessage(){
		assertEquals("ciao", WikiResponse.readMessage("{\"response\":\"ciao\"}"));
		assertNull(WikiResponse.readMessage("{\"pippo\":\"ciao\"}"));
	}
	
	@Test
	public void testImproveCodeCoverage() {
		WikiRequest request = new WikiRequest();
		request.toString();
		WikiResponse response = new WikiResponse();
		response.toString();
	}
	
	private Map<String, String> createWikiResponse(String message) {
		Map<String, String> response = new HashMap<String, String>();
		response.put("response", message);
		return response;
	}

	
}
