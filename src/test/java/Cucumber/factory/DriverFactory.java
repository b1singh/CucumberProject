package Cucumber.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public static WebDriver IntitializeDriver(String browser) {
		WebDriver driver;
		System.out.println(browser);
		switch (browser) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", "D:\\Framework\\Selenium-framework\\Rbc.Cucumber.Framework\\src\\test\\resources\\testDataResources\\chromedriver.exe");
			ChromeOptions handlingssl=new ChromeOptions();
			handlingssl.addArguments("--remote-allow-origin=*");
			driver=new ChromeDriver(handlingssl);
			break;
		case "FIREFOX":
			driver=new FirefoxDriver();
			break;
		case "EDGE":
			System.setProperty("webdriver.edge.driver", "D:\\Framework\\Selenium-framework\\Rbc.Cucumber.Framework\\src\\test\\resources\\testDataResources\\msedgedriver.exe");
			driver=new EdgeDriver();
			break;

		default: throw new RuntimeException("INVALID Browser"+browser);
			
		}
		driver.manage().window().maximize();
		return driver;
	}

}
