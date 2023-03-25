package crudwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	@Test
	public void updateProject()
	{
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "zahid");
		obj.put("projectName", "vwowls123");
		obj.put("status", "updated");
		obj.put("teamSize", 13);
		
		RequestSpecification req = RestAssured.given();
		req.body(obj);
		req.contentType(ContentType.JSON);
		Response response = req.put("http://rmgtestingserver:8084/projects/TY_PROJ_16076");
		
		response.then().log().all();
		
	}

}
