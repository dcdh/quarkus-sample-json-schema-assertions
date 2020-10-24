package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
                .log().all()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("hello.json"))
                .body("message", is("hello"));
    }

}