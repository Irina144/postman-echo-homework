package ru.netology.rest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    void shouldReturnSentTextInDataField() {
        // что отправляем:
        String payload = "some data";

        // сам тест
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body(payload)
                .when()
                .post("/post")
                .then()
                .statusCode(200)

                .body("dataX", equalTo(payload));
    }
}