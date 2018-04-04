package com.werkasowa.fx.runnable;

import com.werkasowa.fx.tick.Tick;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TickContainer implements Runnable {

    private String pairs = "";
    private StringBuilder sb = new StringBuilder();
    private RestTemplate restTemplate = new RestTemplate();

    public Tick[] getTicks() {

        Tick[] ticks = restTemplate.getForObject(createURL(), Tick[].class);

        return ticks;
    }

    private String createURL() {
        sb.setLength(0);

        sb.append("https://forex.1forge.com/1.0.3/quotes?pairs=");
        sb.append(pairs);
        sb.append("&api_key=r5WczlowKoennZAzRD6hNppugGxVATMR");
        return sb.toString();
    }

    public void addPair(String pair) {

        if (!pairs.contains(pair)) {

            sb.setLength(0);
            if (pairs.length()!=0) sb.append(",");
            sb.append(pair);

            pairs = sb.toString();
        }
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                getTicks();
                Thread.sleep(3000);
            }
        }catch (InterruptedException e) {}

    }
}
