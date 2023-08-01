package week6.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClassDynamicParam {

	public RemoteWebDriver driver;
	public String WorkbookName;
	public String SheetName;
	
	@Parameters({"browser","url","userName","passWord"})
	@BeforeMethod
	public void setUp(String browser, String url, String uName, String pWord) {
		
		if(browser.equalsIgnoreCase("ChromeBrowser")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("EdgeBrowser")) {
			System.setProperty("webdriver.edge.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				//Entering username
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uName);
		
		//driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//entering password
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys(pWord);
		//driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		
		// click on login button 
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		//driver.findElement(By.className("decorativeSubmit")).click();
		
		//click on crmsfa
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		//driver.findElement(By.partialLinkText("CRM")).click();

	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}
	
	@DataProvider(indices={0,1})
	public String[][] sendDatas() throws IOException {
			//if method is non static , create object for class to access any methods
			/*ReadExcelData readExcelData = new ReadExcelData();
			String[][] readData =readExcelData.runReadExcelData();
			return readData;*/
			return ReadExcelData.runReadExcelData(WorkbookName,SheetName);
		}
	
}

