package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//click on create new account
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		//enter firstname
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("vishvanathan");
		
		//enter sur name
		driver.findElement(By.xpath("//div[@class='uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput']/input[@name='lastname']")).sendKeys("veerabathiran");
		
		//enter phone number
		driver.findElement(By.xpath("(//input[contains(@name,'reg_email_')])[1]")).sendKeys("9524242092");
		
		//enter password
		driver.findElement(By.xpath("//input[contains(@name,'reg_passwd__')]")).sendKeys("vishva@123");
		
		//Handle Day dropdown
		WebElement dayElement =driver.findElement(By.name("birthday_day"));
		Select ss = new Select(dayElement);
		ss.selectByIndex(11);
		
		//Handle Monthdropdown
		WebElement monthElement =driver.findElement(By.name("birthday_month"));
		Select ss1 = new Select(monthElement);
		ss1.selectByValue("2");
		
		//Handle year dropdown
		WebElement yearElement=driver.findElement(By.name("birthday_year"));
		Select s2 = new Select(yearElement);
		s2.selectByVisibleText("1991");
		
		//select radio button female
		driver.findElement(By.xpath("(//input[@name='sex'])[1]")).click();
		driver.close();
		
	}

}
