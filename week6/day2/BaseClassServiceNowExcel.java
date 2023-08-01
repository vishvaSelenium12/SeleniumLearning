package week6.day2;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment.WorkbookNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class BaseClassServiceNowExcel {
	
	public static ChromeDriver driver;
	public static String incNoGen ="";
	public String WorkbookName;
	public String SheetName;

	@BeforeMethod
	public void setUp() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//login page
		driver.get("https://dev91662.service-now.com");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Mouneesh@12");
		driver.findElement(By.id("sysverb_login")).click();
	

	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@DataProvider(indices={0})
	public String[][] sendServiceNowDatas() throws IOException {
			//if method is non static , create object for class to access any methods
			/*ReadExcelData readExcelData = new ReadExcelData();
			String[][] readData =readExcelData.runReadExcelData();
			return readData;*/
			return ReadExcelData.runReadExcelData(WorkbookName,SheetName);
		}
	
}
