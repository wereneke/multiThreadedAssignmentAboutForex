package com.werkasowa.fx.tick;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DeserializeTick {

    public Tick readJson(String json) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        return gson.fromJson(json, Tick.class);
    }

}
