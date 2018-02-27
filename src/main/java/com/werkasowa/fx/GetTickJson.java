package com.werkasowa.fx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetTickJson {

    private final String USER_AGENT = "Mozilla/5.0";

    // HTTP GET request
    public String sendGet(String symbol) throws Exception {

        String url = String.format("https://forex.1forge.com/1.0.3/quotes?pairs=%s&api_key=r5WczlowKoennZAzRD6hNppugGxVATMR", symbol);

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

}