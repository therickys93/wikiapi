package it.therickys93.wikiapi;

public class On implements Sendable {

	private String method;
	private String endpoint;
	
	public On(String key, int led) {
		this.method = "GET";
		this.endpoint = "/on/" + key + "/" + led;
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
