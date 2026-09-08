package com.api.automation.tests;

import static com.api.automation.utils.RequestSpec.authenticatedSpec;
import static com.api.automation.utils.RequestSpec.readonlySpec;
import static com.api.automation.utils.RequestSpec.noAuthSpec;
import static com.api.automation.utils.RequestSpec.invalidSpec;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.api.automation.pojo.RecordData;
import com.api.automation.pojo.RecordRequest;
import com.api.automation.utils.TestData;

import io.restassured.response.Response;

public class RecordPutTest {
	
	
	@Test(dependsOnGroups = "createRecord")
	public void putUpdateRecord() {
		RecordData recordData = TestData.validRecord();
		RecordRequest request = new RecordRequest(recordData);
		

		    		given() 
		    		.spec(authenticatedSpec) 
		    		.pathParam("id", TestData.recordId)
		    		.body(request) 
		    		.when() 
		    		.put("/{id}") 
		    		.then() 
		    		.log().ifValidationFails()
		    		.statusCode(200)
		    		.body("data.data.name", equalTo(recordData.getName()))
		    		.body("data.data.price", equalTo(recordData.getPrice()))
		    		.body("data.data.category", equalTo(recordData.getCategory()))
		    		.body("data.data.in_stock", equalTo(recordData.isIn_stock()));
		    		
		
		
	}
	
	
	
	
	public void putMissingRequiredData() {
	
		
		
		
		RecordData recordData = TestData.missingNameRecord();
		
		
		
		
		RecordRequest request = new RecordRequest(recordData);

 
	    		given() 
	    		.spec(authenticatedSpec) 
	    		.pathParam("id", TestData.recordId)
	    		.body(request) 
	    		.when() 
	    		.put("/{id}") 
	    		.then() 
	    		.log().ifValidationFails()
	    		.statusCode(200)
	    		.body("data.data.price", equalTo(recordData.getPrice()))
	    		.body("data.data.category", equalTo(recordData.getCategory()))
	    		.body("data.data.in_stock", equalTo(recordData.isIn_stock()));
		
	}
	
	
	@Test
	public void putRecordNotFound() {
		RecordData recordData = TestData.validRecord();
		RecordRequest request = new RecordRequest(recordData);
		
		String invalidId = "00000000-0000-0000-0000-000000000000";
		

	    		given() 
	    		.spec(authenticatedSpec) 
	    		.pathParam("id", invalidId)
	    		.body(request) 
	    		.when() 
	    		.put("/{id}") 
	    		.then() 
	    		.log().ifValidationFails()
	    		.statusCode(404)
	    		.body("message", equalTo("Record not found."));
	}
	
	@Test
	public void putForbidden() {
	
		RecordData recordData = TestData.validRecord();
		RecordRequest request = new RecordRequest(recordData);
		
	
	    		given() 
	    		.spec(readonlySpec)  
	    		.pathParam("id", TestData.recordId)
	    		.body(request) 
	    		.when() 
	    		.put("/{id}") 
	    		.then() 
	    		.log().ifValidationFails()
	    		.statusCode(403)
	    		.body("message", equalTo("This API key has read-only permissions."));
		
	}	
	
	
	@Test
	public void putNoAuthentication() {
		
		RecordData recordData = TestData.validRecord();
		RecordRequest request = new RecordRequest(recordData);
		
		
		
		
		
 
	    		given() 
	    		.spec(noAuthSpec)  
	    		.pathParam("id", TestData.recordId)
	    		.body(request) 
	    		.when() 
	    		.put("/{id}") 
	    		.then() 
	    		.log().ifValidationFails()
	    		.statusCode(401)
	    		.body("message", equalTo("The x-api-key header is required for this endpoint."));
		
		
	}
	
	@Test
	public void putInvalidAuthentication() {
		
		RecordData recordData = TestData.validRecord();
		RecordRequest request = new RecordRequest(recordData);
		
		
		
		
 
	    		given() 
	    		.spec(invalidSpec)  
	    		.pathParam("id", TestData.recordId)
	    		.body(request) 
	    		.when() 
	    		.put("/{id}") 
	    		.then() 
	    		.log().ifValidationFails()
	    		.statusCode(403)
	    		.body("message", equalTo("This API key is not recognized or has been revoked."));
		
		
	}
	
 
}
