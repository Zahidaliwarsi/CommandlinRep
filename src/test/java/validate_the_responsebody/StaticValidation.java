package validate_the_responsebody;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class StaticValidation {
	@Test
	public void staticvalid()
	{
		String expData = "TY_PROJ_9562";
		baseURI="http://rmgtestingserver";
		port=8084;
		
		Response resp = when()
		.get("/projects");
		
		String actData=resp.jsonPath().get("[0].projectId");
		System.out.println(actData);
		Assert.assertEquals(actData, expData);
		System.out.println("data verified");
		
		resp.then().log().all();
	}

}
