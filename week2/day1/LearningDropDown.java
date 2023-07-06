package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearningDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Entering username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//entering password
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		
		// click on login button 
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//click on crmsfa
		driver.findElement(By.partialLinkText("CRM")).click();
		
		//get title
		String titleName =driver.getTitle();
		System.out.println(titleName);
		
		//click on lead
		
		driver.findElement(By.linkText("Leads")).click();
		
		// click on create lead
		driver.findElement(By.linkText("Create Lead")).click();
		
		//enter company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");
		
		//enter first name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vishvanathan");
		
		//enter last name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Veerabathiran");
		
		//select webelement
		
		WebElement sourceElement =driver.findElement(By.id("createLeadForm_dataSourceId"));
		
		Select ss = new Select(sourceElement);
		
		// Select by  value
		//ss.selectByValue("LEAD_EMPLOYEE");
		
		//select by index employee 
		
		ss.selectByIndex(4);
		
		//select by value
		
		//ss.selectByVisibleText("Employee");
		
		
		WebElement marketelement =driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select ss1 = new Select(marketelement);
		ss1.selectByVisibleText("Automobile");
		WebElement ownElement =driver.findElement(By.name("ownershipEnumId"));
		Select ss2 = new Select(ownElement);
		ss2.selectByValue("OWN_SCORP");
		
		driver.findElement(By.name("submitButton")).click();
		
		String createLeadtitleName=driver.getTitle();
		if(createLeadtitleName.startsWith("View Lead"))
			System.out.println("Title name is:" + createLeadtitleName);
		
		String companyName=driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(companyName.equals("TCS")) {
			System.out.println("Entered name is corerct :" + companyName);
		}
		
		driver.close();
	}

}
