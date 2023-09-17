package Cucumber.managers;

import Cucumber.dataProviders.ConfigFileReader;
import Cucumber.dataProviders.JsonDataReader;

public class FileReaderManager {
	private static FileReaderManager fileReaderManager=new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static JsonDataReader  jsonDataReader;
	
	public static FileReaderManager getInstance()
	{
		return fileReaderManager;
	}
	public static ConfigFileReader getConfigReader()
	{
		return (configFileReader==null) ? new ConfigFileReader(): configFileReader;
	}
	public static JsonDataReader getJsonReader()
	{
		return (jsonDataReader==null) ? new JsonDataReader():jsonDataReader;
	}

}
