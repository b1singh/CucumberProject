package Cucumber.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
	
	public static Properties propertyLoader(String filepath)
	{
		Properties prop=new Properties();
		BufferedReader reader;
		try
		{
			reader=new BufferedReader(new FileReader(filepath));
			try
			{
				prop.load(reader);
				reader.close();
			}catch (IOException e) {
				// TODO: handle exception
				throw new RuntimeException("Failed to load property file"+filepath);
			}
			
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			throw new RuntimeException("propert file not found at"+filepath);
		}
		return prop;
	}

}
