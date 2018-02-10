package it.therickys93.wikiapi.controller;

import com.google.gson.JsonElement;

import it.therickys93.wikiapi.model.House;

public class Upload implements Sendable {

	private String method;
	private String endpoint;
	private House house;
	
	public Upload(House house){
		this.endpoint = "/upload";
		this.method = "POST";
		this.house = house;
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

}
