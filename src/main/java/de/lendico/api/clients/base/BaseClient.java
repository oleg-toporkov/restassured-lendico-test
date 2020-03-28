package de.lendico.api.clients.base;

import de.lendico.api.properties.TestProperties;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

import java.util.Collections;

public class BaseClient {

    public static RequestSpecification BASE_REQUEST_SPEC = new RequestSpecBuilder()
            .addFilters(Collections.singletonList(new AllureRestAssured()))
            .log(LogDetail.ALL)
            .setBaseUri(TestProperties.CONFIG.getHost())
            .build();

}