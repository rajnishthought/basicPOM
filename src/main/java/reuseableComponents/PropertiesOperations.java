package reuseableComponents;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesOperations {
	
	public static String getPropertyValueByKey(String Key) throws Exception {
		//1. load data from properties file
		
		String userDir = System.getProperty("user.dir");
		String propFilePath = userDir+"\\src\\test\\resources\\config.properties";
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(propFilePath);
		prop.load(fis);
		
		//2. read data
		String value = prop.get(Key).toString();
		
		if(StringUtils.isEmpty(value)) {
			throw new Exception("Value not found in the properties file!");
		}
		return value;
	}
}
