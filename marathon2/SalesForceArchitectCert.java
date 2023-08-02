package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class SalesForceArchitectCert {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//1) Launch https://www.snapdeal.com/
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.name("Login")).click();
		Thread.sleep(5000);
		//Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("//span[contains(text(),'Mobile Publisher')]/preceding-sibling::span[text()='Learn More']")).click();
		Set<String> allWindows =driver.getWindowHandles();
		System.out.println("No of windows :" + allWindows.size());
		List<String> li = new ArrayList<String>(allWindows);
		String parentWindow =li.get(0);
		String childWindow =li.get(1);
		driver.switchTo().window(childWindow);
		Thread.sleep(3000);
		//Click confirm on Confirm redirect
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		//Click Learning 
		Thread.sleep(5000);
		Shadow dom = new Shadow(driver);
		dom.findElementByXPath("//span[text()='Learning']").click();
		
		WebElement eleTrailHead =dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions builder = new Actions(driver);
		builder.moveToElement(eleTrailHead).perform();
		WebElement saleEle =dom.findElementByXPath("//a[text()='Salesforce Certification']");
		Actions builder2 = new Actions(driver);
		builder2.scrollToElement(saleEle).perform();
		dom.findElementByXPath("//a[text()='Salesforce Certification']").click();
		Thread.sleep(3000);
		//Choose Your Role as Sales force Architect
		driver.findElement(By.xpath("(//div[contains(@class,'roleMenu-item_text')])[2]")).click();
		String salesForceArchitect =driver.findElement(By.xpath("//h1[text()='Salesforce Architect']/parent::div/div[@class='cert-site_text slds-text-align--center Lh(1.5) Fz(16px) slds-container--center slds-p-bottom--large']")).getText();
		System.out.println(salesForceArchitect);
		
		List<WebElement> listOfCert =driver.findElements(By.xpath("//div[@class='slds-container--center slds-container--x-large slds-p-top--small']//div[@class='credentials-card ']/div[text()='Certification']/following-sibling::div/a"));
		System.out.println("Number of Cert :" + listOfCert.size());
		for (WebElement eachCert : listOfCert) {
			String certName =eachCert.getText();
			System.out.println(certName);
		}
		
		driver.findElement(By.xpath("//div[@class='slds-container--center slds-container--x-large slds-p-top--small']//div[@class='credentials-card ']/div[text()='Certification']/following-sibling::div/a[text()='Application Architect']")).click();
		Thread.sleep(7000);
		List<WebElement> listOfCerts=driver.findElements(By.xpath("//div[@class='slds-container--center slds-container--x-large slds-p-top--small']//div[@class='credentials-card ']/div[text()='Certification']/following-sibling::div/a"));
		System.out.println("Number of Apllication Architect Certification :" + listOfCerts.size());
		for (WebElement eachCerts : listOfCerts) {
			System.out.println(eachCerts.getText());
		}
		
		WebElement certEle=driver.findElement(By.xpath("//div[@class='slds-p-around_large']//div[@class='credentials-card ']/div[text()='Certification']/following-sibling::div/a[text()='Integration Architect']"));
		Actions builder1 = new Actions(driver);
		builder1.scrollToElement(certEle).perform();
		File source =driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/certificateapplicationarchitect.png");
		FileUtils.copyFile(source, dest);
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.close();

	}

}
