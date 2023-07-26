package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testleaf.base.BaseClass;
import org.testng.annotations.Test;

public class DuplicateLeadsAssignment extends BaseClass {

	@Test
	public void runDuplicateLead() throws InterruptedException {
		// TODO Auto-generated method stub
		
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
		
	}

}
