package it.therickys93.wikiapi.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WikiRequest {

	private static final String REQUEST = "request";

	public static String readMessage(String request) {
		try {
			JsonParser parser = new JsonParser();
			JsonObject jsonRequest = (JsonObject) parser.parse(request);
			String message = jsonRequest.get(REQUEST).getAsString();
			return message;
		} catch (Exception e){
			return null;
		}
		
	}

	public static String writeMessage(String message) {
		JsonObject json = new JsonObject();
		json.addProperty(REQUEST, message);
		return json.toString();
	}

}
