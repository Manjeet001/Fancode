package Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Api.BaseApi;

import static io.restassured.RestAssured.given;

public class PatchPostTest  extends BaseApi  {
	
	 @Test
	    public void patchPostWithIdOne() {
		 
		 String requestBody = "{ \"title\": \"foo\" }";


		 Response response = given()
	                .contentType(ContentType.JSON)    
	                .body(requestBody)                
	                .when()
	                .patch("/posts/1");               


		 Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");

	     System.out.println(response.asPrettyString());

	     String updatedTitle = response.jsonPath().getString("title");
	     Assert.assertEquals(updatedTitle, "foo", "Title should be updated to 'foo'");
	     
	 }

}
