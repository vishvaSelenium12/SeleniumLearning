package marathon3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import week6.day2.ReadExcelData;

public class BaseClassSalesForce {
	
	public RemoteWebDriver driver ;
	public WebDriverWait wait;
	
	public String WorkBookName;
	public String SheetName;
	
	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void setUp(String browser, String url, String uName, String pWord) {
		
		if(browser.contains("Chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(options);
		}
		
		else if(browser.contains("Edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.edge.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver(options);
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pWord);
		driver.findElement(By.name("Login")).click();
	
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		
	}
	
	@DataProvider
	public String[][] sendDataSalesForce() throws IOException {
		
		return ReadExcelData.runReadExcelData(WorkBookName, SheetName);
	}
}
