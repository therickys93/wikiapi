package it.therickys93.wikiapi.controller;

import com.google.gson.JsonElement;

public interface Sendable {
	public String endpoint();
	public String method();
	public JsonElement toJson();
}
