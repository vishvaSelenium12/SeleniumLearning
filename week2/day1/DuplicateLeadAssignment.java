package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DuplicateLeadAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Entering username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//Entering password
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
		
		//enter first name local
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("VishvaVG");
		
		//enter department
		driver.findElement(By.name("departmentName")).sendKeys("QA");
		
		//enter description
		driver.findElement(By.name("description")).sendKeys("QA Automation learning");
		
		//enter email id
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("vishvaabc@gmail.com");	
		
		// Select State/Province as NewYork Using Visible Text
		WebElement selectState =driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select ss= new Select(selectState);
		ss.selectByVisibleText("New York");
		
		//click on create lead
		driver.findElement(By.name("submitButton")).click();
		
		String createLeadtitleName=driver.getTitle();
		if(createLeadtitleName.startsWith("View Lead"))
			System.out.println("Title name is:" + createLeadtitleName);
		//click on duplicate lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		//compnay name clear
		WebElement companyNameField =driver.findElement(By.id("createLeadForm_companyName"));
		companyNameField.clear();
		companyNameField.sendKeys("TCS New");
		
		//first name clear
		
		WebElement firstNameField =driver.findElement(By.id("createLeadForm_firstName"));
		firstNameField.clear();
		firstNameField.sendKeys("VishvanathanGomathi");
		
		driver.findElement(By.name("submitButton")).click();
		String createLeadtitleNameAfter=driver.getTitle();
		if(createLeadtitleName.startsWith("View Lead"))
			System.out.println("Title name is:" + createLeadtitleNameAfter);
		driver.close();
		
	}

}
