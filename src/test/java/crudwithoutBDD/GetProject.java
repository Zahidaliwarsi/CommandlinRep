package crudwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetProject {
	@Test
	public void getProject()
	{
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_16076");
		response.then().log().all();
		/*System.out.println(response.getContentType());
		System.out.println(response.asString());
		System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());*/
		int actstatus = response.getStatusCode();
		Assert.assertEquals(200, actstatus);
		
	}

}
