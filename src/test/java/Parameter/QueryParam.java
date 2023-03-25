package Parameter;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class QueryParam {
	@Test
	public void queryparam()
	{
		baseURI="https://reqres.in";
		
		given()
		.queryParam("page", 2)
		
		.when()
		.get("/api/users")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
