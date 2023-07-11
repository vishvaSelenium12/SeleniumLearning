package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListAmazonMobilesCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.click();
		searchBox.sendKeys("mobiles",Keys.ENTER);	
		List<WebElement> listOfMobiles=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		System.out.println("List of Mobile is:" + listOfMobiles.size());
		
		List<Integer> li = new ArrayList<Integer>();
		for(WebElement eachMb:listOfMobiles) {
			String eachPrice =eachMb.getText();
			String intPrice =eachPrice.replaceAll(",", "");
			if(!intPrice.isEmpty()) {
			int finalPrice =Integer.parseInt(intPrice);
			li.add(finalPrice);
		}}
		System.out.println("All mobile price details:" + li);
		
		//Sorting element in list 
		Collections.sort(li);
		System.out.println("Least price is:" + li.get(0));
		
		//to get unique price - Adding in set 
		Set<Integer> uniquePrice = new TreeSet<Integer>(li);
		System.out.println(uniquePrice);
		if(li.size()==uniquePrice.size()) {
			System.out.println("Price size is equal");
		}
		else {
			System.out.println("Price size is not equal");
		}
		
		driver.close();
	}

}
