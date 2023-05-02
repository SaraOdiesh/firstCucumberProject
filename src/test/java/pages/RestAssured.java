package pages;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.testng.*;
import org.testng.annotations.*;
import io.restassured.response.Response;

public class RestAssured {

	
	
    @Test (priority=0)
	public  void test_1(){
		
	Response response = get("https://reqres.in/api/user?page=2");
	System.out.println(response.getStatusCode());
	System.out.println(response.getTime());
	System.out.println(response.getBody().asString());
	System.out.println(response.getStatusLine());
	System.out.println(response.getHeader("content-type"));
	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, 200);
	Assert.assertEquals(statusCode, 200);
	Assert.assertEquals(statusCode, 200);
	Assert.assertEquals(statusCode, 200);
}
    
    @Test
    public void test_2() {
    	baseURI="https://reqres.in/api";
    	given().get("/user?page=2").then().statusCode(200).
    	body("data[1].id",equalTo(8));
    }

}
