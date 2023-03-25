package requestchainig;

import org.testng.annotations.Test;

import createprojectbypojo.PojoClass;
import createprojectbypojo.RandomNumber;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChain {
	
	@Test
	public void requestChain()
	{
		RandomNumber ran = new RandomNumber();
		PojoClass pj = new PojoClass("zahid", "zahid"+ran.randomnum(), "created", 16);
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		Response resp = given()
		.body(pj)
		.contentType(ContentType.JSON)
		.when().post("/addProject");
		
		String pid=resp.jsonPath().get("projectId");
		System.out.println(pid);
		resp.then().log().all();
		
		given()
		.pathParam("id", pid)
		.when().get("/projects/{id}")
		.then().assertThat().statusCode(200).log().all();
		
		
	}

}
