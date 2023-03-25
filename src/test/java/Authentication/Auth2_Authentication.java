package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class Auth2_Authentication {
	@Test
	public void authentication()
	{
		 Response resp = given()
		.formParam("client_id", "vital-bowl")
		.formParam("client_secret", "c6f169ec9d33a81e3483339648c4edf8")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://www.vitalbowl.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
			
		String token=resp.jsonPath().get("access_token"); System.out.println(token);
		System.out.println(token);
		given() .auth().oauth2(token) .pathParam("USER_ID", 4219)
	    .when() .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then().log().all();
		
		
	}

}
