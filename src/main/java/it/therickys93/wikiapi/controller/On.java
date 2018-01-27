package it.therickys93.wikiapi.controller;

import it.therickys93.wikiapi.model.Led;

public class On implements Sendable {

	private String method;
	private String endpoint;
	
	public On(String key, int led) {
		this.method = "GET";
		this.endpoint = "/on/" + key + "/" + led;
	}

	public On(Led led) {
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

}
