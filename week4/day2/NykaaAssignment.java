package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class NykaaAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		
		//2) Mouseover on Brands and Search L'Oreal Paris
		WebElement brandEle=driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brandEle).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("//a[contains(text(),'Oreal Paris')]")).click();
		String orealTitle=driver.getTitle();
		if(orealTitle.contains("L'Oreal Paris")) {
			System.out.println("Page verified successfully :" + orealTitle);
		}
		else {
			System.out.println("Page not verified successfully :" + orealTitle);
			
		}
		//Click sort By
		driver.findElement(By.xpath("(//*[@class='arrow-icon'])[1]")).click();
		//select customer top rated
		driver.findElement(By.xpath("//label[@class='control control-radio']/div/span[text()='customer top rated']/parent::div/following-sibling::div")).click();
		//Click Category
		driver.findElement(By.xpath("(//*[@class='arrow-icon'])[3]")).click();
		//click on Hair 
		driver.findElement(By.xpath("//div[@class=' css-1nozswx']/span[contains(text(),'Hair')]/parent::div/span[@class='side-count']/*[name()='svg']")).click();
		//click on Hair care 
		driver.findElement(By.xpath("//div[@class=' css-1nozswx']/span[contains(text(),'Hair Care')]/parent::div/span[@class='side-count']/*[name()='svg']")).click();
		//click on shampoo care
		driver.findElement(By.xpath("//div[@class='control-value']/span[contains(text(),'Shampoo')]/parent::div/following-sibling::div")).click();
		//Click->Concern->
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='filter-open css-1gdff5r']/span[text()='Concern']/following::div/div/*[name()='svg']")).click();
		//color protection
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='control-value']/span[contains(text(),'Color Protection')]/parent::div/following-sibling::div")).click();
		//filter applied with shampoo
		String filterApplied =driver.findElement(By.xpath("//div[@id='filters-listing']//span[@class='filter-value']")).getText();
		if(filterApplied.contains("Shampoo")) {
			System.out.println("Filter Applied Correctly :" + filterApplied);
		}
		else {
			System.out.println("Filter Applied Incorrectly :" + filterApplied);
		}
		// Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[contains(text(),'Oreal Paris Colour Protect Shampoo With UVA & UVB For Colo...')]")).click();
		Thread.sleep(3000);
		Set<String> allWindows =driver.getWindowHandles();
		System.out.println("Window count :" + allWindows.size());
		List<String> li = new ArrayList<String>(allWindows);
		String parentWindowID =li.get(0);
		String childWindowID =li.get(1);
		driver.switchTo().window(childWindowID);
		//select 650ml
		driver.findElement(By.xpath("//span[text()='650ml']")).click();
		//get price
		String stringPrice =driver.findElement(By.xpath("(//h1[contains(text(),'Oreal Paris Colour Protect Shampoo')]/following::div[@class='css-f5j3vf']/div/span)[2]")).getText();
		String price =stringPrice.replaceAll("[^0-9]", "");
		int finalPrice =Integer.parseInt(price);
		System.out.println("Final Price is:" + finalPrice);
		//click on add to bag
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='css-aesrxy']/*[name()='svg']")).click();
		driver.switchTo().frame(0);
		String stringGrandPrice =driver.findElement(By.xpath("//span[text()='Grand Total']/parent::div/preceding-sibling::div/span")).getText();
		String grandPrice =stringGrandPrice.replaceAll("[^0-9]", "");
		int finalGrandPrice =Integer.parseInt(grandPrice);
		System.out.println("Grand Final Price is:" + finalGrandPrice);
		//click on proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		
		String priceDetails =driver.findElement(By.xpath("//p[text()='Price Details']/parent::div/following-sibling::p")).getText();
		String priceDetails1 =priceDetails.replaceAll("[^0-9]", "");
		int finalPriceDetails =Integer.parseInt(priceDetails1);
		System.out.println("Final Price details in address page :" + finalPriceDetails);
		if(finalPriceDetails == finalGrandPrice ) {
			System.out.println("Price Matching : "+ finalPriceDetails);
		}
		driver.quit();
}}
