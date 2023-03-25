package DataProvider_package;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import createprojectbypojo.PojoClass;
import createprojectbypojo.RandomNumber;
import io.restassured.http.ContentType;

public class DataProviderByExcel {
	@Test(dataProvider="getData1")
	public void fetchDev(String createdBy,String projectName,String status,int teamSize)
	{
		RandomNumber ran = new RandomNumber();
		PojoClass pj = new PojoClass(createdBy, projectName+ran.randomnum(), status, teamSize);
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().body(pj).contentType(ContentType.JSON)
		
		.when().post("/addProject")
		.then().statusCode(201).contentType(ContentType.JSON).log().all();
	}
	@DataProvider(name="getData1")
	public String[][] dataProv() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\qqqqqqqqqqqqqqqqqqqq\\eclipse-workspace\\restassured\\src\\test\\resources\\FetchingData.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		 
		 Sheet sheet = wb.getSheet("Sheet1");
		 int lrow = sheet.getLastRowNum();
		 short lcell = sheet.getRow(0).getLastCellNum();
		 DataFormatter dformat = new DataFormatter();
		 String[][] arr=new String[lrow][lcell];
		 
		 for(int i = 1;i<lrow;i++)
		 {
			 for(int j = 0;j<lcell;j++)
			 {
				 arr[i][j] = dformat.formatCellValue(sheet.getRow(i).getCell(j));			 
			 }
		 }
		 return arr;
	}

}
