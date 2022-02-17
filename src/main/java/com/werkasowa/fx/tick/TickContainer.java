package com.werkasowa.fx.tick;

import java.net.MalformedURLException;
import java.net.URL;

public class TickContainer implements Runnable {

    private String pairs;
    private final StringBuilder sb = new StringBuilder();
    private TickDto[] ticks = new TickDto[0];

    private void updateTicks() {
//        this.ticks = restTemplate.getForObject(createURL(), Tick[].class);
    }
//    https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=USD&to_currency=JPY&apikey=demo
    private String createURL() throws MalformedURLException {
        String protocol = "https";
        String host = "www.alphavantage.co/query";
        String file = "/guidelines.txt";
        URL url = new URL(protocol, host, file);
        sb.setLength(0);

        sb.append("https://forex.1forge.com/1.0.3/quotes?pairs=");
        sb.append(pairs);
        sb.append("&api_key=r5WczlowKoennZAzRD6hNppugGxVATMR");
        return sb.toString();
    }

    public void addTick(String pair) {

        if (!pairs.contains(pair)) {

            sb.setLength(0);
            if (pairs.length()!=0) {
                sb.append(pairs);
                sb.append(",");
            }
            sb.append(pair);

            pairs = sb.toString();
        }
    }

    public void removeTick(String tickName) {
        pairs = pairs.replace(tickName, "");
        pairs = pairs.replace(",,", ",");
        pairs = pairs.replace("=,", "=");
        pairs = pairs.replace(",&", "&");
    }

    public TickDto[] getTicks() {
        return ticks;
    }

    @Override
    public void run() {
        var INTERVAL = 5000L;
        try {
            while (!Thread.interrupted()) {

                updateTicks();
                Thread.sleep(INTERVAL);

            }
        } catch (InterruptedException e) {}

    }
}
