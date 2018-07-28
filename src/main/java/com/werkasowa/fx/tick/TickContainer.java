package com.werkasowa.fx.tick;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TickContainer implements Runnable {

    private String pairs = new String();
    private StringBuilder sb = new StringBuilder();
    private RestTemplate restTemplate = new RestTemplate();
    private Tick[] ticks = new Tick[0];
    private String[] available = new String[0];

    private void updateTicks() {

        this.ticks = restTemplate.getForObject(createURL(), Tick[].class);
    }

    private void setAvailable() {
        String url = "https://forex.1forge.com/1.0.3/symbols?api_key=r5WczlowKoennZAzRD6hNppugGxVATMR";
        this.available = restTemplate.getForObject(url, String[].class);
    }
    private String createURL() {
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

    public Tick[] getTicks() {
        return ticks;
    }

    @Override
    public void run() {

        setAvailable();

        try {
            while (!Thread.interrupted()) {

                updateTicks();
                Thread.sleep(5000);

            }
        }catch (InterruptedException e) {}

    }
}
