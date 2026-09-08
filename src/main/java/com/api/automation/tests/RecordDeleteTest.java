package com.api.automation.tests;

import static com.api.automation.utils.RequestSpec.authenticatedSpec;
import static com.api.automation.utils.RequestSpec.readonlySpec;
import static com.api.automation.utils.RequestSpec.noAuthSpec;
import static com.api.automation.utils.RequestSpec.invalidSpec;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.api.automation.utils.TestData;


public class RecordDeleteTest {
	
	
	
	@Test(dependsOnGroups = "createRecord")
	public void deleteProduct() {
		
	
	    
	   
	    		given() 
	    		.spec(authenticatedSpec) 
	    		.pathParam("id", TestData.recordId)
	    		.when() 
	    		.delete("/{id}") 
	    		.then() 
	    		.log().ifValidationFails()
	    		.statusCode(204);
	      
	} 	
	
	@Test(dependsOnMethods = "deleteProduct")
	public void deletesameProduct() {
		
	  
	    		given() 
	    		.spec(authenticatedSpec) 
	    		.pathParam("id", TestData.recordId)
	    		.when() 
	    		.delete("/{id}") 
	    		.then() 
	    		.log().ifValidationFails()
	    		.statusCode(404)
	    		.body("message", equalTo("Record not found."));
	      
	}
	
	
	@Test
	public void deletenoAuthentication () {
	
	
		    		given() 
		    		.spec(noAuthSpec) 
		    		.pathParam("id", TestData.recordId)
		    		.when() 
		    		.delete("/{id}") 
		    		.then() 
		    		.log().ifValidationFails()
		    		.statusCode(401)
		    		.body("message", equalTo("The x-api-key header is required for this endpoint."));
		
	}
	
	@Test
	public void deleteForbidden () {
		
	 
		    		given() 
		    		.spec(readonlySpec) 
		    		.pathParam("id", TestData.recordId)
		    		.when() 
		    		.delete("/{id}") 
		    		.then() 
		    		.log().ifValidationFails()
		    		.statusCode(403)
		    		.body("message", equalTo("This API key does not have manage permissions."));
		
	}
	
	
	@Test
	public void deleteInvalid () {
			
		
		 
	    		given() 
	    		.spec(invalidSpec) 
	    		.pathParam("id", TestData.recordId)
	    		.when() 
	    		.delete("/{id}") 
	    		.then() 
	    		.log().ifValidationFails()
	    		.body("message", equalTo("This API key is not recognized or has been revoked."))
	            .statusCode(403);
		
		
	}
	
	@Test	
	public void deleteNonexisting () {
	
			 
		 
		 given() 
 		.spec(authenticatedSpec) 
 		.pathParam("id", "00000000-0000-0000-0000-000000000000")
 		.when() 
 		.delete("/{id}") 
 		.then() 
 		.log().ifValidationFails()
 		.body("message", equalTo("Record not found."))
        .log().all()
        .statusCode(404);
 
		
		
	}
	
}
