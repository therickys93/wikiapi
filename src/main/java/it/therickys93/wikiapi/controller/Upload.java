package it.therickys93.wikiapi.controller;

import com.google.gson.JsonElement;
import it.therickys93.wikiapi.model.House;
import it.therickys93.wikiapi.model.Led;

public class Upload implements Sendable {

	private String method;
	private String endpoint;
	private House house;
	private String type;
	private Led led;
	private String key;
	private int position;
	
	public Upload(House house){
		this.endpoint = "/upload";
		this.method = "POST";
		this.house = house;
		this.type = "Carica";
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
		return this.house.toJson();
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
