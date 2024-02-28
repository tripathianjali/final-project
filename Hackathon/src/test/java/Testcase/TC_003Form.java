package Testcase;

import java.text.Normalizer.Form;
import org.testng.annotations.Test;
import Test.BaseClass;
import pageObjects.HealthandWellness;


public class TC_003Form extends BaseClass{

    Form form;
    HealthandWellness well;
	
	@Test(priority=14)
	public void Schedule_DemoForm() throws InterruptedException
	{
	    well = new HealthandWellness(driver);
		well.Corporates();
		Thread.sleep(1000);
	}
	
	@Test(priority=15)
	public void get_Name() throws InterruptedException
	{
		well = new HealthandWellness(driver);
		well.Name();
		Thread.sleep(1000);
	}
	
	@Test(priority=16)
	public void get_invalidEmail() throws InterruptedException
	{
	    well = new HealthandWellness(driver);
		well.Invalidemail();
		Thread.sleep(1000);
	}
	@Test(priority=17)
	public void get_OrganizationSize() throws InterruptedException
	{
		well = new HealthandWellness(driver);
		well.OrganizationSize();
		Thread.sleep(1000);
	}

	@Test(priority=18)
	public void get_IntrestedIn() throws InterruptedException
	{
		HealthandWellness well = new HealthandWellness(driver);
		well.IntrestedIn();
		Thread.sleep(1000);
	}
	
	@Test(priority=19)
	public void schedule_Demo() throws InterruptedException
	{
		HealthandWellness well = new HealthandWellness(driver);
		well.DemoButton();
		Thread.sleep(1000);
	}
	
	@Test(priority=20)
	public void get_ValidEmail() throws InterruptedException
	{
		well = new HealthandWellness(driver);
		well.Validemail();
		well.DemoButton();
		Thread.sleep(30000);	
	}    
	
	@Test(priority=21)
	public void get_Thankyou() throws InterruptedException
	{
		HealthandWellness well = new HealthandWellness(driver);
		well.Thankyou();
		Thread.sleep(1000);
	}
}	

