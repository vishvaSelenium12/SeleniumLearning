package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/window.xhtml");
		driver.findElement(By.xpath("//span[@class='ui-button-text ui-c' and text()='Open']")).click();
		String parentTitle =driver.getTitle();
		System.out.println("Parent Title :" + parentTitle);
		String parentWindow =driver.getWindowHandle();
		System.out.println("Parent window :"+parentWindow);
		
		Set<String> allWidnows =driver.getWindowHandles();
		System.out.println("Windows Count are :" + allWidnows.size());
		
		//convert set to list to switch to a particular window
		List<String> li = new ArrayList<String>(allWidnows);
		String childWindow =li.get(1);
		System.out.println("ChildWindow :" + childWindow);
		driver.switchTo().window(childWindow);
		String childTitle =driver.getTitle();
		System.out.println("Child Title :" + childTitle);
		driver.close(); // close only current window
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		
		// driver.quit();  it will close all windows
	}

}
