package Demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromPropertyFile {
	@Test
	public void readDataFromPropertyFile() throws IOException {
		/*
		 * read the data from propertyfile
		 */
		//step 1: get the java representative object of the physical file
		FileInputStream fis=new FileInputStream("./Data/commonData.properties");
		//step 2: Create an object of properties class and load all he keys: value pair
		Properties p= new Properties();
		p.load(fis);
		//step 3: read the value using getproperty("key") 
		String url=p.getProperty("url");
		String browser = p.getProperty("browser");
		String un = p.getProperty("username");
		String pwd = p.getProperty("password");
		System.out.println(url);
		System.out.println(browser);
		System.out.println(un);
		System.out.println(pwd);
		
		
	}

}
