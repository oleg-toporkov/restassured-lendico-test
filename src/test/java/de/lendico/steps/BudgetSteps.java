package de.lendico.steps;

import de.lendico.api.clients.budget.BudgetService;
import de.lendico.api.dtos.budget.BudgetResponseDTO;
import de.lendico.api.exceptions.KeyNotFoundException;
import de.lendico.api.properties.TestProperties;
import io.cucumber.java8.En;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BudgetSteps implements En {

    private ThreadLocal<String> key = new ThreadLocal<>();
    private ThreadLocal<ValidatableResponse> lastResponse = new ThreadLocal<>();
    private ThreadLocal<BudgetResponseDTO> responseDTO = new ThreadLocal<>();

    public BudgetSteps() {

        Given("^I use (\\w+) API key$", (String keyType) -> {
            String keyValue;

            switch (keyType.toLowerCase()) {
                case "valid":
                    keyValue = TestProperties.CONFIG.getKey().getValid();
                    break;
                case "invalid":
                    keyValue = TestProperties.CONFIG.getKey().getInvalid();
                    break;
                case "null":
                    keyValue = null;
                    break;
                case "empty":
                    keyValue = "";
                    break;
                default:
                    throw new KeyNotFoundException(keyType);
            }

            key.set(keyValue);
        });

        When("^I call get budget endpoint with id (.*)$", (String id) -> {
            ValidatableResponse response = BudgetService.getBudget(key.get(), id);
            lastResponse.set(response);
        });

        When("^I call get budget endpoint with random uuid$", () -> {
            String id = UUID.randomUUID().toString();
            ValidatableResponse response = BudgetService.getBudget(key.get(), id);
            lastResponse.set(response);
        });

        Then("^I get valid response$", () -> {
            lastResponse.get().statusCode(HttpStatus.SC_OK);
            // TODO here can be validation against schema, but mapping will also do the trick for now
            BudgetResponseDTO response = lastResponse.get().extract().as(BudgetResponseDTO.class);
            responseDTO.set(response);
        });

        Then("^Name field is (.*)$", (String name) ->
                assertThat(responseDTO.get().getData().getBudget().getName(), is(name)));

        Then("^I get (\\d+) HTTP error$", (Integer errorCode) ->
                lastResponse.get().statusCode(errorCode));


    }
}
