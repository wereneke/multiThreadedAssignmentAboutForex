package com.werkasowa.fx.runnable;

import com.werkasowa.fx.tick.DeserializeTicks;
import com.werkasowa.fx.tick.GetTicksJson;
import com.werkasowa.fx.tick.Tick;

import java.util.ArrayList;
import java.util.Collection;

public class TickContainer implements Runnable {

    public static Collection<Tick> activeTicks;

    private DeserializeTicks deserializeTicks = new DeserializeTicks();
    private GetTicksJson http = new GetTicksJson();

    public TickContainer(String pairs) {
        this.activeTicks = getTicks(pairs);
    }

    private Collection<Tick> getTicks(String pairs) {
        Collection<Tick> ticks = new ArrayList<>();

        try {
            String json = http.sendGet(pairs);
            ticks = deserializeTicks.readJson(json);
        } catch (Exception e) {

        }

        return ticks;
    }

    @Override
    public void run() {

    }
}
