package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Surgeries extends BasePage {
 
	JavascriptExecutor js;
	
	public Surgeries(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//div[text()='Surgeries']")
     WebElement Surgery;
	
	@FindBy(xpath="//h1[text()='Popular Surgeries']")
	WebElement Popular;
	
	@FindBy(xpath="//*[@id=\"surgeries\"]/div/div[1]/div/div/div")
	List<WebElement> list;

	public void PopularSurgery()
	{
		Surgery.click();
        js=(JavascriptExecutor)driver;	
		js.executeScript("arguments[0].scrollIntoView();",Popular);
	}
	
	public List<WebElement> get_Popular_Surgeries()
	{
		return list;
	}

}
