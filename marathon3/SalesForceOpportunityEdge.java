package marathon3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesForceOpportunityEdge extends BaseClassSalesForce {
	
	@BeforeTest
	public void setValues() {
		
		WorkBookName="SalesForceMarathon3";
		SheetName="SalesForceOpportunity";
	}

	@Test(dataProvider="sendDataSalesForce")
	public void runSalesForceOpportunityEdge(String oppName, String amount) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement viewEle =driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
		wait.until(ExpectedConditions.visibilityOf(viewEle));
		Actions builder = new Actions(driver);
		builder.scrollToElement(viewEle).perform();
		//Java script.
		driver.executeScript("arguments[0].click();", viewEle);
		//driver.findElement(By.xpath("//span[text()='View All Key Deals']")).click();
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(oppName);
		
		WebElement typeEle=driver.findElement(By.xpath("(//span[text()='--None--'])[2]"));
		driver.executeScript("arguments[0].click();", typeEle);
		WebElement typeNew=driver.findElement(By.xpath("//span[text()='New Customer']"));
		driver.executeScript("arguments[0].click();", typeNew);
		
		WebElement leadEle=driver.findElement(By.xpath("//label[text()='Lead Source']/parent::lightning-combobox//button"));
		driver.executeScript("arguments[0].click();", leadEle);
		
		WebElement partEle=driver.findElement(By.xpath("//span[text()='Partner Referral']"));
		driver.executeScript("arguments[0].click();", partEle);
		
		driver.findElement(By.xpath("//label[text()='Amount']/parent::div//div/input")).sendKeys(amount);
		
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//table[@class='slds-datepicker__month']/tbody/tr/td[@class='slds-is-today']/following-sibling::td/span")).click();
	
		WebElement stageEle=driver.findElement(By.xpath("//label[text()='Stage']/parent::lightning-combobox//button"));
		driver.executeScript("arguments[0].click();", stageEle);
		WebElement needEle =driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']//span[text()='Needs Analysis']"));
		driver.executeScript("arguments[0].click();", needEle);
		
		WebElement comEle=driver.findElement(By.xpath("(//input[@role='combobox'])[2]"));
		driver.executeScript("arguments[0].click();", comEle);
		
		WebElement bootEle=driver.findElement(By.xpath("//span[text()='Bootcamp']"));
		driver.executeScript("arguments[0].click();", bootEle);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		String oppNames=driver.findElement(By.xpath("//div[text()='Opportunity']/parent::h1//lightning-formatted-text")).getText();
		System.out.println(oppNames);
		if(oppName.contains("Vishvanathan")) {
			System.out.println("Opportunity is Created Successfully :" + oppNames);
		}
		else {
			System.out.println("Opportunity is Created UnSuccessfully :" + oppNames);
		}
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
