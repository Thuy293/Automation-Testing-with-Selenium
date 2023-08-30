package com.automation.utils;

import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;


public class PropertiesFileUtils {
	
	public static String getPropertyValue(String key) throws IOException {
		FileInputStream file = new FileInputStream("./configuration/configs.properties");
		Properties properties = new Properties();
		properties.load(file);
		return (String) properties.get(key);
		
	}

}
