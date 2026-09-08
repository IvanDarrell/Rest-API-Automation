package com.api.automation.tests;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



import com.api.automation.utils.TestData;

import static com.api.automation.utils.RequestSpec.readonlySpec;
import static com.api.automation.utils.RequestSpec.noAuthSpec;
import static com.api.automation.utils.RequestSpec.invalidSpec;

public class RecordGetTest {

	
	
	
@Test(dependsOnGroups = "createRecord")
public void getRecord() {
						given() 
    					.spec(readonlySpec) 
    					.pathParam("id", TestData.recordId) 
    					.log().all() 
    					.when() 
    					.get("/{id}") 
    					.then()  
    					.log().ifValidationFails()
    					.statusCode(200) 
    					.body("data.data.name", notNullValue())
    					.body("data.data.category", notNullValue())
    					.body("data.data.in_stock", notNullValue())
    					.body("data.id", equalTo(TestData.recordId));
						
}






@Test
public void getListRecords() {

			given() 
			.spec(readonlySpec)  
			.when() 
			.get() 
			.then()  
			.log().ifValidationFails()
			.statusCode(200) 
			.body("data", not(empty()))
			.body("data.id", everyItem(notNullValue()));
		
}


@Test
public void getListNotFound() {
		
	String invalidId = "00000000-0000-0000-0000-000000000000";
	
	
			given() 
			.spec(readonlySpec)  
			.pathParam("id", invalidId)
			.when() 
			.get("/{id}") 
			.then()  
			.log().ifValidationFails()
			.statusCode(404) 
			.body("message", equalTo("Record not found."));
		
}



@Test
public void getNoAuthentication() {


	   		given() 
			.spec(noAuthSpec)  
			.pathParam("id", TestData.recordId)
			.when() 
			.get("/{id}") 
			.then()  
			.log().ifValidationFails()
			.statusCode(401) 
			.body("message", equalTo("The x-api-key header is required for this endpoint."));
		
}

@Test
public void getInvalidAuthentication() {


			given() 
			.spec(invalidSpec)  
			.pathParam("id", TestData.recordId)
			.when() 
			.get("/{id}") 
			.then()  
			.log().ifValidationFails()
			.statusCode(403)
    		.body("message", equalTo("This API key is not recognized or has been revoked."));
		
}



}