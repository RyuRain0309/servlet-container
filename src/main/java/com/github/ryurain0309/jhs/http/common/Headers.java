package com.github.ryurain0309.jhs.http.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Headers {
    Map<String, List<String>> headers = new HashMap<>();

    public String getHeader(String name) {
        List<String> values = headers.get(name);
        if (values != null && !values.isEmpty()) {
            return values.getFirst();
        }
        return null;
    }

    public List<String> getHeaders(String name) {
        return headers.get(name);
    }

    public void addHeader(String name, String value) {
        headers.computeIfAbsent(name, k -> new ArrayList<>()).add(value);
    }
}
