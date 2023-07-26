package org.testleaf.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public ChromeDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Entering username
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		
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

	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}
	
}
