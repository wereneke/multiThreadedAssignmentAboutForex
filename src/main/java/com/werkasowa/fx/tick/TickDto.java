package com.werkasowa.fx.tick;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.TimeZone;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TickDto implements Serializable {

    @JsonAlias({ "1. From_Currency Code" })
    String fromCurrencyCode;
    @JsonAlias({ "2. From_Currency Name" })
    String fromCurrencyName;
    @JsonAlias({ "3. To_Currency Code" })
    String toCurrencyCode;
    @JsonAlias({ "4. To_Currency Name" })
    String toCurrencyName;
    @JsonAlias({ "5. Exchange Rate" })
    BigDecimal exchangeRate;
    @JsonAlias({ "6. Last Refreshed" })
    Date lastRefreshed;
    @JsonAlias({ "7. Time Zone" })
    TimeZone timeZone;
    @JsonAlias({ "8. Bid Price" })
    BigDecimal bidPrice;
    @JsonAlias({ "9. Ask Price" })
    BigDecimal askPrice;

    public TickDto(String fromCurrencyCode, String fromCurrencyName, String toCurrencyCode, String toCurrencyName,
                   BigDecimal exchangeRate, Date lastRefreshed, TimeZone timeZone, BigDecimal bidPrice, BigDecimal askPrice) {
    }
}
