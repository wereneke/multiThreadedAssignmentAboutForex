package com.werkasowa.fx.tick;

import java.math.BigDecimal;
import java.util.Date;
import java.util.TimeZone;

public record Tick(String fromCurrencyCode, String fromCurrencyName,
                   String toCurrencyCode, String toCurrencyName,
                   BigDecimal exchangeRate, Date lastRefreshed,
                   TimeZone timeZone, BigDecimal bidPrice, BigDecimal askPrice) { }
