package com.werkasowa.fx.runnable;

import java.util.Scanner;

public class Listener implements Runnable {


    private Thread printingThread;

    public Listener(Thread tPr) {
        this.printingThread = tPr;
    }

    public void run() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                System.out.println("Enter Key pressed.");
                printingThread.interrupt();
                scanner.close();
            }
//                Thread.sleep(1000);
        }
    }
}
