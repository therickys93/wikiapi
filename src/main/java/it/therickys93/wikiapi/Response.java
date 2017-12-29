package it.therickys93.wikiapi;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Response {

	private static final String SUCCESS = "success";
	private boolean ok;
	
	public static Response parseSuccess(String string) {
		JsonParser parser = new JsonParser();
		JsonObject status = parser.parse(string).getAsJsonObject();
		boolean ok = status.get(SUCCESS).getAsBoolean();
		return new Response(ok);
	}
	
	private Response(boolean ok){
		this.ok = ok;
	}
	
	public boolean ok() {
		return this.ok;
	}
	
}
