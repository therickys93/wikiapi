package it.therickys93.wikiapi.controller;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WikiResponse {

	private static final String RESPONSE = "response";

	public static Map<String, String> sendMessage(String message) {
		Map<String, String> response = new HashMap<String, String>();
		response.put(RESPONSE, message);
		return response;
	}

	public static String writeMessage(String message) {
		JsonObject json = new JsonObject();
		json.addProperty(RESPONSE, message);
		return json.toString();
	}

	public static String readMessage(String message) {
		try {
			JsonParser parser = new JsonParser();
			JsonObject jsonRequest = (JsonObject) parser.parse(message);
			String response = jsonRequest.get(RESPONSE).getAsString();
			return response;
		} catch (Exception e){
			return null;
		}
	}

}
