package week6.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class ServiceNowUpdateExsIncidentExcel extends BaseClassServiceNowExcel {
	
	@BeforeTest
	public void setValues(){

		WorkbookName="ServiceNowFullData";
		SheetName="UpdateIncident";

	}
	@Test(priority=2, dataProvider="sendServiceNowDatas")
	public void runServiceNowUpdateExsIncident(String incUrg, String incState) throws InterruptedException {
		Thread.sleep(5000);

		//Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(10);
		dom.findElementByXPath("//div[contains(text(),'All')]").click();
		dom.findElementByXPath("//span[@class='item-icon']/span[text()='Incidents']").click();
		Thread.sleep(2000);
		WebElement frameEle=dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameEle);

		System.out.println("Incident no in Update :" +incNoGen);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incNoGen, Keys.ENTER);
		driver.findElement(By.xpath("(//table[@id='incident_table']/tbody/tr/td)[3]/a")).click();
		Thread.sleep(2000);
		WebElement urgencyEle =driver.findElement(By.id("incident.urgency"));
		Select ss = new Select(urgencyEle);
		ss.selectByVisibleText(incUrg);

		WebElement stateEle =driver.findElement(By.name("incident.state"));
		Select ss1 = new Select(stateEle);
		ss1.selectByVisibleText(incState);

		driver.findElement(By.xpath("(//button[text()='Update'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incNoGen, Keys.ENTER);
		driver.findElement(By.xpath("(//table[@id='incident_table']/tbody/tr/td)[3]/a")).click();
		Thread.sleep(2000);

		WebElement stateEleVer =driver.findElement(By.id("incident.state"));
		Select ss2 = new Select(stateEleVer);
		String statusOFInc=ss2.getFirstSelectedOption().getText();
		if(statusOFInc.equals("In Progress")) {
			System.out.println("Incident Status is verified successfully:" + statusOFInc);
		}
		else {
			System.out.println("Incident Status is not verified successfully:" + statusOFInc);
		}

	}


}
