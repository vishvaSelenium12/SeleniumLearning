package week6.day2;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testleaf.base.BaseClass;
import org.testng.annotations.Test;

import io.netty.channel.ChannelPromiseAggregator;

public class EditLeadExplicityWait {

	@Test
	public void runEditLead() throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
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
		
		//get title
		String titleName =driver.getTitle();
		System.out.println(titleName);
		
		//Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		//click on find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Vishvanathan");
		
		//Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		WebElement eleFirstResult =driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']/div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(eleFirstResult));
		//Click on first resulting lead
		driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']/div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		// Verify title of the page
		String titleNameVerifyPage =driver.getTitle();
		if(titleNameVerifyPage.contains("View Lead")) {
			System.out.println("Loaded page is corerct:" + titleNameVerifyPage);
		}
		
		//Click Edit
		driver.findElement(By.linkText("Edit")).click();
		
		//change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("New");
		
		//click on update button
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		String changedName =driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		if(changedName.contains("New")) {
			System.out.println("Changed name is corerct:" + changedName);
		}
		
		driver.close();
		
	}

}
