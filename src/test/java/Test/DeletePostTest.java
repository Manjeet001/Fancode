package Test;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Api.BaseApi;

import static io.restassured.RestAssured.delete;
import static org.hamcrest.Matchers.equalTo;

public class DeletePostTest extends BaseApi{

	 @Test
	    public void deletePostWithIdOne() {

		 Response response = delete("/posts/1");


		 int statusCode = response.getStatusCode();
		 Assert.assertTrue(statusCode == 200 || statusCode == 204, "Expected status code is 200 or 204");


		 System.out.println("Response body: " + response.getBody().asPrettyString());


		 Assert.assertEquals(response.getBody().asString(), "{}", "Response body should be empty after DELETE request.");
	    }
}
