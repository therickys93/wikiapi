package it.therickys93.wikiapi.controller;

import com.google.gson.JsonElement;

import it.therickys93.wikiapi.model.Led;
import it.therickys93.wikiapi.model.Sensor;

public class Sensors implements Sendable {
	private String method;
	private String endpoint;
	private String type;
	private Sensor sensor;
	private Led led;
	private String key;
	private int position;
	
	private Sensors(String key) {
		this.method = "GET";
		this.endpoint = "/sensors/" + key;
		this.type = "Sensors";
		this.sensor = null;
		this.key = key;
		this.position = -1;
		this.led = null;
	}

	public Sensors(String key, int position) {
		this(key);
		this.position = position;
		this.endpoint = "/sensors/" + key + "/" + position;
	}

	public Sensors(Sensor sensor) {
		this(sensor.getKey(), sensor.getPosition());
		this.sensor = sensor;
	}

	@Override
	public String endpoint() {
		return this.endpoint;
	}

	@Override
	public String method() {
		return this.method;
	}

	@Override
	public JsonElement toJson() {
		return null;
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public Led getLed() {
		return this.led;
	}

	@Override
	public String getKey() {
		return this.key;
	}

	@Override
	public int getPosition() {
		return this.position;
	}
	
	public Sensor getSensor(){
		return this.sensor;
	}
	
}
