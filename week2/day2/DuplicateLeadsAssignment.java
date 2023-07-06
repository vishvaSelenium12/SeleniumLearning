package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLeadsAssignment {

	public static void main(String[] args) throws InterruptedException {
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
		
		//Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		//click on find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//click on email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		//Enter Email
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("abc");
		
		//click on find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		//Capture name of First Resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		//Click Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		//Verify the title as 'Duplicate Lead
		String titleNameDuplicateLead=driver.getTitle();
		if(titleNameDuplicateLead.contains("Duplicate Lead")) {
			System.out.println("Loaded page is correct: "+ titleNameDuplicateLead);
				
		}
		
		//click on create lead
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Confirm the duplicated lead name is same as captured name
		//closing browser
		driver.close();
	}

}
