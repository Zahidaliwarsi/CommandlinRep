package crudwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllProjects {
	@Test
	public void getallproject()
	{
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects");
		response.then().log().all();
	}

}
