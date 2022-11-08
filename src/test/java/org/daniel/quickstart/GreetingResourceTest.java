package org.daniel.quickstart;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(HelloWorldQuarkusTestResource.class)
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("MEMORY HELLO"));
    }

    @Test
    public void should_return_hello() {
        given()
                .when().get("/hello/expensive")
                .then()
                .statusCode(200)
                .body(is("20"));
    }

}