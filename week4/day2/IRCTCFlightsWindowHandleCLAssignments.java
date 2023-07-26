package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTCFlightsWindowHandleCLAssignments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/");
		driver.findElement(By.xpath("//a[contains(text(),' FLIGHTS ')]")).click();
		System.out.println("Parent Window title is :" +driver.getTitle());
		Set<String> allWindows =driver.getWindowHandles();
		List<String> li = new ArrayList<String>(allWindows);
		System.out.println("Windows count:" +li.size());
		driver.switchTo().window(li.get(1));
		System.out.println("Second Window title is :" +driver.getTitle());
		driver.close();
	}

}
