package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Doctor extends BasePage{

	public Doctor(WebDriver driver) 
	{
		super(driver);
	}
	List<String> doctordetails=new ArrayList<String>();
	
    //1
    //click on patient
    //@FindBy(xpath="//span[@data-qa-id='doctor_review_count_selected']")
    @FindBy(xpath="(//span[text()='Patient Stories'])[1]")
	WebElement patient;
    
    //click on 10+Patient Stories
//    @FindBy(xpath="//ul[@data-qa-id=\"doctor_review_count_list\"]")
//    List<WebElement> stories;
    @FindBy(xpath="//ul[@tabindex=\"0\"]//li[1]")
    WebElement stories;
    
     //2
     //click on experience
     @FindBy(xpath="//span[@data-qa-id='years_of_experience_selected']")
     WebElement exp;
    	    
     //click on years
     @FindBy(xpath="//span[text()='5+ Years of experience']")
     WebElement years;
     
     //Filters
     @FindBy(xpath="//span[text()='All Filters']")
     WebElement AllFilter;
     
     //Fees
     @FindBy(xpath="//span[text()='Above ₹500']")
     WebElement fees;
  
     //availability
     @FindBy(xpath="//span[@data-qa-id='Available Today_label']")
     WebElement availability;
     
      //sort
      @FindBy(xpath="//span[@class='c-sort-dropdown__selected c-dropdown__selected']")
      WebElement sort;
      
      @FindBy(xpath="//span[text()='Experience - High to Low']")
      WebElement sortopt;
      
      //five doctors details
      @FindBy(xpath="//div[@data-qa-id='doctor_card']//div[@class='info-section']")
      List<WebElement> details;
      

	//ActionMethods
	public void Patientstories() {
		patient.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElements(stories));
		stories.click();
	}
//	public List<WebElement> get_Patient_Stories()
//	{
//		return stories;
//	}
	
    public void Experience()
    {
    	
    	exp.click();
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElements(years));
    	years.click();
    }
   
    public void Filter()
    {
    
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElements(AllFilter));
    	AllFilter.click();
    	

    }
    
    public void Fees()
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(AllFilter));
    	fees.click();
    }
    public void Availability()
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(AllFilter));
    	availability.click();
    }
    
    public void SortBy()
    {
    	sort.click();
    	sortopt.click();
    }

    public List<String> Doctordetails(){
		for(WebElement e:details) {
			doctordetails.add(e.getText());
		}
		return doctordetails;
	}
   
}