package it.therickys93.wikiapi.controller;

public class Download implements Sendable {

	private String method;
	private String endpoint;
	
	public Download(){
		this.method = "GET";
		this.endpoint = "/download";
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
