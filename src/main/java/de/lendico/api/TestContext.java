package de.lendico.api;

import io.restassured.response.ValidatableResponse;

public class TestContext {
    public static ThreadLocal<String> key = new ThreadLocal<>();
    public static ThreadLocal<ValidatableResponse> lastResponse = new ThreadLocal<>();
}
