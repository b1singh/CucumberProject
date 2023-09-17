package Cucumber.dataProviders;

import java.util.Properties;

import Cucumber.constants.DriverType;
import Cucumber.constants.EnvironmentType;
import Cucumber.utils.PropertyUtils;

public class ConfigFileReader {
    private final Properties properties;
    public ConfigFileReader() {
		// TODO Auto-generated constructor stub
    	String env=System.getProperty("env", String.valueOf(EnvironmentType.IST));
    	switch(EnvironmentType.valueOf(env)) {
    	     case PROD:
    	    	 properties=PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
    	    	 break;
    	     case IST:
    	    	 properties=PropertyUtils.propertyLoader("src/test/resources/ist_config.properties");
    	    	 break;
    	     case SDF:
    	    	 properties=PropertyUtils.propertyLoader("src/test/resources/SDF_config.properties");
    	    	 break;
    	    default:
    	    	throw new IllegalStateException("INVALID ENV:"+env);
    	    
    	}
	}
    public String getTestDataResourcePath()
    {
    	String testDataResourcePath=properties.getProperty("testDataResourcePath");
    	if(testDataResourcePath!=null)
    	{
    		return testDataResourcePath;
    	}
    	else
    	{
    		throw new RuntimeException("Test data resources path is not specified in the configuration file for the key: testDataResourcePath");
    	}
    }
    public String getBaseUrl()
    {
    	String URL=properties.getProperty("baseUrl");
    	if(URL!=null) return URL;
    	else throw new RuntimeException("Property base url is not specified in the config.properties file");
    }
    public DriverType getBrowser()
    {
    	String browserName=properties.getProperty("browser");
    	if(browserName==null || browserName.equals("chrome")) return DriverType.CHROME;
    	else if (browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
    	else if(browserName.equals("edge")) return DriverType.EDGE;
    	else throw new RuntimeException("browser name key value in the configuration.properties is not matched:"+browserName);
    }
    

   }
