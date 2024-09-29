package Test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Api.BaseApi;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

public class GetPosts1Test extends BaseApi{
	
	@Test
    public void getPostWithIdOne() {
        Response response = get("/posts/1");

        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");

        System.out.println(response.asPrettyString());

        response.then().body("userId", equalTo(1))
                         .body("id", equalTo(1))
                         .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                         .body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto")); 
    }

}
