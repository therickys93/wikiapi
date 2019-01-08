package it.therickys93.wikiapi.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WikiRequest {

	private static final String REQUEST = "request";
	private static final String USER_ID = "user_id";

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

	public static List<String> readMessageWithUserID(String request) {
		try {
			JsonParser parser = new JsonParser();
			JsonObject jsonRequest = (JsonObject) parser.parse(request);
			String message = jsonRequest.get(REQUEST).getAsString();
			String user_id = jsonRequest.get(USER_ID).getAsString();
			List<String> response = new ArrayList<String>();
			response.add(message);
			response.add(user_id);
			return response;
		} catch (Exception e){
			return null;
		}
	}

}
