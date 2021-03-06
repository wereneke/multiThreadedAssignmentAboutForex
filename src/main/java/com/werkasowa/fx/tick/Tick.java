package com.werkasowa.fx.tick;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tick implements Serializable {

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

    public Tick() {}

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

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setBid(float bid) {
        this.bid = bid;
    }

    public void setAsk(float ask) {
        this.ask = ask;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {

        return String.format("%s | price: %f | bid: %f | ask: %f", symbol, price, bid, ask);
    }
}
