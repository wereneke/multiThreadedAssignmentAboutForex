package com.werkasowa.fx.runnable;

import com.werkasowa.fx.tick.Tick;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Printer implements Runnable {

    private Tick[] ticks = new Tick[1];

    public void run() {
        try {
            Arrays.asList(ticks).forEach(System.out::println);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setTicks(Tick[] ticks) {
        this.ticks = ticks;
    }
}
