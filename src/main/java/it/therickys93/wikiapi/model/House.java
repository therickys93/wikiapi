package it.therickys93.wikiapi.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class House {

	private List<Led> leds;
	
	@Override
	public String toString() {
		return "House [leds=" + leds + "]";
	}

	public House(){
		this.leds = new ArrayList<Led>();
	}
	
	public int getLedCount() {
		return this.leds.size();
	}

	public boolean addLed(Led led) {
		for(Led l : this.leds){
			if(led.getName().equals(l.getName()) || (led.getPosition() == l.getPosition() && led.getKey().equals(l.getKey()))){
				return false;
			}
		}
		this.leds.add(led);
		return true;
	}

	public JsonArray toJson() {
		JsonArray array = new JsonArray();
		for(Led led : this.leds){
			array.add(led.toJson());
		}
		return array.getAsJsonArray();
	}

	public static House fromJson(String jsonString) {
		House house = new House();
		JsonParser parser = new JsonParser();
		JsonArray array = parser.parse(jsonString).getAsJsonArray();
		JsonObject object;
		Led led;
		for(int index = 0; index < array.size(); index++){
			object = array.get(index).getAsJsonObject();
			led = Led.fromJson(object.toString());
			house.addLed(led);
		}
		return house;
	}

	public Led getLedByName(String name) {
		for(Led led : this.leds){
			if(led.getName().equals(name)){
				return led;
			}
		}
		return null;
	}

	public Led getLedAt(int i) {
		return this.leds.get(i);
	}

	public boolean removeLedByName(String name) {
		Led led = this.getLedByName(name);
		return this.leds.remove(led);
	}

	public boolean removeLedAt(int index) {
		Led led = this.leds.remove(index);
		return (led != null) ? true : false;
	}

}
