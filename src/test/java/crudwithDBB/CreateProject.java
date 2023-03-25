package crudwithDBB;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {
	@Test
	public void addProject()
	{
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "zahid");
		obj.put("projectName", "bowl_01");
		obj.put("status", "created");
		obj.put("teamSize", 9);
		
		baseURI = "http://rmgtestingserver";
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
		     .log().all();
		    		
	
	}

}
