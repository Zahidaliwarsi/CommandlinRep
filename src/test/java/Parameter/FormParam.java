package Parameter;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParam {
	
	@Test
	public void formparam()
	{
		baseURI="https://reqres.in/";
		
		given()
		.formParam("id", 11)
		.formParam("email", "adasdsdf")
		.formParam("first_name", "dsadas")
		.formParam("last_name", "edwards")
		.formParam("avatar", "httfbfgbnfs")
		
		.when()
		.post("/api/users")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
