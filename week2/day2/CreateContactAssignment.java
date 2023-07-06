package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContactAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Entering username
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoCsr");
		
		//driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//entering password
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		//driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		
		// click on login button 
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		//driver.findElement(By.className("decorativeSubmit")).click();
		
		//click on crmsfa
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		//driver.findElement(By.partialLinkText("CRM")).click();
		
		//get title
		String titleName =driver.getTitle();
		System.out.println(titleName);
		
		//Click on Create Contact
		driver.findElement(By.linkText("Create Contact")).click();
		
		// Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys("Vishvanathan");
		
		//Enter LastName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys("Veerabathiran");
		
		//Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.name("firstNameLocal")).sendKeys("vishva");
		
		// Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("veera");

		//Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("QA Test");
		
		//Enter Description Field Using any Locator of your choice
		driver.findElement(By.id("createContactForm_description")).sendKeys("QA Test lead description");
		
		//Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("abcvishva@gmail.com");
		
		//Select State/Province as NewYork Using Visible Text
		WebElement stateDrop =driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select ss = new Select(stateDrop);
		ss.selectByVisibleText("New York");
		
		//Click on Create Contact
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		//Click on edit button 
		driver.findElement(By.linkText("Edit")).click();
		//Clear the Description Field using .clear
		driver.findElement(By.id("updateContactForm_description")).clear();
		
		//Fill ImportantNote Field with Any text
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Updating description team");
		
		//Click on update button using Xpath locator
		driver.findElement(By.xpath("//input[@name='submitButton' and @value='Update']")).click();
		
		String titleName1 = driver.getTitle();
		System.out.println("Page Title name is:" + titleName1);
		
		//closing browser
		driver.close();
		
	}

}
