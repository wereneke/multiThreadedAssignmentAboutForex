package com.werkasowa.fx.runnable;

import com.werkasowa.fx.tick.DeserializeTicks;
import com.werkasowa.fx.tick.GetTicksJson;
import com.werkasowa.fx.tick.Tick;

import java.util.Collection;

public class TickContainer implements Runnable {

    public Collection<Tick> activeTicks;
    String pairs;

    private DeserializeTicks deserializeTicks = new DeserializeTicks();
    private GetTicksJson http = new GetTicksJson();

    public TickContainer(String pairs) {
        this.pairs = pairs;
        getTicks(pairs);
    }

    private void getTicks(String pairs) {

        try {
            String json = http.sendGet(pairs);
            this.activeTicks = deserializeTicks.readJson(json);
        } catch (Exception e) {}
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                getTicks(this.pairs);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {}

    }
}
