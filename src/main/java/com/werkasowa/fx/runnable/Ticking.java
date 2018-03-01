package com.werkasowa.fx.runnable;

import com.werkasowa.fx.tick.DeserializeTick;
import com.werkasowa.fx.tick.GetTickJson;
import com.werkasowa.fx.tick.Tick;

public class Ticking {

    DeserializeTick deserializeTick = new DeserializeTick();
    GetTickJson http = new GetTickJson();
    Tick tick;


    public Ticking(String pair) {
        tick = refreshTick(pair);
    }

    public void tick() {

        while (true) {

        }
    }

    private Tick refreshTick(Tick tick) {

        try {
            String json = http.sendGet(tick.getSymbol());
            tick = deserializeTick.readJson(json);
        } catch (Exception e) {}

    }
}
