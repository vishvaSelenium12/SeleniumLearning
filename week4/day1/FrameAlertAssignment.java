package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FrameAlertAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://buythevalue.in/");
		
		//Chat box open
		driver.switchTo().frame("dummy-chat-button-iframe");
		driver.findElement(By.xpath("//button[@id='dummy-chat-button']")).click();
		//chat box close
		
		driver.switchTo().frame("ShopifyChat");
		driver.findElement(By.xpath("//button[contains(@class,'chat-app')]")).click();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[@class='product-title']")).click();
		
		driver.findElement(By.name("wk_zipcode")).sendKeys("641653");
		driver.findElement(By.xpath("//input[@class='btn']")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]")).click();
		
		driver.findElement(By.xpath("(//span[contains(text(),'View Cart')])")).click();
		driver.findElement(By.xpath("(//input[contains(@id,'checkout')])")).click();
		
		Alert alt =driver.switchTo().alert();
		alt.accept();
		
	}

}
