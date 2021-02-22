package com.takehometest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	public  Properties getPropertiesFromFile(String propertyFileName) throws IOException {
		Properties prop = new Properties();
		try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName)) {
			
			if(inputStream!=null) {
				prop.load(inputStream);
			}
			else throw new FileNotFoundException("Property File  "+propertyFileName+" is not present on classpath");
		}
		return prop;
	}

}
