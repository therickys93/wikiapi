package it.therickys93.wikiapi.controller;

public class Home implements Sendable {
	private String method;
	private String endpoint;
	
	public Home() {
		this.method = "GET";
		this.endpoint = "/";
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
