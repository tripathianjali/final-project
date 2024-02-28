package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class HomePage extends BasePage{
       //Action act;
	
		public HomePage(WebDriver driver) 
		{
			super(driver);
		}
		//click search location
		@FindBy(xpath="//input[@data-qa-id='omni-searchbox-locality']")
		WebElement search1;
		
		//clear
		@FindBy(xpath="//span[@class='c-omni-clear']")
		WebElement clear;
		
		//send Bangalore 
//		@FindBy(xpath="(//div[@class='c-omni-searchbox_wrapper'])[1]")
		@FindBy(xpath="//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input")
		WebElement location;
		
		//click Bangalore
		@FindBy(xpath="(//div[text()='Bangalore'])[1]")
		WebElement locclick;
		
		
	    //clicking search dentist
	    @FindBy(xpath="(//div[@class='c-omni-searchbox_wrapper '])[2]")
	    WebElement search;
	    
	    //sending dentist
	    @FindBy(xpath="//div[text()='Dentist']")
	    WebElement dentist;
	    
	    public void SearchBox() 
	    {
			search1.click();
			clear.click();
			//search1.clear();
		}

   public void Sendlocation() 
   {
	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
	   wait.until(ExpectedConditions.visibilityOfAllElements(location));
	   location.sendKeys("Bang");
	   locclick.click();
 	      //location.sendKeys("Bangalore");
//	        JavascriptExecutor js=(JavascriptExecutor)driver;
//	    	js.executeScript("arguments[0].setAttribute('value','Bangalore')",location);
//	        Actions act=new Actions(driver);
//	        act.sendKeys(location,"Bangalore").perform();
	   
		}
	    public void SearchBox2()
	    {
	    	search.click();
	    	dentist.click();
	    }
}
