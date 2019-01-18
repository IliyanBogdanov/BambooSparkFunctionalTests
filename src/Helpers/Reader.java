package Helpers;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class Reader {

	private static Properties PropertyFile;
	public static Properties ReadFromPropertyFile()
	{
		try 
		{
	
			PropertyFile = new Properties();
			String propFileName = "iOSElementsInDifferentLanguagesPropertyFiles/English.properties";
 
			InputStream	inputStream = Reader.class.getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				PropertyFile.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + PropertyFile + "' not found in the classpath");
			}
		}catch(Exception e)
		{
			System.out.println("Reading properties file error!!!");
		}
		
		return PropertyFile;
	}
	
}
