package com.api.automation.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

	
	public static String baseUrl = System.getenv("URL");
	public static String apiKey = System.getenv("API_TOKEN");
	public static String publicToken = System.getenv("PUBLIC_API_TOKEN");
	
	public static String invalidtoken = "+++++++++++++++++++++++++==232";
	
	public static RequestSpecification authenticatedSpec = new RequestSpecBuilder()
	        .setBaseUri(baseUrl)
	        .setBasePath("/api/collections/products/records")
	        .addHeader("x-api-key", apiKey)
	        .setContentType(ContentType.JSON)
	        .addQueryParam("project_id", 45675) 
	        .build();

	public static RequestSpecification readonlySpec = new RequestSpecBuilder()
	        .setBaseUri(baseUrl)
	        .setBasePath("/api/collections/products/records")
	        .addHeader("x-api-key", publicToken)
	        .setContentType(ContentType.JSON)
	        .addQueryParam("project_id", 45675) 
	        .build();

	public static RequestSpecification noAuthSpec = new RequestSpecBuilder()
			.setBaseUri(baseUrl)
	        .setBasePath("/api/collections/products/records")
	        .setContentType(ContentType.JSON)
	        .addQueryParam("project_id", 45675) 
	        .build();
	
	public static RequestSpecification invalidSpec = new RequestSpecBuilder()
	        .setBaseUri(baseUrl)
	        .setBasePath("/api/collections/products/records")
	        .addHeader("x-api-key", invalidtoken)
	        .setContentType(ContentType.JSON)
	        .addQueryParam("project_id", 45675) 
	        .build();
}
