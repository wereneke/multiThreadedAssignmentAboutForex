package com.werkasowa.fx.runnable;

import com.werkasowa.fx.tick.DeserializeTick;
import com.werkasowa.fx.tick.GetTickJson;
import com.werkasowa.fx.tick.Tick;

public class Ticking {

    private DeserializeTick deserializeTick = new DeserializeTick();
    private GetTickJson http = new GetTickJson();
    private String symbol;
    private Tick tick;


    public Ticking(String pair) {
        this.symbol = pair;
        refreshTick();
    }

    public void tick() {
        while (true) {
            refreshTick();
        }
    }

    private void refreshTick() {
        try {
            String json = http.sendGet(this.symbol);
            this.tick = deserializeTick.readJson(json);
        } catch (Exception e) {}
    }

    public Tick getTick() {
        return tick;
    }
}
