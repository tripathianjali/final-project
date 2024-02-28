package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Utilities.ExcelUtility;

public class HealthandWellness extends BasePage {

	String[] data=ExcelUtility.read();
	Select s;
	
	public HealthandWellness(WebDriver driver) 
	{
		
		super(driver);
	}
		//click For Corporate 
		@FindBy(xpath="(//span[text()='For Corporates'])[1]")
	     WebElement corporate;
		
		//click Health and Wellness
		@FindBy(xpath="//a[text()='Health & Wellness Plans']")
		WebElement Wellness;
		
		//name
		@FindBy(xpath="//input[@id='name']")
		WebElement name;
		
		//organization
		@FindBy(xpath="//input[@id='organizationName']")
		WebElement organization;
		
		//contact
		@FindBy(xpath="//input[@id='contactNumber']")
		WebElement contact;
		
		//emailid
		@FindBy(xpath="//input[@id='officialEmailId']")
		WebElement EmailId;
				
		//Orgsize
		@FindBy(xpath="//select[@id='organizationSize']")
		WebElement dropdown1;
		
		//select 500
		@FindBy(xpath="(//select[@id='organizationSize']/option)[2]")
		WebElement select1;
	        
		//Intrestedin
		@FindBy(xpath="//select[@id='interestedIn']")
		WebElement dropdown2;
				
	    //select 
	    @FindBy(xpath="(//select[@id='interestedIn']/option)[2]")
	    WebElement select2;
	    
	    //schedule a demo
	    @FindBy(xpath="(//button[text()='Schedule a demo'])")
        WebElement button;
	    
	    @FindBy(xpath="(//div[text()='THANK YOU'])")
	    WebElement thanks;
		
		public void Corporates()
		{
			corporate.click();
			Wellness.click();
		}
				
		public void Name()
		{
			name.sendKeys(data[0]);
			organization.sendKeys(data[1]);
			contact.sendKeys(data[2]);
		}
		
		public void Invalidemail ()
		{
			EmailId.sendKeys(data[3]);
		}
		
		public void Validemail ()
		{
			EmailId.clear();
			EmailId.sendKeys(data[4]);
		}
		
	    public void OrganizationSize()
	    {
	    	
	    	s=new Select(dropdown1);
	    	s.selectByValue("<=500");
//	    	dropdown1.click();
//	    	select1.click();
	    }
	    
	    public void IntrestedIn()
	    {
	    	s=new Select(dropdown2);
	    	s.selectByValue("Taking a demo");
	    	//dropdown2.click();
	    	//select2.click();
	    }
	    
	    public void DemoButton()
	    {
	    	button.isEnabled();
	    	button.click();
	    }
	    
	    public void Thankyou()
	    {
	    String msg=thanks.getText();
	    System.out.println(msg);
	    
	    }
	}


