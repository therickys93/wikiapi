package it.therickys93.wikiapi.controller;

import com.google.gson.JsonElement;

import it.therickys93.wikiapi.model.Led;

public class OpenClose implements Sendable {

	private String method;
	private String endpoint;
	
	public OpenClose(String key, int position) {
		this.method = "GET";
		this.endpoint = "/openclose/" + key + "/" + position;
	}

	public OpenClose(Led led) {
		this(led.getKey(), led.getPosition());
	}

	@Override
	public String endpoint() {
		return this.endpoint;
	}

	@Override
	public String method() {
		return this.method;
	}

	@Override
	public JsonElement toJson() {
		return null;
	}

}
