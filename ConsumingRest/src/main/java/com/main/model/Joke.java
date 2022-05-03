package com.main.model;

import java.io.Serializable;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Joke implements Serializable {
	

	private long id;
	private String type;
	private String joke;
	
	

	public Joke() {
		super();
		
	}
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
		return "Joke [id=" + id + ", type=" + type + ", joke=" + joke + "]";
	}

}
