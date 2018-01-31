package it.therickys93.wikiapi.controller;

import it.therickys93.wikiapi.model.Led;

public class Off implements Sendable {

	private String method;
	private String endpoint;
	
	public Off(String key, int led) {
		this.method = "GET";
		this.endpoint = "/off/" + key + "/" + led;
	}

	public Off(Led led) {
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
