package com.werkasowa.fx;

import java.util.ArrayList;
import java.util.List;

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
}
