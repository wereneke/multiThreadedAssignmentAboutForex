package com.werkasowa.fx;

import com.werkasowa.fx.tick.Tick;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class App {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        String pairs = "EURUSD";
        String url = "https://forex.1forge.com/1.0.3/quotes?pairs="
                + pairs + "&api_key=r5WczlowKoennZAzRD6hNppugGxVATMR";
        ResponseEntity<List<Tick>> ticksResponse =
                restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Tick>>() {
                });

        List<Tick> ticks = ticksResponse.getBody();

        for (Tick tick: ticks) {
            System.out.println(tick);
        }
    }
}
