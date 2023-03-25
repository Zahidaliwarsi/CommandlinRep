package crudwithDBB;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAllProjects {
	@Test
	public void getAllProjects()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when()
		  .get("/projects")
		  
		 .then()
		 .assertThat()
		 .statusCode(200)
		 .contentType(ContentType.JSON)
		 .log().all();
	}

}
