package it.therickys93.wikiapi.controller;

import com.google.gson.JsonElement;

import it.therickys93.wikiapi.model.Led;

public class OpenClose implements Sendable {
	private String method;
	private String endpoint;
	private String type;
	private Led led;
	private String key;
	private int position;
	
	public OpenClose(String key, int position) {
		this.method = "GET";
		this.endpoint = "/openclose/" + key + "/" + position;
		this.type = "Apri/Chiudi";
		this.key = key;
		this.position = position;
	}

	public OpenClose(Led led) {
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
