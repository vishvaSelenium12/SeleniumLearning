package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SnapdealAssignment {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//1) Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		
		
		//Go to Mens Fashion
		WebElement eleMensFashion =driver.findElement(By.xpath("//span[contains(text(), 'Fashion')]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(eleMensFashion).perform();
		
		//Go to Sports Shoes
		driver.findElement(By.xpath("//span[contains(text(), 'Sports Shoes')]")).click();
		
		//Get the count of the sports shoes
		List<WebElement> listOFShoes =driver.findElements(By.xpath("//a[@class='dp-widget-link noUdLine hashAdded']/p"));
		System.out.println("Total No of shoes :" + listOFShoes.size());
		for (WebElement eachShoes : listOFShoes) {
			System.out.println(eachShoes.getText());
		}
		
		//Click Training shoes
		
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		//Sort by Low to High
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[@class='search-li']")).click();
		String sortSelected =driver.findElement(By.xpath("//div[@class='sort-selected']")).getText();
		if(sortSelected.contains("Price Low To High")) {
			System.out.println("Sort Applied Correctly :" +sortSelected);
		}
		else {
			System.out.println("Sort Applied InCorrectly :" +sortSelected);
		}
		
		WebElement firstProductEle=driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(firstProductEle).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		String disPrice =driver.findElement(By.xpath("//div[@class='product-desc-price pdp-e-i-PAY-r ']/span")).getText();
		String disPrices =disPrice.replaceAll("[^0-9]", "");
		int discountPrices =Integer.parseInt(disPrices);
		System.out.println("Discount Price is :" + discountPrices);
		
		String discountedPrices =driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span[@class='payBlkBig']")).getText();
		String discountedPrices1 =discountedPrices.replaceAll("[^0-9]", "");
		int finalDiscountPrices =Integer.parseInt(discountedPrices1);
		System.out.println("Final Discount Price is :" + finalDiscountPrices);
		
		String disPer=driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span[@class='percent-desc ']")).getText();
		System.out.println("Discount Percentage:" + disPer);
		
		File source =driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("/.snaps/shoes.png");
		FileUtils.copyFile(source, dest);
		
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		driver.close();
		
		
	}

}
