package com.github.ryurain0309.jhs.http.common;

public class ResponseCookie {
    private final String name;
    private final String value;
    private final String domain;
    private final String path;
    private final boolean httpOnly;
    private final boolean secure;
    private final int maxAge;
    private final String sameSite;

    public ResponseCookie(Builder builder) {
        this.name = builder.name;
        this.value = builder.value;
        this.domain = builder.domain;
        this.path = builder.path;
        this.httpOnly = builder.httpOnly;
        this.secure = builder.secure;
        this.maxAge = builder.maxAge;
        this.sameSite = builder.sameSite;
    }

    public static Builder from(String name, String value) {
        return new Builder(name, value);
    }

    @Override
    public String toString() {
        StringBuilder cookie = new StringBuilder();
        cookie.append(name).append("=").append(value);
        if (domain != null) cookie.append("; Domain=").append(domain);
        if (path != null) cookie.append("; Path=").append(path);
        if (httpOnly) cookie.append("; HttpOnly");
        if (secure) cookie.append("; Secure");
        if (maxAge >= 0) cookie.append("; Max-Age=").append(maxAge);
        if (sameSite != null) cookie.append("; SameSite=").append(sameSite);

        return cookie.toString();
    }

    public static class Builder {
        private final String name;
        private final String value;
        private String domain;
        private String path;
        private boolean httpOnly;
        private boolean secure;
        private int maxAge = -1;
        private String sameSite;

        public Builder(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public Builder domain(String domain) {
            this.domain = domain;
            return this;
        }

        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public Builder httpOnly(boolean httpOnly) {
            this.httpOnly = httpOnly;
            return this;
        }

        public Builder secure(boolean secure) {
            this.secure = secure;
            return this;
        }

        public Builder maxAge(int maxAge) {
            this.maxAge = maxAge;
            return this;
        }

        public Builder sameSite(String sameSite) {
            this.sameSite = sameSite;
            return this;
        }

        public ResponseCookie build() {
            return new ResponseCookie(this);
        }
    }
}
