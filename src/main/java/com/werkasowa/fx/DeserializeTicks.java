package com.werkasowa.fx;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Collection;


public class DeserializeTicks {

    Gson gson = new Gson();
    JsonParser parser = new JsonParser();

    public boolean tick(String json) {

        Collection collection = new ArrayList();
        JsonArray array = parser.parse(json).getAsJsonArray();
        for (JsonElement o: array) {
            collection.add(gson.fromJson(o, String.class));
        }

        return false;
    }

    public static void main(String[] args) {

    }

}
