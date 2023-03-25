package Different_ways_to_Post_with_BDD;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class PostByJsonObject {
	
	@Test
	public void postbyjsonobject()
	{
	    JSONObject jobj = new JSONObject();
	    jobj.put("createdBy", "zahid");
	    jobj.put("projectName", "zahid_56778");
	    jobj.put("status", "created");
	    jobj.put("teamSize", 16);
	    
	    baseURI="http://rmgtestingserver";
	    port=8084;
	    
	    given()
	    .body(jobj)
	    .contentType(ContentType.JSON)
	    .when()
	    .post("/addProject")
	    
	    .then()
	    .assertThat()
	    .statusCode(201)
	    .contentType(ContentType.JSON)
	    .time(Matchers.lessThan(1500L),TimeUnit.MILLISECONDS)
	    .log().all();
	}
}


