package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.json.simple.parser.JSONParser;

/**
 * generic class to read data from external files
 * @author Rakesh PM
 *
 */
public class FileUtility {
	/**
	 * generic method to read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyData (String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstant.PROPERTY_FILEPATH);
		Properties p = new Properties();
		p.load(fis);
		String v=p.getProperty(key);
		return v;
	}
	
	/**
	 * generic method to read data from JSON file
	 * @param jsonKey
	 * @return
	 * @throws Throwable
	 */
	public String getJsonFileData (String jsonKey) throws Throwable
	{
		FileReader reader = new FileReader(IPathConstant.JSON_FILEPATH);
		JSONParser parser= new JSONParser();
		Object jObj = parser.parse(reader);
		HashMap map= (HashMap) jObj;
		String value = map.get(jsonKey).toString();
		return value;
		
	}
	

}
