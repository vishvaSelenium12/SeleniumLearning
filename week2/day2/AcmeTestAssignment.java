package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AcmeTestAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//1. Load url "https://acme-test.uipath.com/login"
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2. Enter email as "kumar.testleaf@gmail.com"
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("kumar.testleaf@gmail.com");
		
		//3. Enter Password as "leaf@12"
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		
		//4. Click login button
		
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		//5. Get the title of the page and print
		String title=driver.getTitle();
		System.out.println("Acme Dashboard login page:" + title);
		//6. Click on Log Out
		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
		
		//7. Close the browser (use -driver.close())
		driver.close();
		
	}

}
