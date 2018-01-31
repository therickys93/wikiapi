package it.therickys93.wikiapi.controller;

public class Status implements Sendable {

	private String method;
	private String endpoint;
	
	public Status(String key) {
		this.method = "GET";
		this.endpoint = "/status/" + key;
	}

	@Override
	public String endpoint() {
		return this.endpoint;
	}

	@Override
	public String method() {
		return this.method;
	}

}
