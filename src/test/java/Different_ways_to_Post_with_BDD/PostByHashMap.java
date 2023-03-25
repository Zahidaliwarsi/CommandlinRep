package Different_ways_to_Post_with_BDD;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostByHashMap {
	@Test
	public void posthashmap()
	{
		HashMap<String, Object> obj = new HashMap<String, Object>();
		obj.put("createdBy", "zahid");
		obj.put("projectName", "zahid_54555");
		obj.put("status", "created");
		obj.put("teamSize", 12);
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1500l),TimeUnit.MILLISECONDS)
		.log().all();
		
	}

}
