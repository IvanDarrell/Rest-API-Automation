package com.api.automation.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.api.automation.pojo.RecordData;
import com.api.automation.pojo.RecordRequest;
import com.api.automation.utils.TestData;

import static com.api.automation.utils.RequestSpec.authenticatedSpec;
import static com.api.automation.utils.RequestSpec.readonlySpec;
import static com.api.automation.utils.RequestSpec.noAuthSpec;
import static com.api.automation.utils.RequestSpec.invalidSpec;

import io.restassured.response.Response;
public class RecordPostTest {
	
	
	@Test(groups = "createRecord")
	public void postRecord() {
		
		
		
		
		
		//Create a record
		RecordData recordData = new RecordData(
	            "PC Ware",
	            600.45f,
	            "Electronics",
	            true);
		
		RecordRequest request = new RecordRequest(recordData);
		
	    Response response = 
	    		given() 
	    		.spec(authenticatedSpec) 
	    		.body(request)
	    		.log().all()
	    		.when() 
	    		.post() 
	    		.then()  
	    		.log().ifValidationFails()
	    		.statusCode(201) 
	    		.body("data.id", notNullValue())
	    		.extract() 
	    		.response();
	    	
	      	
	    
	    TestData.recordId = response.jsonPath().getString("data.id");
	    
	   
	} 
	
	
	
	@Test
	public void postMissingRequireddata() {
		


		RecordData recordData = TestData.missingNameRecord();
		
		
		
		
		RecordRequest request = new RecordRequest(recordData);


	
		
		
				given() 
				.spec(authenticatedSpec) 
				.body(request) 
				.when() 
				.post() 
				.then() 
				.log().ifValidationFails()
				.statusCode(201);
		
	}
	
	
	
	public void postForbidden () {
		RecordData recordData = TestData.missingNameRecord();
		
		
		
		
		RecordRequest request = new RecordRequest(recordData);
		
	  
				given() 
				.spec(readonlySpec)  
				.body(request) 
				.when() 
				.post() 
				.then() 
				.log().ifValidationFails()
				.body("message", equalTo("This API key has read-only permissions."))
				.statusCode(403);
				
	
		
		
	}
	

	public void postNoAuthentication () {
		RecordData recordData = TestData.missingNameRecord();
		
		
		
		
		RecordRequest request = new RecordRequest(recordData);
		
				given() 
				.spec(noAuthSpec) 
				.body(request) 
				.when() 
				.post() 
				.then() 
				.log().ifValidationFails()
				.body("message", equalTo("The x-api-key header is required for this endpoint."))
				.statusCode(401);
		
	}
	

	public void postInvalidAuthentication () {
		RecordData recordData = TestData.missingNameRecord();
		
		
		
		
		RecordRequest request = new RecordRequest(recordData);
		
		
				given() 
				.spec(invalidSpec) 
				.body(request) 
				.when() 
				.post() 
				.then() 
				.log().ifValidationFails()
				.statusCode(403)
	    		.body("message", equalTo("This API key is not recognized or has been revoked."));
		
	}
	
	

}
