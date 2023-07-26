package com.example;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import extensions.ApiTestExtension;

import javax.servlet.http.HttpServletResponse;

import static io.restassured.RestAssured.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApiTestExtension.class)
class PingTest {
    @Test
    void ping() throws Exception {
        final Response response = get("http://localhost/ping");
        assertEquals(HttpServletResponse.SC_OK, response.getStatusCode());
        assertEquals("pong", response.getBody().asString());
    }
}