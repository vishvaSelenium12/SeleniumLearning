package week4.day2;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandlesPageClose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/window.xhtml");
		driver.findElement(By.xpath("//span[@class='ui-button-text ui-c' and text()='Close Windows']")).click();
		System.out.println("Parent Window Title :" +driver.getTitle());
		String parentWindowId =driver.getWindowHandle();
		System.out.println("Parent Window Id :" + parentWindowId);
		Set<String> allWindows =driver.getWindowHandles();
		
		for(String eachWindows:allWindows) {
			if(!parentWindowId.equals(eachWindows)) {
				System.out.println("Closing window Id :" + eachWindows);
				driver.switchTo().window(eachWindows).close();
			}
		}
		
		driver.quit();
	}

}
