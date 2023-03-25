package validate_the_responsebody;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class StaticValidation1 {
	@Test
	public void staticvalid()
	{
	  String expdata = "TY_PROJ_11111";
	
	  baseURI = "http://rmgtestingserver";
	  port = 8084;
	  
	 Response resp = when()
	  .get("/projects");
	 
	 String actdata = resp.jsonPath().get("[0].projectId");
	 System.out.println(actdata);
	 Assert.assertEquals(actdata, expdata);
	 System.out.println("verified");
	 
	 resp.then().log().all();
	}

}
