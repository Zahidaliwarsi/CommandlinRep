package crudwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddProject {
	@Test
	public void createProject()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "zahid");
		jobj.put("projectName", "vbowl_03");
		jobj.put("status","created");
		jobj.put("teamSize", 10);
		
		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
		
		Response response = req.post("http://rmgtestingserver:8084/addProject");
		//response.then().log().all();
		System.out.println(response.getContentType());
		System.out.println(response.asString());
		System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());
		
	}

}
