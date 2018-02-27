package com.werkasowa.fx;

public class App {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        GetTickJson http = new GetTickJson();
        http.sendGet();
    }
}
