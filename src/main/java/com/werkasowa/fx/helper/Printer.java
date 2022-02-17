package com.werkasowa.fx.helper;

import com.werkasowa.fx.tick.TickContainer;

import java.util.Arrays;

public class Printer {

    private final String prompt = """
            enter
            .quit          to quit the application
            rm [tick]      to stop tracking specified tick
            add [tick]     to start tracking specified tick
            [enter key]    to be in writing mode
            """;


    public void printPrompt() {
        communicate(prompt);
    }

    public void communicate(String message) {
        System.out.println(message);
    }

    public void printTicks(TickContainer ticks) {
        Arrays.asList(ticks.getTicks()).forEach(System.out::println);
    }
}
