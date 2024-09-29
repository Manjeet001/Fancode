package Test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Api.BaseApi;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class GetPosts1CommentsTest extends BaseApi{
	
	@Test
    public void getCommentsForPostWithIdOne() {
		
        Response response = get("/posts/1/comments");

        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");

        System.out.println(response.asPrettyString());

        response.then().body("", hasSize(5));

        response.then().body("[0].postId", equalTo(1))
                         .body("[0].id", equalTo(1))
                         .body("[0].name", equalTo("id labore ex et quam laborum"))
                         .body("[0].email", equalTo("Eliseo@gardner.biz"))
                         .body("[0].body", equalTo( "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
                         )); 
    }

}
