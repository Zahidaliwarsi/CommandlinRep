package Different_ways_to_Post_with_BDD;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostByFile {
	@Test
	public void postbyfle()
	{
		File fl = new File("./filename/Data.json");
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given()
		.body(fl)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1500l),TimeUnit.SECONDS)
		.log().all();
	}

}
