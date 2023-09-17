package Cucumber.hooks;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Cucumber.context.TestContext;
import Cucumber.factory.DriverFactory;
import Cucumber.managers.FileReaderManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	private WebDriver driver;
	private final TestContext context;
	public Hooks(TestContext context)
	{
		this.context=context;
	}
	@Before
	public void before(Scenario sceanario) {
		System.out.println("start of test");
		sceanario.log("exe start date:"+logtime());
		sceanario.log("cucumber");
		System.out.println("beforehook"+sceanario.getName());
		System.out.println("browser is:"+FileReaderManager.getInstance().getConfigReader().getBrowser().toString());
		driver=DriverFactory.IntitializeDriver(FileReaderManager.getInstance().getConfigReader().getBrowser().toString());
		context.driver=driver;
	}
	public String logtime()
	{
		String timestamp=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(new Date());
		return timestamp;
	}
	@After
	public void after(Scenario sceanario)
	{
		sceanario.log("exe_end_date"+logtime());
		try {
			if(sceanario.isFailed()) {
				sceanario.log("status: FAIL");
			/*	final byte[] sceenshot =((TakesScreenshot)driver)
						.getScreenshotAs(OutputType.FILE);
				sceanario.attach(null, null, null);*/
			}
			else
				sceanario.log("status: PASS");
		}finally {
		}
		System.out.println("afterHook:"+ sceanario.getName());
		
	}

}
