package com.werkasowa.fx;


import com.werkasowa.fx.runnable.TickContainer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        TickContainer ticks = new TickContainer();

        ticks.addPair("EURUSD");

        Thread ticking = new Thread(ticks);
        ticking.start();

        while (ticking.isAlive()) {
            Arrays.asList(ticks.getTicks()).forEach(System.out::println);
        }
    }
}
