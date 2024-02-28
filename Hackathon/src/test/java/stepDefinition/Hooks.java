package stepDefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
import Test.BaseClass;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
 
public class Hooks
{
	public static WebDriver driver=BaseClass.driver;
	@After
	public void tearDown(Scenario scenario)
	{
		driver.quit();
	}
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
		byte[]screenshot=ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png",scenario.getName());
		}
		else
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			byte[]screenshot=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png",scenario.getName());
		}
	}

}