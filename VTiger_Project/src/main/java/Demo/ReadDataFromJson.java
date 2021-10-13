package Demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class ReadDataFromJson {
	/*
	 * This method will return json value based on json key
	 */
//	@Test
//	public void getDataFromJson() throws Throwable
//	{
//		FileReader reader= new FileReader("./Data/CommonData.json");
//		JSONParser parser= new JSONParser();
//		Object object=parser.parse(reader);
//		JSONObject jsonObject=(JSONObject)object;
//		String value = jsonObject.get("url").toString();
//		String value2 = jsonObject.get("username").toString();
//		
//		System.out.println(value);
//		System.out.println(value2);
//		
//	}
	@Test
	public void getDataFromJson() throws Throwable  {
	//read the data from data file
	FileReader reader= new FileReader("./Data/CommonData.json");
	//convert json file into java object
	JSONParser parser= new JSONParser();
	 Object jobj = parser.parse(reader);
	//typecast java object to hashmap
	HashMap map= (HashMap) jobj;
	String url = map.get("url").toString();
	String un = map.get("username").toString();
	String pwd = map.get("password").toString();
	System.out.println(url);
	System.out.println(un);
	System.out.println(pwd);
	}
}
