package it.therickys93.wikiapi;

public class Reset implements Sendable {

	private String method;
	private String endpoint;
	
	public Reset(String key) {
		this.method = "GET";
		this.endpoint = "/reset/" + key;
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
