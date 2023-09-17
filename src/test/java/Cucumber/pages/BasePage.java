package Cucumber.pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Cucumber.managers.FileReaderManager;


public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	public String timestamp=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(new Date());
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	public void loadendpoint(String endpoint) {
		driver.get(FileReaderManager.getInstance().getConfigReader().getBaseUrl()+endpoint);
	}
	public String getPageURL(){
		return driver.getCurrentUrl();
	}
	public void waitForOverlaysToDisappear(By overlay) {
		List<WebElement> overlays=driver.findElements(overlay);
		System.out.println("OVERLAY SIZE"+overlays.size());
		if(overlays.size()>0) {
			wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
			System.out.println("OVERLAYS INVISIBLE");
		}else {
			System.out.println("OVERLAY NOT FOUND");
		}
	}
	public void closeBrowser() {
		driver.quit();
	}

}
