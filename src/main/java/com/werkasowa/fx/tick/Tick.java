package com.werkasowa.fx.tick;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tick {

    String symbol;
    float price;
    float bid;
    float ask;
    int timestamp;

    public Tick(String symbol, float price, float bid, float ask, int timestamp) {
        this.symbol = symbol;
        this.price = price;
        this.bid = bid;
        this.ask = ask;
        this.timestamp = timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public float getPrice() {
        return price;
    }

    public float getBid() {
        return bid;
    }

    public float getAsk() {
        return ask;
    }

    public int getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {

        return String.format("%s | price: %f | bid: %f | ask: %f", symbol, price, bid, ask);
    }
}
