package Test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Api.BaseApi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetCommentsByPostIdTest extends BaseApi{
	
	  @Test
	    public void getCommentsByPostId() {

		    Response response = given()
	                                .queryParam("postId", 1)
	                            .when()
	                                .get("/comments");

	        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");

	        System.out.println(response.asPrettyString());

	        response.then()
	                .body("[0].postId", equalTo(1)) 
	                .body("[0].id", equalTo(1)) 
	                .body("[0].email", equalTo("Eliseo@gardner.biz")); 
	    }
	

}
