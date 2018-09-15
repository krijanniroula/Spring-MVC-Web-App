package com.krijan.springapp.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.sf.json.JSONObject;

public class BothResponseBody {

	@JsonProperty("result")
	List<JSONObject> jsonObject;

	public List<JSONObject> getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(List<JSONObject> jsonObject) {
		this.jsonObject = jsonObject;
	}

	
	
}
