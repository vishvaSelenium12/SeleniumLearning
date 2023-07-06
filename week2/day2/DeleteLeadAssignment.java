package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLeadAssignment {

	public static void main(String[] args) throws InterruptedException {
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
		
		//click on phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		//Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9");
		
		//click on find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		//Capture lead ID of First Resulting lead
		WebElement firstResulting =driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		String firstresultLeadId =firstResulting.getText();
		System.out.println("First resulting lead id is:" + firstresultLeadId);
		
		//Click First Resulting lead
		firstResulting.click();
		
		Thread.sleep(3000);
		//click on delete
		driver.findElement(By.linkText("Delete")).click();
		
		//click on find lead
		driver.findElement(By.linkText("Find Leads")).click();
		
		//enter the capture lead id
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(firstresultLeadId);
		
		//click on find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		String textConfirm =driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		if(textConfirm.contains("No records to display")) {
			System.out.println("Record deleted succesfully:"+ textConfirm);
		}
		
		//close the browser
		driver.close();
		
	}

}
