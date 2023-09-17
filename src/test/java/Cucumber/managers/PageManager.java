package Cucumber.managers;

import org.openqa.selenium.WebDriver;

import Cucumber.pages.LoginPage;

public class PageManager {
	private static LoginPage loginPage;
	public static LoginPage getLoginPage(WebDriver driver) {
		return loginPage==null ? new LoginPage(driver):loginPage;
	}

}
