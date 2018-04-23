package com.werkasowa.fx.runnable;

import java.util.Scanner;

public class Listener implements Runnable {

    private Scanner scanner;
    private String lastOrder = null;

    public Listener() {
        this.scanner  = new Scanner(System.in);
    }

    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            listen();

        }
        scanner.close();
    }

    private void listen() {

        if (scanner.hasNextLine()) {
           this.lastOrder = scanner.nextLine();
        }

    }

    public String getLastOrder() {
        return lastOrder;
    }

}
