package Different_ways_to_Post_with_BDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import createprojectbypojo.PojoClass;
import createprojectbypojo.RandomNumber;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class PostByPojo {
	@Test
	public void postbypojo()
	{
		RandomNumber ran = new RandomNumber();
	   PojoClass pj = new PojoClass("zahid", "zahid_12144"+ran.randomnum(), "created", 34);
	
	   baseURI="http://rmgtestingserver";
	   port=8084;
	   
	   given()
	   .body(pj)
	   .contentType(ContentType.JSON)
	   
	   
	   .when()
	   .post("/addProject")
	   
	   .then()
	   .assertThat()
	   .statusCode(201)
	   .contentType(ContentType.JSON)
	   .time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS)
	   .log().all();
	}

}
