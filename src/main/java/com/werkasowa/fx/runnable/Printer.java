package com.werkasowa.fx.runnable;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Printer {

    public void comunicate(String message) {
        System.out.println(message);
    }

    public void printTicks(TickContainer ticks) {
        Arrays.asList(ticks.getTicks()).forEach(System.out::println);

    }
}
