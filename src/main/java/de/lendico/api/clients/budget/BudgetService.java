package de.lendico.api.clients.budget;

import de.lendico.api.constants.Endpoints;
import io.restassured.response.ValidatableResponse;

import static de.lendico.api.clients.base.BaseClient.BASE_REQUEST_SPEC;
import static io.restassured.RestAssured.given;

public class BudgetService {

    public static ValidatableResponse getBudget(String apiKey, String budgetId) {
        //@formatter:off
        return
                given()
                        .spec(BASE_REQUEST_SPEC)
                        .auth()
                        .oauth2(apiKey).
                when()
                        .get(Endpoints.BUDGET_WITH_ID, budgetId).
                then()
                        .log()
                        .all();
        //@formatter:on
    }

}
