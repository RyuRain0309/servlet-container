package com.github.ryurain0309.jhs.http.common;

import java.util.HashMap;
import java.util.Map;

public class Cookies {
    private final Map<String, String> cookies = new HashMap<>();

    public void addCookie(String name, String value) {
        cookies.put(name, value);
    }

    public String getCookie(String name) {
        return cookies.get(name);
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

}
