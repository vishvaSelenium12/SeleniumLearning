package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnNestedFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
	
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://leafground.com/frame.xhtml");
		//using index
		driver.switchTo().frame(2);
		//switch frame using webelement
		
		WebElement iframe=driver.findElement(By.xpath("//h5[contains(text(),' Click Me (Inside Nested frame)')]/following::iframe"));
		//driver.switchTo().frame("frame2");
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//button[@id='Click']")).click();
		//switch to immediate parent frame
		driver.switchTo().parentFrame();
		
	}

}
