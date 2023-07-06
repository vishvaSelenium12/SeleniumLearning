package marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PVRCinemas {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//2)Load URL
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//click on movie library
		driver.findElement(By.xpath("//div[contains(text(),'Movie Library ')]")).click();

		Thread.sleep(3000);
		//Select city
		WebElement city=driver.findElement(By.name("city"));
		Select ss= new Select(city);
		ss.selectByVisibleText("Chennai");
		
		//Select genre
		WebElement genre=driver.findElement(By.name("genre"));
		Select ss1= new Select(genre);
		ss1.selectByVisibleText("ANIMATION");

		//Select lang
		WebElement lang=driver.findElement(By.name("lang"));
		Select ss2= new Select(lang);
		ss2.selectByVisibleText("ENGLISH");
		//apply button
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		Thread.sleep(3000);
		// Click on first resulting animation movie
		driver.findElement(By.xpath("(//div[@class='movie-list']/div/div)[1]")).click();
		Thread.sleep(3000);
		
		//proceed to book
		driver.findElement(By.xpath("//button[text()='Proceed To Book']")).click();
		
		//cinema name
		WebElement cineName=driver.findElement(By.name("cinemaName"));
		Select ss3 = new Select (cineName);
		ss3.selectByVisibleText("SPI Sathyam Chennai");
		
		driver.findElement(By.xpath("//div[@class='datepicker-container datepicker-default']/input")).click();
		Thread.sleep(2000);
		//select date
		driver.findElement(By.xpath("//div[@class='main-calendar-days']/span[text()='14']")).click();  
		
		//timeshow
		WebElement timing=driver.findElement(By.name("timings"));
		Select ss4 = new Select (timing);
		ss4.selectByVisibleText("03:00 PM - 06:00 PM");
		
		//number of seats
		driver.findElement(By.name("noOfTickets")).sendKeys("4");
		
		//name
		driver.findElement(By.name("name")).sendKeys("Vishvanathan");
		
		//email
		driver.findElement(By.name("email")).sendKeys("abcvishva@gmail.com");
		
		//monile
		driver.findElement(By.name("mobile")).sendKeys("9524242092");
		
		//F&B Req
		WebElement food =driver.findElement(By.xpath("//select[@name='food']"));
		Select ss5 = new Select(food);
		ss5.selectByVisibleText("Yes");
		
		//other req
		driver.findElement(By.xpath("//input[@name='comment']")).sendKeys("Nothing");
		
		//click on copy itself
		driver.findElement(By.xpath("//label[@class='custom-control custom-radio']")).click();
		
		//click ons end req
		driver.findElement(By.xpath("//button[text()='SEND REQUEST']")).click();
		
		//click on cancel button
		driver.findElement(By.xpath("(//button[text()='CANCEL'])[2]")).click();
		
		//click on close otp dialog
		driver.findElement(By.xpath("//button[text()='×']")).click();
		
		String title =driver.getTitle();
		System.out.println("Page title name is :" + title);
		driver.close();
	}
}
