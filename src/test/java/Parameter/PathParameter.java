package Parameter;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParameter {
	
	@Test
	public void pathparam()
	{
	    baseURI="http://rmgtestingserver";
	    port=8084;
	    
	    given()
	    .pathParam("pid", "TY_PROJ_11111")
	    
	    .when()
	    .get("/projects/{pid}")
	    
	    .then()
	    .assertThat()
	    .statusCode(200)
	    .contentType(ContentType.JSON)
	    .log().all();
	}

}
