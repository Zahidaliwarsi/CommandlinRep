package crudwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
	@Test
	public void deleteProject()
	{
		Response response = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_16076");
		
		response.then().log().all();
	}

}
