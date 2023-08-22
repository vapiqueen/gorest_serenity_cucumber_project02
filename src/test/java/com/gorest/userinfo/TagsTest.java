package com.gorest.userinfo;

import com.gorest.testbase.TestBase;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;

public class TagsTest extends TestBase {
    @WithTag("usefeature:NEGATIVE")
    @Title("Provide a 405 status code when incorrect HTTP method is used to access resource")
    @Test
    public void invalidMethod() {
        SerenityRest.rest()
                .given()
                .when()
                .post("/users")
                .then()
                .statusCode(403)
                .log().all();
    }

    @WithTags({
            @WithTag("userfeature:SMOKE"),
            @WithTag("userfeature:POSITIVE")
    })
    @Title("This test will verify if a status code of 200 is returned for GET request")
    @Test
    public void verifyIfTheStatusCodeIs200() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log().all();


    }

    @WithTags({
            @WithTag("userfeature:SMOKE"),
            @WithTag("userfeature:NEGATIVE")
    })

    @Title("This test will provide an error code of 400 when user tries to access an invalid resource")
    @Test
    public void inCorrectResource() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/users")
                .then()
                .statusCode(400)
                .log().all();
    }
}
