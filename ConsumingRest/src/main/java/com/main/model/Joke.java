package com.main.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//any type that is not bound in this type should be ignored
@JsonIgnoreProperties(ignoreUnknown = true)
public class Joke {

	// instead of following the variable no you can use quotetype instead
	// @JsonProperty("quotetype")
	private long id;
	private String type;
	private String joke;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJoke() {
		return joke;
	}

	public void setJoke(String joke) {
		this.joke = joke;
	}

	@Override
	public String toString() {
		return "Joke [type=" + type + ", joke=" + joke + "]";
	}

}
