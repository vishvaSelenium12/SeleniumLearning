package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListFindLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://en-gb.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> links =driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		
		//Declare list
		List<String> li = new ArrayList<String>();
		
		
		for(WebElement eachLinks : links) {
			String linkName=eachLinks.getText();
			System.out.println(linkName);
			li.add(linkName);
		}
		System.out.println(li);
		Collections.sort(li);
		System.out.println(li);
		
		

	}

}
