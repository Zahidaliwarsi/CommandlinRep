package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import SerializationPackage.EmployeeDetails;

public class Desrialization {
	public static void main(String[]args) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper obj=new ObjectMapper();
		
		EmployeeDetails e1 = obj.readValue(new File("./file1.json"),EmployeeDetails.class);
		
	//	System.out.println(e1.getName());
	//	System.out.println(e1.getEmailid());
		System.out.println(e1.getPhoneno()[0]);
		System.out.println(e1.getPhoneno()[1]);
		System.out.println(e1.getKids());
		
	}

}
