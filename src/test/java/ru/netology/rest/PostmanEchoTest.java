import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class PostmanEchoTest {
    @Test
    void shouldReturnSentTextInDataField() {
        String payload = "some data";

        useRelaxedHTTPSValidation(); // важно для CI

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body(payload)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(payload));
    }
}