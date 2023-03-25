package requestchainig;

import org.testng.annotations.Test;

import createprojectbypojo.PojoClass;
import createprojectbypojo.RandomNumber;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChain2 {
	@Test
	public void request1()
	{
	    baseURI="http://rmgtestingserver";
	    port=8084;
		RandomNumber num = new RandomNumber();
		PojoClass pj = new PojoClass("Zahid", "project_3121"+num.randomnum(), "created", 27);
		
		Response resp = given().body(pj).contentType(ContentType.JSON).when().post("/addProject");
		
		String pid = resp.jsonPath().get("projectId");
		System.out.println(pid);
		resp.then().log().all();
		
		when().get("/projects/pid").then().log().all();
		
		
	}

}
