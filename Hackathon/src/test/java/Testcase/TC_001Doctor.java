package Testcase;

import org.testng.annotations.Test;
import Test.BaseClass;
import Utilities.ExcelUtility;
import pageObjects.Doctor;
import pageObjects.HomePage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TC_001Doctor extends BaseClass {
 
	HomePage hp;
	Doctor doc;
	
	List<String> docDetails=new ArrayList<String>();
	
	List<String> doctorName = new ArrayList<String>();
	List<String> doctorSpecialization = new ArrayList<String>();
	List<String> doctorExperience = new ArrayList<String>();
	List<String> doctorLocation = new ArrayList<String>();
	List<String> doctorFee = new ArrayList<String>();
	
	@Test(priority=1)
	public void click_LocationSearchBox() throws InterruptedException
	{
	    hp = new HomePage(driver);
		hp.SearchBox();
		Thread.sleep(3000);
	}

	@Test(priority=2)
	public void Location() throws InterruptedException
	{
		hp = new HomePage(driver);
		hp.Sendlocation();
		Thread.sleep(2000);
	}
	@Test(priority=3)
	public void click_SearchDentist() throws InterruptedException
	{
		hp = new HomePage(driver);
		hp.SearchBox2();
		Thread.sleep(2000);
	}

	@Test(priority=4)
	public void click_PatientStories() throws InterruptedException
	{
		Doctor doc = new Doctor(driver);
		Thread.sleep(2000);	
		doc.Patientstories();
		Thread.sleep(3000);
	}

//	public void getting_PatientStories() throws InterruptedException
//	{
//		Doctor doc = new Doctor(driver);
//		Thread.sleep(2000);	
//	    List<WebElement> str= doc.get_Patient_Stories();
//	    str.get(0).click();
//	   
//	}

	
	@Test(priority=5)
	public void click_Experience() throws InterruptedException
	{
		Doctor doc = new Doctor(driver);
		doc.Experience();
		Thread.sleep(1000);
	}

	
	@Test(priority=6)
	public void click_ToApplyFilter() throws InterruptedException
	{
		Doctor doc = new Doctor(driver);
		doc.Filter();
		Thread.sleep(1000);
	}
	@Test(priority=7)
	public void select_fees() throws InterruptedException
	{
		Doctor doc = new Doctor(driver);
		doc.Fees();
		Thread.sleep(1000);
	}
	@Test(priority=8)
	public void click_ToApplyFilter2() throws InterruptedException
	{
		Doctor doc = new Doctor(driver);
		doc.Filter();
		Thread.sleep(1000);
	}
	@Test(priority=9)
	public void select_availability() throws InterruptedException
	{
		Doctor doc = new Doctor(driver);
		doc.Availability();
		Thread.sleep(1000);
	}
	@Test(priority=10)
	public void click_SortBy() throws InterruptedException
	{
		Doctor doc = new Doctor(driver);
		doc.SortBy();
		Thread.sleep(1000);
	}
		
	@Test(priority=11)
	public void getDoctordetails() throws IOException
	{
		Doctor doc = new Doctor(driver);
		docDetails=doc.Doctordetails();
		for(int i=1;i<=5;i++) {
			System.out.println(docDetails.get(i));
		}
		for (int i = 0; i <5; i++) {
			//wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(doctors.get(i))));
			doctorName.add(docDetails.get(i).split("\\n+")[0]);
			doctorSpecialization.add(docDetails.get(i).split("\\n+")[1]);
			doctorExperience.add(docDetails.get(i).split("\\n+")[2]);
			doctorLocation.add(docDetails.get(i).split("\\n+")[3]);
			doctorFee.add(docDetails.get(i).split("\\n+")[4]);
			try {
			ExcelUtility.write("Doctor Details", i, 0, doctorName.get(i));
			ExcelUtility.write("Doctor Details", i, 1, doctorSpecialization.get(i));
			ExcelUtility.write("Doctor Details", i, 2, doctorExperience.get(i));
			ExcelUtility.write("Doctor Details", i, 3, doctorLocation.get(i));
			ExcelUtility.write("Doctor Details", i, 4, doctorFee.get(i));
			}
			catch(Exception e) {
				
			}
		}
	
	}
}
