package pages;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;





public class GetAndPostExamples {
        @Test
	  	public void testGet() {
		baseURI= "http://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).
		body("data[4].first_name",equalTo("George"));
		//body("data.first_name",hasltems("George","Rachal"));
		
		
	}
         
        @Test
	    public void testPost() {
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	
	    	map.put("name", "Sara");
	    	map.put("job", "SDET");
	    	System.out.println(map);
	    }


}
