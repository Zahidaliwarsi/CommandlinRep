package DataProvider_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import createprojectbypojo.PojoClass;
import createprojectbypojo.RandomNumber;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataProvide {
	
	@Test(dataProvider="getData")
	public void fetchData(String createdBy,String projectName,String status,int teamSize)
	{
		RandomNumber ran = new RandomNumber();
		PojoClass pj = new PojoClass(createdBy, projectName+ran.randomnum(), status, teamSize);
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().body(pj).contentType(ContentType.JSON)
		
		.when().post("/addProject")
		.then().statusCode(201).contentType(ContentType.JSON).log().all();
	}
	
	@DataProvider(name="getData")
	public Object[][] shareData()
	{
		Object[][] obj = new Object[3][4];
		
		obj[0][0]="chitra";
		obj[0][1]="Dell";
		obj[0][2]="created";
		obj[0][3]=10;
		
		obj[1][0]="zahid";
		obj[1][1]="HP";
		obj[1][2]="created";
		obj[1][3]=12;
		
		obj[2][0]="piyush";
		obj[2][1]="Apple";
		obj[2][2]="created";
		obj[2][3]=17;
		return obj;
	}

}
