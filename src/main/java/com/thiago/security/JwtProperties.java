package com.thiago.security;

public class JwtProperties {
    public static final String SECRET = "keySecret";
    public static final int EXPIRATION_TIME = 28800000; // 1 hour = 3600000 miliseconds
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
