package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNowAssignment {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//login page
		driver.get("https://dev31913.service-now.com/");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("q+NozS5Qe8!E");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(5000);
		//Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(30);
		dom.findElementByXPath("//div[contains(text(),'All')]").click();
		Thread.sleep(1000);
		//WebElement filter =dom.findElementByXPath("//div[@class='sn-polaris-nav-header-filter can-animate']/input[@id='filter']");
		//filter.click();
		//filter.sendKeys("Service catalog", Keys.ENTER);
		dom.findElementByXPath("//span[text()='Service Catalog']").click();
		
		Thread.sleep(5000);
		//Click on  mobiles
		WebElement frameEle=dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameEle);
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a/strong[text()='iPhone 6s']")).click();
		Thread.sleep(3000);
		//select color
		WebElement selectColor =driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select ss = new Select(selectColor);
		ss.selectByVisibleText("Gold");
		
		//select RAM size
		WebElement selectRamSize =driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]"));
		Select ss1 = new Select(selectRamSize);
		ss1.selectByVisibleText("128");
		
		//order now
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
				
		Thread.sleep(3000);
		String orderSuccess=driver.findElement(By.xpath("//div[@class='notification notification-success']/span")).getText();
		System.out.println("order Status :" + orderSuccess);
		
		String reqNo=driver.findElement(By.xpath("//a[@class='linked requestItemUrl']/b")).getText();
		System.out.println("Request Number :" + reqNo);
		File source =driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/orderpage.png");
		FileUtils.copyFile(source, dest);
		driver.quit();
	}
	

}
