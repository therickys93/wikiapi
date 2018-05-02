package it.therickys93.wikiapi.controller;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WikiController {

	private static final String APPLICATION_JSON = "application/json; charset=utf-8";
	private String server;
	private OkHttpClient client;
	
	public WikiController(String server) {
		this.server = server;
		this.client = new OkHttpClient();
	}

	public String execute(Sendable sendable) throws IOException {
		if(sendable.method() == "GET")
			return this.getMethod(sendable);
		else if(sendable.method() == "POST")
			return this.postMethod(sendable);
		return null;
	}
	
	private String getMethod(Sendable request) throws IOException {
		Request requestAdd = new Request.Builder().url(this.server + request.endpoint()).build();
		Response response = client.newCall(requestAdd).execute();
		return response.body().string();
	}
	
	private String postMethod(Sendable request) throws IOException {
		final MediaType JSON = MediaType.parse(APPLICATION_JSON);
		RequestBody body = null;
		if(request.toJson() == null){
			body = RequestBody.create(JSON, "");
		} else {
			body = RequestBody.create(JSON, request.toJson().toString());
		}
		Request requestAdd = new Request.Builder().url(this.server + request.endpoint()).post(body).build();
		Response response = client.newCall(requestAdd).execute();
		return response.body().string();
	}

}
