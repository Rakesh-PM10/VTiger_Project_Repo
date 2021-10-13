package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;
/**
 * generic class to read random data
 * @author Rakesh PM
 *
 */
public class JavaUtility {
	/**
	 * generic method to read random data
	 * @return
	 */
	public static String getRandomData()
	{
		Random random= new Random();
		int r = random.nextInt(1000);
		return ""+r;
	}
	
	public static String getCurrentDate()
	{
		Date date=new Date();
		String currentdate = date.toString();
		return currentdate;
	}

}
