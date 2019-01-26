package it.therickys93.wikiapi.controller;

import com.google.gson.JsonElement;
import it.therickys93.wikiapi.model.Led;

public interface Sendable {
	public String endpoint();
	public String method();
	public JsonElement toJson();
	public String getType();
	public Led getLed();
	public String getKey();
	public int getPosition();
}
