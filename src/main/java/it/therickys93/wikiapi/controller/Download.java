package it.therickys93.wikiapi.controller;

import com.google.gson.JsonElement;
import it.therickys93.wikiapi.model.Led;

public class Download implements Sendable {

	private String method;
	private String endpoint;
	private String type;
	private Led led;
	private String key;
	private int position;
	
	public Download(){
		this.method = "GET";
		this.endpoint = "/download";
		this.type = "Scarica";
		this.led = null;
		this.key = null;
		this.position = -1;
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
