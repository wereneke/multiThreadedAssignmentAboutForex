package com.werkasowa.fx.runnable;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Listener implements Runnable {

    private Scanner scanner;
    private String input;

    public Listener() {
        this.scanner  = new Scanner(System.in);
        this.input = "";
    }

    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            String input = listen();
            if (input != null) {
                this.input = input;
            }

        }
        scanner.close();
    }

    private String listen() {

        String input = null;
        if (scanner.hasNextLine()) {
           input = scanner.nextLine();
        }
        return input;
    }

    public String getInput() {
        return input;
    }
}

