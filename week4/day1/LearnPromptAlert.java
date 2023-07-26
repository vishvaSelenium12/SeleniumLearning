package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnPromptAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/alert.xhtml");
		driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
		Alert alt =driver.switchTo().alert();
		String text = alt.getText();
		System.out.println(text);
		alt.sendKeys("Vishvanathan");
		alt.accept();
		String confirmName=driver.findElement(By.id("confirm_result")).getText();
		if(confirmName.contains("Vishva")){
			System.out.println("Entered Name is Correct :"+ confirmName);
		}
		
		driver.close();
	}
	

}
