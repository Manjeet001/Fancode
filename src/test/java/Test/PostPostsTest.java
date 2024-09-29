package Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import Api.BaseApi;

import static io.restassured.RestAssured.given;

public class PostPostsTest extends BaseApi{
	
	@Test
    public void createNewPost()  {
		
        JSONObject requestParams = new JSONObject();
        requestParams.put("title", "foo");
        requestParams.put("body", "bar");
        requestParams.put("userId", 1);

        Response response = given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .contentType(ContentType.JSON)
                .body(requestParams.toString())  
                .when()
                .post("/posts")
                .then()
                .statusCode(201)  
                .extract().response();

        System.out.println("Response Body: " + response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 201, "Expected status code is 201");
        Assert.assertEquals(response.jsonPath().getString("title"), "foo");
        Assert.assertEquals(response.jsonPath().getString("body"), "bar");
        Assert.assertEquals(response.jsonPath().getInt("userId"), 1);
    }

}
