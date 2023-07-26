package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnSimpleAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/alert.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[text()='Show']")).click();
		Alert al =driver.switchTo().alert();
		String text =al.getText();
		System.out.println(text);
		al.accept();
		String confirmation =driver.findElement(By.xpath("//span[@id='simple_result']")).getText();
		if(confirmation.contains("Successfully")) {
			System.out.println("Alert Accepted");
		}
		
	}

}
