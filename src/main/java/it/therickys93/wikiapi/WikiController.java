package it.therickys93.wikiapi;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WikiController {

	private String server;
	private OkHttpClient client;
	
	public WikiController(String server) {
		this.server = server;
		this.client = new OkHttpClient();
	}

	public String execute(Sendable sendable) throws IOException {
		if(sendable.method() == "GET")
			return this.getMethod(sendable);
		return null;
	}
	
	public String getMethod(Sendable request) throws IOException {
		Request requestAdd = new Request.Builder().url(this.server + request.endpoint()).build();
		Response response = client.newCall(requestAdd).execute();
		return response.body().string();
	}

}
