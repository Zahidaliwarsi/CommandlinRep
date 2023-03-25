package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import SerializationPackage.EmployeeDetails;
import SerializationPackage.Kids;




public class Serialization {
	
	public static void main(String[]args) throws JsonGenerationException, JsonMappingException, IOException
	{
		Long phno[] = {7725924830l,8967856745l};
		Kids kl = new Kids("vikram", 27);
		EmployeeDetails emp = new EmployeeDetails("Zahid", "Delhi", "aliwarsizahid@gmail.com",phno,kl);
		
		ObjectMapper omap = new ObjectMapper();
		
		omap.writeValue(new File("./file1.json"),emp);
		
	}

}
