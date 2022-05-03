package com.main.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JokeList {

	private List<Joke> list;

	
	public List<Joke> getList() {
		return list;
	}

	public void setList(List<Joke> list) {
		this.list = list;
	}


}
