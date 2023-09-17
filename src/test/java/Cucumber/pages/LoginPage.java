package Cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Cucumber.dataProviders.ConfigFileReader;
import Cucumber.testDataTypes.Data;

public class LoginPage extends BasePage{
	WebDriver driver;
	ConfigFileReader configFileReader;
	public LoginPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH,using = "//*[@name='q']")
	private WebElement customerId;
	
	//public String customer_id="//*[@name='q']";
	
	
	
	public void enterCustomerId(Data clientinfo)
	{
		try {
		customerId.click();
		String customerid=clientinfo.credentials.clientcardNumber;
		System.out.println("customerid"+customerid);
		customerId.sendKeys(customerid);
		System.out.println("done");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
