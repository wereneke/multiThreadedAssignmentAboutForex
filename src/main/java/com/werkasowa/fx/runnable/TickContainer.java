package com.werkasowa.fx.runnable;

import com.werkasowa.fx.tick.Tick;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TickContainer implements Runnable {

    private String pairs = new String();
    private StringBuilder sb = new StringBuilder();
    private RestTemplate restTemplate = new RestTemplate();
    private Tick[] ticks = null;


    private void updateTicks() {

        this.ticks = restTemplate.getForObject(createURL(), Tick[].class);
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
            if (pairs.length()!=0) {
                sb.append(pairs);
                sb.append(",");
            }
            sb.append(pair);

            pairs = sb.toString();
        }
    }

    public Tick[] getTicks() {
        return ticks;
    }

    public String getPairs() {
        return pairs;
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                updateTicks();
                Thread.sleep(5000);
            }
        }catch (InterruptedException e) {}

    }
}
