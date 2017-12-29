package it.therickys93.wikiapi;

public class Off implements Sendable {

	private String method;
	private String endpoint;
	
	public Off(String key, int led) {
		this.method = "GET";
		this.endpoint = "/off/" + key + "/" + led;
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
