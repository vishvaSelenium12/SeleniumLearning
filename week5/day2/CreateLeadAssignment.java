package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testleaf.base.BaseClass;
import org.testng.annotations.Test;

public class CreateLeadAssignment extends BaseClass{

	@Test
	public void runCreateLead() {
		//get title
		String titleName =driver.getTitle();
		System.out.println(titleName);

		//click on lead
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		//driver.findElement(By.linkText("Leads")).click();

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

		

	}

}
