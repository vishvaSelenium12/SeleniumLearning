package marathon1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//2)Load URL
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Type "Bags" in the Search box
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags");
		
		//select bags for boys
		driver.findElement(By.xpath("//div[@class='left-pane-results-container']/div/div[@class='s-suggestion-container']/div[contains(text(),'bags')]/span[contains(text(),'for boys')]")).click();
		
		//total number of results
		List<WebElement> totalResults=driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
		
		System.out.println("Total number of results:" + totalResults.size());
		
		//Selecting brand
		driver.findElement(By.xpath("(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']/label/input[@type='checkbox']/following-sibling::i)[3]")).click();
		
		driver.findElement(By.xpath("(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']/label/input[@type='checkbox']/following-sibling::i)[4]")).click();
		
		//click on sort
		driver.findElement(By.xpath("//span[@class='a-button-inner']/span[@class='a-button-text a-declarative']")).click();
		
		//click on newest arrival
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		String productName=driver.findElement(By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']/span)[1]")).getText();
		System.out.println("FirstResultingProductName:" + productName);
		
		String productPrice=driver.findElement(By.xpath("(//a[@class='a-size-base a-link-normal s-no-hover s-underline-text s-underline-link-text s-link-style a-text-normal']/span/span)[2]/span[2]")).getText();
		System.out.println("First resulting Product Discounted Price:" + productPrice);
		
		String titlePage =driver.getTitle();
		System.out.println("Name of the TitlePage is:" + titlePage);
		
		driver.close();
	}

	
}
