package com.werkasowa.fx.runnable;

import java.util.Scanner;

public class Listener implements Runnable {

    private final Scanner scanner;
    private String lastOrder = null;
    public boolean typing = false;

    public Listener() {
        this.scanner  = new Scanner(System.in);
    }

    public void run() {

        while (Thread.currentThread().isAlive()) {
                listen();
        }
        scanner.close();
    }

    private void listen() {

        if (scanner.hasNext()) {
            this.typing = true;
            synchronized (this) {
                lastOrder = scanner.nextLine();
                notifyAll();
            }
            this.typing = false;
        }
    }

    public String getLastOrder() {
        return lastOrder;
    }

    public void eraseLastOrder() {
        this.lastOrder = null;
    }
}

