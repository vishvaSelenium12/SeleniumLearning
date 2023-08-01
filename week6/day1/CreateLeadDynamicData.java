package week6.day1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testleaf.base.BaseClass;
import org.testng.annotations.Test;

public class CreateLeadDynamicData extends BaseClassStaticParameter{

	
	@Test(dataProvider="sendCreateLeadData")
	public void runCreateLead(String companyname, String firstname, String lastname) {
		//get title
		String titleName =driver.getTitle();
		System.out.println(titleName);
		
		//click on lead
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		//driver.findElement(By.linkText("Leads")).click();

		// click on create lead
		driver.findElement(By.linkText("Create Lead")).click();

		//enter company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyname);

		//enter first name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);

		//enter last name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);

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
	
	@DataProvider
	public String[][] sendCreateLeadData() {
		
		String[][] data = new String[2][3];
		//1st row
		data[0][0]="TCS";
		data[0][1]="Vishvanathan";
		data[0][2]="Veerabathiran";
		
		//2nd data
		data[1][0]="TCS";
		data[1][1]="Gomathi";
		data[1][2]="Vishvanathan";
		
		return data;
	}

}
