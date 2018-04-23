package com.werkasowa.fx.runnable;

import com.werkasowa.fx.tick.TickContainer;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Printer {

    private String prompt = "enter \n" +
            ".quit          to quit the application \n" +
            "rm [tick]      to stop tracking specified tick \n" +
            "add [tick]     to start tracking specified tick \n" +
            "[enter key]    to be in writing mode \n";


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
