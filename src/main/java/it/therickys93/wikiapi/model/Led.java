package it.therickys93.wikiapi.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Led {

	private static final String POSITION = "position";
	private static final String KEY = "key";
	private static final String NAME = "name";
	private String name;
	private String key;
	private int position;
	
	public Led(String name, String key, int position) {
		this.name = name;
		this.key = key;
		this.position = position;
	}

	@Override
	public String toString() {
		return "Led [name=" + name + ", key=" + key + ", position=" + position + "]";
	}

	public Led() {
		this(NAME, KEY, 0);
	}

	public String getKey() {
		return this.key;
	}

	public int getPosition() {
		return this.position;
	}

	public JsonObject toJson() {
		JsonObject home = new JsonObject();
		home.addProperty(NAME, this.name);
		home.addProperty(KEY, this.key);
		home.addProperty(POSITION, this.position);
		return home;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public static Led fromJson(String jsonString) {
		Led led = new Led();
		JsonParser parser = new JsonParser();
		JsonElement json = parser.parse(jsonString);
		led.setName(json.getAsJsonObject().get(NAME).getAsString());
		led.setKey(json.getAsJsonObject().get(KEY).getAsString());
		led.setPosition(json.getAsJsonObject().get(POSITION).getAsInt());
		return led;
	}

}
