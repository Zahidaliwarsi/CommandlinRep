package crudwithDBB;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddObject1 {
	@Test
	public void addobject()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "zahid");
		jobj.put("projectName", "zahid_65");
		jobj.put("status", "created");
		jobj.put("teamSize", 13);
		
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
	    .log().all();
	}

}
