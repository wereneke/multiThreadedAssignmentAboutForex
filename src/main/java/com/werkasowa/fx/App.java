package com.werkasowa.fx;

import com.werkasowa.fx.tick.DeserializeTicks;
import com.werkasowa.fx.tick.GetTickJson;
import com.werkasowa.fx.tick.Tick;

import java.util.ArrayList;

public class App {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        DeserializeTicks deserializeTicks = new DeserializeTicks();
        GetTickJson http = new GetTickJson();
        String json = http.sendGet("EURUSD");

        ArrayList<Tick> ticks = deserializeTicks.readJson(json);

        ticks.forEach(System.out::println);

    }
}
