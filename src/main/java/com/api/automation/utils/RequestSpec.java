package com.api.automation.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

	
	public static String baseUrl = "https://reqres.in";
	public static String apiKey = "pro_469eb322b8e9c0031cdc69d787363fe7d66e7a6f204efe2655ac592919b22d00";
	public static String publicToken = "reqres_fb14e66ed0554727bba29fdadd0dc4fa";
	
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
