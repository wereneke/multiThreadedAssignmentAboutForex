package com.werkasowa.fx.util;

import java.util.LinkedList;
import java.util.List;

public class UrlBuilder {
    private String baseUrl = "";
    private List<String> pathParameters = new LinkedList<>();
    private List<String> queryParameters = new LinkedList<>();

    public UrlBuilder() {}

    public UrlBuilder withBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public UrlBuilder withPathParameter(String parameter) {
        pathParameters.add(parameter);
        return this;
    }

    public UrlBuilder withQueryParameter(String parameter) {
        queryParameters.add(parameter);
        return this;
    }

    public String build() {
        String questionMark = "?";
        String ampersandMark = "&";
        StringBuilder sb = new StringBuilder();
        sb.append(baseUrl);
        String path = pathParameters.stream().reduce("", (acc, next) -> acc + "/" + next);
        sb.append(path);
        if (queryParameters.size() > 0) {
            sb.append(questionMark);
            String query = String.join(ampersandMark, queryParameters);
            sb.append(query);
        }
        return sb.toString();
    }
}
