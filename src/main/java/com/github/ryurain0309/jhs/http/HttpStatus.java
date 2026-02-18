package com.github.ryurain0309.jhs.http;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum HttpStatus {
    OK(200, "OK"),
    CREATED(201, "Created"),
    NO_CONTENT(204, "No Content"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");


    private static final Map<Integer, HttpStatus> STATUS_MAP;

    static {
        Map<Integer, HttpStatus> map = new HashMap<>();
        for (HttpStatus status : values()) {
            map.put(status.code, status);
        }
        STATUS_MAP = Collections.unmodifiableMap(map);
    }

    private final int code;
    private final String reasonPhrase;

    HttpStatus(int code, String reasonPhrase) {
        this.code = code;
        this.reasonPhrase = reasonPhrase;
    }

    public static HttpStatus fromCode(int statusCode) {
        return STATUS_MAP.getOrDefault(statusCode, INTERNAL_SERVER_ERROR);
    }

    public int getCode() {
        return code;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }
}
