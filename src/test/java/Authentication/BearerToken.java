package Authentication;



import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import createprojectbypojo.RandomNumber;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;

import static io.restassured.RestAssured.*;

public class BearerToken {
	
	@Test
	public void beareauth()
	{
		RandomNumber ran = new RandomNumber();
	   baseURI="https://api.github.com";
	   JSONObject jobj = new JSONObject();
	   jobj.put("name", "homepractice"+ran.randomnum());
	   
	   given()
	   .auth()
	   .oauth2("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")
	   .body(jobj)
	   .contentType(ContentType.JSON)
	   
	   .when().post("/user/repos")
	   .then().log().all();
	}

}
