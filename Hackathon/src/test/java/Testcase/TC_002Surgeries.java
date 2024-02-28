package Testcase;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Test.BaseClass;
import Utilities.ExcelUtility;
import pageObjects.Surgeries;

public class TC_002Surgeries extends BaseClass{

	Surgeries surg;
	
	 @Test(priority=12)
	   public void PopularSurgery() throws InterruptedException 
	    {
		 surg= new Surgeries(driver);
		 surg.PopularSurgery();
		 Thread.sleep(1000);
	    }	 
	 
	 @Test(priority=13)
	   public void writeData() 
	    {
		List<WebElement> list= surg.get_Popular_Surgeries();
		int row=1;
		String heading="";
		for(WebElement el: list)
		{
			heading=el.getText();
			
			try 
			{
				System.out.println(heading);
				ExcelUtility.write("Surgery Names",0,0,"Popular Surgery Names");
				ExcelUtility.write("Surgery Names",row,0,heading);
			} 
			catch (Exception e) 
			{
				
				e.printStackTrace();
			}
            row++;
			
		}
		
	    }
}
