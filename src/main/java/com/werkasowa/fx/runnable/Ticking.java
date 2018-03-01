package com.werkasowa.fx.runnable;

import com.werkasowa.fx.tick.DeserializeTick;
import com.werkasowa.fx.tick.GetTickJson;
import com.werkasowa.fx.tick.Tick;
import com.werkasowa.fx.view.View;

public class Ticking extends Thread {

    View view;

    public Ticking(View view
    ) {
        this.view = view;
        this.start();
    }

    public void run() {

        DeserializeTick deserializeTick = new DeserializeTick();
        GetTickJson http = new GetTickJson();
        String pair = view.getPair();

        while (!Thread.interrupted()) {
            try {
                String json = http.sendGet(pair);
                Tick tick = deserializeTick.readJson(json);
                System.out.println(tick);
                Thread.sleep(1000);

            } catch (InterruptedException e) {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
