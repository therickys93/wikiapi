package it.therickys93.wikiapi.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Response {

	private static final String SUCCESS = "success";
	private static final String STATUS = "status";
	private boolean ok;
	private String message;
	
	public static Response parseSuccess(String string) {
		JsonParser parser = new JsonParser();
		JsonObject status = parser.parse(string).getAsJsonObject();
		boolean ok = status.get(SUCCESS).getAsBoolean();
		String message;
		if(status.get(STATUS) != null){
			message = status.get(STATUS).getAsString();
		} else {
			message = null;
		}
		return new Response(ok, message);
	}
	
	private Response(boolean ok, String message){
		this.ok = ok;
		this.message = message;
	}
	
	public boolean ok() {
		return this.ok;
	}

	public String message() {
		return this.message;
	}
	
}
