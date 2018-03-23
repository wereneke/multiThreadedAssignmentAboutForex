package com.werkasowa.fx.runnable;

import java.util.Scanner;

public class Listener implements Runnable {


    private Scanner scanner;
    private Thread printingThread;

    public Listener() {
        this.scanner  = new Scanner(System.in);
        this.printingThread = Thread.currentThread();
    }

    public void run() {

        while (!printingThread.isInterrupted()) {

            String input = listen();
            if (input != null) {
                handleInput(input);
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

    private void handleInput(String input) {

        if (input.equals(".quit")) {
            //code for closing app
        }
        if (input.startsWith("rm")) {
            String tickName = input.substring(3,9);

            // remove tickname from getting it from internet
        }
        if (input.length()==6) {

            //add input to geter from interneter
        }


    }
}
