package it.therickys93.wikiapi.controller;

import com.google.gson.JsonElement;
import it.therickys93.wikiapi.model.Led;

public class On implements Sendable {
	private String method;
	private String endpoint;
	private String type;
	private Led led;
	private String key;
	private int position;
	
	public On(String key, int led) {
		this.method = "GET";
		this.endpoint = "/on/" + key + "/" + led;
		this.type = "Accendi";
		this.key = key;
		this.position = led;
	}

	public On(Led led) {
		this(led.getKey(), led.getPosition());
		this.led = led;
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

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public Led getLed() {
		return this.led;
	}

	@Override
	public String getKey() {
		return this.key;
	}

	@Override
	public int getPosition() {
		return this.position;
	}

}
