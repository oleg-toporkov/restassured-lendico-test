# restassured-lendico-test

Tested on: JDK 8.

## Test scenarios
Located under:
```src/test/resources/ynab```
How selected?  
Well, that's the most essential tests to verify all endpoints are protected from using incorrect / no access key.
Also not that much tests actually could be written for such endpoints ` ¯\_(ツ)_/¯ `

## Used libraries
1. Cucumber - task requirement
2. Rest assured - task requirement
3. Allure - very beautiful and descriptive test report (take a look if haven't seen yet)
4. Snakeyaml - parser for yaml files, as it's more human readable to store configs there (and configuration of course should live not in compilable code)
5. Lombok - autogenerator tool to avoid java code boilerplate
6. Hamcrest - powerful assertions and natural for human to read

## How to run
To run all tests from commandline:
```
mvn clean test
```

(!) Requirement to run from Intellij IDEA: lombok plugin should be installed and annotation processing enabled  
https://projectlombok.org/setup/intellij

## How to get fancy report
Run following command (after test run)
```
mvn allure:serve
```

## Problems found
* When trying to get budget with 'null' as id, 404 error returned instead of 400 (as not valid id provided)   

## Testing code improvements
* DI should be used better for handling test context
* Store api key far away from code (or pass as env variables) and encrypt
* Add whole body data assertions (for errors as well)
* Add JSON schema validation
* Add logging (not just request / response)
* Config object can be stored in some base test instead of static access
* Static methods for clients might not be the best idea
* Reuse POJOs from devs code (debatable)