package com.werkasowa.fx.runnable;

import com.werkasowa.fx.tick.DeserializeTicks;
import com.werkasowa.fx.tick.GetTicksJson;
import com.werkasowa.fx.tick.Tick;

public class Ticking {

    private DeserializeTicks deserializeTicks = new DeserializeTicks();
    private GetTicksJson http = new GetTicksJson();
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
            this.tick = deserializeTicks.readJson(json);
        } catch (Exception e) {}
    }

    public Tick getTick() {
        return tick;
    }
}
