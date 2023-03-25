package crudwithDBB;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteProject {
	@Test
	public void deleteProject()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		
		
		when()
		 .delete("/projects/TY_PROJ_9982")
		 
		 
		 .then()
		 .assertThat()
		 .statusCode(204)
		 .log().all();
		
		
	}

}
