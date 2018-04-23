package com.werkasowa.fx.runnable;

import com.werkasowa.fx.tick.TickContainer;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Printer {

    private String prompt = "enter" +
            ".quit          to quit the application" +
            "rm [tick]      to stop tracking specified tick" +
            "add [tick]     to start tracking specified tick" +
            "[enter key]    to be in writing mode";


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
