package com.main.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Embedded {

    @JsonProperty("jokes")
    List<Joke> jokes = new ArrayList<Joke>();

    public Embedded(){

    }

    public List<Joke> getJokes() {
        return jokes;
    }

    public void setJokes(List<Joke> jokes) {
        this.jokes = jokes;
    }
}
