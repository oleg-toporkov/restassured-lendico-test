package de.lendico.steps;

import de.lendico.api.TestContext;
import de.lendico.api.exceptions.KeyNotFoundException;
import de.lendico.api.properties.TestProperties;
import io.cucumber.java8.En;

public class BaseSteps implements En {

    public BaseSteps() {

        Given("^I use (\\w+) API key$", (String keyType) -> {
            String keyValue;

            switch (keyType.toLowerCase()) {
                case "valid":
                    keyValue = TestProperties.CONFIG.getKey().getValid();
                    break;
                case "invalid":
                    keyValue = TestProperties.CONFIG.getKey().getInvalid();
                    break;
                case "empty":
                    keyValue = "";
                    break;
                default:
                    throw new KeyNotFoundException(keyType);
            }

            TestContext.key.set(keyValue);
        });

        Then("^I get (\\d+) HTTP error$", (Integer errorCode) ->
                TestContext.lastResponse.get().statusCode(errorCode));
    }

}
