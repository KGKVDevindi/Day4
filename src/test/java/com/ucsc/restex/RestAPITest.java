package com.ucsc.restex;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class RestAPITest {

    @Test
    public void verifyThatListAllTheUsers(){
        String body = """
         
                {
                    "name": "morpheus",
                    "job": "leader"
                }
                """;

        given()
                .header("x-api-key","reqres-free-v1")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .assertThat()
                .statusCode(i==201)
                .body("name",equalTo("morpheus"))
                .log().all();
    }
}