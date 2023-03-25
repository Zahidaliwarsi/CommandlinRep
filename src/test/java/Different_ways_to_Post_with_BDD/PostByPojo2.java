package Different_ways_to_Post_with_BDD;

import org.testng.annotations.Test;

import createprojectbypojo.PojoClassManual;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostByPojo2 {
	@Test
	public void postpojo2()
	{
	   PojoClassManual pn = new PojoClassManual("zahid", "zahid_7988", "created", 16);
	   
	   baseURI="http://rmgtestingserver";
	   port = 8084;
	   
	   given()
	   .body(pn)
	   .contentType(ContentType.JSON)
	   
	   .when()
	   .post("/addProject")
	   
	   .then()
	   .assertThat()
	   .statusCode(201)
	   .contentType(ContentType.JSON)
	   .log().all();
	}

}
