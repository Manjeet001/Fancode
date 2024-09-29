package Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Api.BaseApi;

import static io.restassured.RestAssured.given;

public class PutPostTest extends BaseApi {
	
	@Test
    public void updatePostWithPut() {

		String updatedPostBody = "{\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"foo\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": 1\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(updatedPostBody) 
                .when()
                .put("/posts/1");

        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.jsonPath().getString("title"), "foo", "Expected title is 'foo'");
        Assert.assertEquals(response.jsonPath().getString("body"), "bar", "Expected body is 'bar'");
        Assert.assertEquals(response.jsonPath().getInt("userId"), 1, "Expected userId is '1'");
    }

}
