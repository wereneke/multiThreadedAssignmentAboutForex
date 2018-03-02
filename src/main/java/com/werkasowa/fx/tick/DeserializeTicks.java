package com.werkasowa.fx.tick;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;

public class DeserializeTicks {

    public Collection<Tick> readJson(String json) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        Type listType = new TypeToken<Collection<Tick>>(){}.getType();
        return gson.fromJson(json, listType);
    }

}
