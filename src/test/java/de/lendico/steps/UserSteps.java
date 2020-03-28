package de.lendico.steps;

import de.lendico.api.TestContext;
import de.lendico.api.clients.user.UserService;
import de.lendico.api.dtos.user.UserResponseDTO;
import io.cucumber.java8.En;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserSteps implements En {

    protected ThreadLocal<UserResponseDTO> userResponseDTO = new ThreadLocal<>();

    public UserSteps() {

        When("^I call get user endpoint$", () -> {
            ValidatableResponse response = UserService.getUser(TestContext.key.get());
            TestContext.lastResponse.set(response);
        });

        Then("^I get valid user response$", () -> {
            TestContext.lastResponse.get().statusCode(HttpStatus.SC_OK);
            // TODO here can be validation against schema, but mapping will also do the trick for now
            UserResponseDTO response = TestContext.lastResponse.get().extract().as(UserResponseDTO.class);
            userResponseDTO.set(response);
        });

        Then("^My user id is (.*)$", (String id) ->
                assertThat(userResponseDTO.get().getData().getUser().getId(), is(id)));

        When("^I call get user endpoint without oauth headers$", () -> {
            ValidatableResponse response = UserService.getUserNoOauth();
            TestContext.lastResponse.set(response);
        });

        When("^I call delete user endpoint$", () -> {
            ValidatableResponse response = UserService.deleteUser();
            TestContext.lastResponse.set(response);
        });

    }
}
