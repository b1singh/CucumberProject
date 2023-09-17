package Cucumber.stepdefinitions;

import Cucumber.constants.EndPoint;
import Cucumber.context.TestContext;
import Cucumber.managers.FileReaderManager;
import Cucumber.managers.PageManager;
import Cucumber.pages.LoginPage;
import Cucumber.testDataTypes.Data;
import io.cucumber.java.en.*;

public class LoginStepdefinitions {

	private final LoginPage loginpage;
	private final TestContext context;
	
	public LoginStepdefinitions(TestContext context)
	{
		this.context=context;
		loginpage=PageManager.getLoginPage(context.driver);
	}
	@Given("Client is on the login page")
	public void client_is_on_the_login_page() {
	   System.out.println("Navigating to base URL");
	   loginpage.loadendpoint(EndPoint.LOGIN.url);
	}

	@When("Client enters custometId creds {string}")
	public void client_enters_customet_id_creds_automation_card_id(String automationCardID) {
	    System.out.println("Entering customer id");
	    try
	    {
	    	System.out.println(automationCardID);
	    	Data clientinfo=FileReaderManager.getInstance().getJsonReader().getClientbyAutomationId(automationCardID);
	    	System.out.println(clientinfo);
	    	assert clientinfo !=null;
	    	System.out.println(clientinfo.credentials.clientcardNumber);
	    	loginpage.enterCustomerId(clientinfo);
	    }catch (NullPointerException e) {
			// TODO: handle exception
		}
	}
	
}
