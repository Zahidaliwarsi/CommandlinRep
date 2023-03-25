package validate_the_responsebody;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicValidation {
	@Test
	public void dynamicvalid()	
	{
		String expectedData = "TY_PROJ_9562";
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		boolean flag = false;
	   Response resp = when().get("/projects");
	    List<String> pIds = resp.jsonPath().get("projectId");
	    for(String projectID:pIds)
	    {
	    	if(projectID.equalsIgnoreCase(expectedData))
	    	{
	    		flag=true;
	    	}
	    }
	    Assert.assertTrue(flag);
	    System.out.println("data verified");
		
	}

}
