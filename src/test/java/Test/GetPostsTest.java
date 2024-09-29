package Test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Api.BaseApi;

import java.util.List;

import static io.restassured.RestAssured.get;

public class GetPostsTest extends BaseApi{
	
	

    @Test
    public void getAllPosts() {
    	
        Response response = get("/posts");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");

        response.prettyPrint();

        List<Object> postsList = response.jsonPath().getList("$");
        
        Assert.assertTrue(postsList.size() > 0, "Posts list is empty");

        int firstPostId = response.jsonPath().getInt("[0].id");
        String firstPostTitle = response.jsonPath().getString("[0].title");

        Assert.assertTrue(firstPostId > 0, "First post ID is invalid");
        Assert.assertNotNull(firstPostTitle, "First post title is null");
        
        System.out.println("First Post ID: " + firstPostId);
        System.out.println("First Post Title: " + firstPostTitle);
    }
		
	

}
