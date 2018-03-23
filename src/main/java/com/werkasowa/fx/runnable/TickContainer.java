package com.werkasowa.fx.runnable;

import com.werkasowa.fx.tick.DeserializeTicks;
import com.werkasowa.fx.tick.GetTicksJson;
import com.werkasowa.fx.tick.Tick;

import java.util.ArrayList;

public class TickContainer implements Runnable {

    private String pairs;
    private ArrayList<Tick> ticks;
    private GetTicksJson http = new GetTicksJson();


    private ArrayList<Tick> getTicks() {

        try {
            String json = http.sendGet(pairs);
            ticks = (ArrayList<Tick>) DeserializeTicks.readJson(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticks;
    }

    public void addPair(String pair) {

        if (!pairs.contains(pair)) {

            StringBuilder sb = new StringBuilder(pairs);
            if (pairs.length()!=0) sb.append(",");
            sb.append(pair);

            pairs = sb.toString();
        }
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                getTicks();
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {}

    }
}
