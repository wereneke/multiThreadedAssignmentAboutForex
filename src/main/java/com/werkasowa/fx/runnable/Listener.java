package com.werkasowa.fx.runnable;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Listener implements Runnable {

    private Scanner scanner;
    private String lastOrder = null;
    public boolean typing = false;

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

        if (scanner.hasNext()) {
            this.typing = true;
            synchronized (this) {
                lastOrder = scanner.nextLine();
                System.out.println(lastOrder);
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

