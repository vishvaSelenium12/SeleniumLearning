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

public class ServiceNowNewIncidentExcel extends BaseClassServiceNowExcel {
	
	@BeforeTest
	public void setValues(){
		
		WorkbookName="ServiceNowFullData";
		SheetName="NewIncident";

	}

	@Test(priority=1, dataProvider="sendServiceNowDatas")
	public void runServiceNowNewIncident(String shortDesc) throws InterruptedException {
		// TODO Auto-generated method stub

		Thread.sleep(3000);
		//Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(30);
		dom.findElementByXPath("//div[contains(text(),'All')]").click();
		//Thread.sleep(1000);
		dom.findElementByXPath("//span[@class='item-icon']/span[text()='Incidents']").click();
		Thread.sleep(2000);
		
		WebElement frameEle=dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameEle);

		driver.findElement(By.xpath("//button[@class='selected_action action_context btn btn-primary']")).click();
		
		//enter incident number
		/*WebElement incNumele=driver.findElement(By.xpath("//input[@id='incident.number']"));
		incNumele.clear();
		incNumele.sendKeys("INC0010002");*/
		
		incNoGen =driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		//driver.findElement(By.xpath("(//span[@class='icon-calendar icon'])[2]")).click();
		
		//driver.findElement(By.xpath("//table[@class='calTable']/tbody/tr/td[@class='calText calCurrentDate']")).click();
		
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys(shortDesc);
		driver.findElement(By.xpath("//button[@class='form_action_button  action_context btn btn-default']")).click();
		
		//String incNo =driver.findElement(By.xpath("(//table[@id='incident_table']/tbody/tr/td)[3]/a")).getText();
		System.out.println("New Incident Number:" + incNoGen);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incNoGen, Keys.ENTER);
		
		String incDesc=driver.findElement(By.xpath("((//table[@id='incident_table']/tbody/tr/td)[3]/a/parent::td/following-sibling::td)[2]")).getText();
		System.out.println("Incident Description :" +incDesc);
		
	}

}
