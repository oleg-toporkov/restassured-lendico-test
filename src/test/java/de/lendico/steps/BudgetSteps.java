package de.lendico.steps;

import de.lendico.api.TestContext;
import de.lendico.api.clients.budget.BudgetService;
import de.lendico.api.dtos.budget.BudgetResponseDTO;
import io.cucumber.java8.En;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BudgetSteps implements En {

    protected ThreadLocal<BudgetResponseDTO> budgetResponseDTO = new ThreadLocal<>();

    public BudgetSteps() {

        When("^I call get budget endpoint with id (.*)$", (String id) -> {
            ValidatableResponse response = BudgetService.getBudget(TestContext.key.get(), id);
            TestContext.lastResponse.set(response);
        });

        When("^I call get budget endpoint with random uuid$", () -> {
            String id = UUID.randomUUID().toString();
            ValidatableResponse response = BudgetService.getBudget(TestContext.key.get(), id);
            TestContext.lastResponse.set(response);
        });

        Then("^I get valid budget response$", () -> {
            TestContext.lastResponse.get().statusCode(HttpStatus.SC_OK);
            // TODO here can be validation against schema, but mapping will also do the trick for now
            BudgetResponseDTO response = TestContext.lastResponse.get().extract().as(BudgetResponseDTO.class);
            budgetResponseDTO.set(response);
        });

        Then("^Name field is (.*)$", (String name) ->
                assertThat(budgetResponseDTO.get().getData().getBudget().getName(), is(name)));
    }
}
