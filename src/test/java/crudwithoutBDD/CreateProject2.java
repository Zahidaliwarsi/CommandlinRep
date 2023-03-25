package crudwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject2 {
	@Test
	public void createProjct()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "zahid");
		jobj.put("projectName", "zahhid_098");
		jobj.put("status", "created");
		jobj.put("teamSize", 14);
		
		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
		
		Response response = req.post("http://rmgtestingserver:8084/addProject");
		
		response.then().log().all();
		System.out.println(response.getContentType());
		System.out.println(response.asString());
		System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());
	}

}
