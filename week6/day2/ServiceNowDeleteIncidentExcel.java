package week6.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class ServiceNowDeleteIncidentExcel extends BaseClassServiceNowExcel{
	
	@BeforeTest
	public void setValues(){

		WorkbookName="ServiceNowFullData";
		SheetName="DeleteIncident";
	}

	@Test(priority=3,dataProvider="sendServiceNowDatas")
	public void runServiceNowDeleteIncident(String deleteInfo) throws InterruptedException {
		
		Thread.sleep(4000);
		//Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(10);
		dom.findElementByXPath("//div[contains(text(),'All')]").click();
		//dom.findElementByXPath("//div[@class='sn-polaris-nav-header-filter can-animate']/input[@placeholder='Filter']").sendKeys("Incidents", Keys.ENTER);
		dom.findElementByXPath("//span[@class='item-icon']/span[text()='Incidents']").click();
		Thread.sleep(2000);
		WebElement frameEle=dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameEle);

		System.out.println("Incident no in delete :" +incNoGen);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incNoGen, Keys.ENTER);
		driver.findElement(By.xpath("(//table[@id='incident_table']/tbody/tr/td)[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		driver.findElement(By.xpath("//button[@id='ok_button' and text()='Delete']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incNoGen, Keys.ENTER);
		String deleteConfirmation =driver.findElement(By.xpath("//div[@class='list2_empty-state-list']")).getText();
		if(deleteConfirmation.contains(deleteInfo)) {
			System.out.println("Deleted successfully :" + deleteConfirmation);
		}
		else {
			System.out.println("Deleted unsuccessfully :" + deleteConfirmation);
		}
	
	}

}
