package com.werkasowa.fx.runnable;

import com.werkasowa.fx.util.Printer;
import com.werkasowa.fx.tick.TickContainer;

public class Controller implements Runnable {

    private final Printer printer;

    private final TickContainer tickContainer;
    private final Thread ticking;

    private final Listener listener;
    private final Thread listening;

    public Controller() {

        this.printer = new Printer();
        this.tickContainer = new TickContainer();
        this.ticking = new Thread(tickContainer);
        this.listener = new Listener();
        this.listening = new Thread(listener);

    }

    private void handleInput(String input) {

        if (input.equals(".quit")) {
            quit();
        } else if (input.startsWith("rm")) {
            String tickName = input.substring(3,9);
            tickContainer.removeTick(tickName);
        } else if (input.startsWith("add")) {
            String tickName = input.substring(4,10);
            tickContainer.addTick(tickName);
        } else {
            printer.printPrompt();
        }
    }

    private void quit() {
        if (ticking.isAlive()) ticking.interrupt();
        listening.interrupt();
        Thread.currentThread().interrupt();
        System.exit(0);
    }

    @Override
    public void run() {
        try {
            listening.start();
            printer.communicate("Hello, enter currency signature to get actual prices");
            printer.printPrompt();

            tickContainer.addTick("EURUSD");
            ticking.start();
            while (Thread.currentThread().isAlive()) {
                synchronized (listening) {
                    while (listener.typing) wait();
                }
                String order = listener.getLastOrder();
                if (order!=null) {
                    handleInput(order);
                    listener.eraseLastOrder();
                }
                if (tickContainer.getTicks().length!=0) {
                    printer.printTicks(tickContainer);
                }

                Thread.sleep(5000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
