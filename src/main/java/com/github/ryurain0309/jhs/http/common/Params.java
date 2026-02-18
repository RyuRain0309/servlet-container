package com.github.ryurain0309.jhs.http.common;

import java.util.HashMap;
import java.util.Map;

public class Params {
    private final Map<String, String> params = new HashMap<>();

    public void addParam(String name, String value) {
        params.put(name, value);
    }

    public String getParam(String name) {
        return params.get(name);
    }

    public Map<String, String> getParams() {
        return params;
    }
}
