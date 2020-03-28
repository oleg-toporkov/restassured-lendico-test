package de.lendico.api.clients.user;

import de.lendico.api.constants.Endpoints;
import io.restassured.response.ValidatableResponse;

import static de.lendico.api.clients.base.BaseClient.BASE_REQUEST_SPEC;
import static io.restassured.RestAssured.given;

public class UserService {

    public static ValidatableResponse getUser(String apiKey) {
        //@formatter:off
        return
                given()
                        .spec(BASE_REQUEST_SPEC)
                        .auth()
                        .oauth2(apiKey).
                when()
                        .get(Endpoints.USER).
                then()
                        .log()
                        .all();
        //@formatter:on
    }

    public static ValidatableResponse getUserNoOauth() {
        //@formatter:off
        return
                given()
                        .spec(BASE_REQUEST_SPEC).
                when()
                        .get(Endpoints.USER).
                then()
                        .log()
                        .all();
        //@formatter:on
    }

    public static ValidatableResponse deleteUser() {
        //@formatter:off
        return
                given()
                        .spec(BASE_REQUEST_SPEC).
                when()
                        .delete(Endpoints.USER).
                then()
                        .log()
                        .all();
        //@formatter:on
    }

}
