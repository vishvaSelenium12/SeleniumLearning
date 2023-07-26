package week4.day1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnSnapshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://buythevalue.in/");
		Thread.sleep(3000);
		//using index
		driver.switchTo().frame(1);
		driver.findElement(By.id("dummy-chat-button")).click();
		Thread.sleep(3000);
		//using id or attribute name
		driver.switchTo().frame("ShopifyChat");
		driver.findElement(By.xpath("//div[@class='composer-bar__box']/textarea")).sendKeys("Hai");
		driver.findElement(By.xpath("//button[contains(@class,'chat-app')]")).click();
		
		//to switch control from frame to main window
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("(//div[@class='grid-item product-item']/div/div/h3/a)[2]")).click();
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/buyvalue.jpg");
		FileUtils.copyFile(source, dest);
		
		
		

	}

}
