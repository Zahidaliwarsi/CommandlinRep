package Authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class BasicAuth {
	@Test
	public void basicAuth()
	{
		baseURI = "http://rmgtestingserver";
		port=8084;
		
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then().assertThat().statusCode(202).log().all();
	}
	
	@Test
	public void basicpreemptiveauth()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then().assertThat().log().all();
		
	}
	
	@Test
	public void digestiveauth()
	{
		baseURI = "http://rmgtestingserver";
		port=8084;
		
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then()
		.assertThat().statusCode(202).log().all();
	}
	
	
	

}

