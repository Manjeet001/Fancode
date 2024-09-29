package Api;

import io.restassured.RestAssured;

public class BaseApi {
	
	 static {
	        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
	    }

}
