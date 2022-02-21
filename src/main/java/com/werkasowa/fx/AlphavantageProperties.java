package com.werkasowa.fx;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class AlphavantageProperties {

    static Properties properties;

    private static String getRootPath() {
        return Thread.currentThread()
                .getContextClassLoader()
                .getResource("")
                .getPath();
    }

    static void instantiate() throws IOException {
        String pathToResources = getRootPath() + "alphavantage.properties";
        properties = new Properties();
        properties.load(new FileInputStream(pathToResources));
    }

    static Properties useProperties() throws IOException {
        if (Objects.isNull(properties)) instantiate();
        return properties;
    }
    public static String getUrl() throws IOException {
        String baseUrl = useProperties().getProperty("base_url");
        String key = useProperties().getProperty("key");
        String function = useProperties().getProperty("function");
        String from_currency = "from_currency";
        String to_currency = "to_currency";
        String apikey = useProperties().getProperty("apikey");
        return String.format("", baseUrl);
    }
}
