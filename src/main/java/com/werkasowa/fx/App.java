package com.werkasowa.fx;

import java.util.ArrayList;
import java.lang.reflect.Type;
import java.util.Collection;

import com.google.gson.reflect.TypeToken;

public class App {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        DeserializeTicks deserializeTicks = new DeserializeTicks();
        GetTickJson http = new GetTickJson();
        String json = http.sendGet();

        ArrayList<Tick> ticks = deserializeTicks.readJson(json);

        ticks.forEach(System.out::println);

    }
}
