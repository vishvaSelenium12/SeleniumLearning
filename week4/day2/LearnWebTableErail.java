package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWebTableErail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://erail.in/");
		WebElement fromStation =driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("MAS", Keys.ENTER);
		
		WebElement toStation =driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("CBE", Keys.ENTER);
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		Thread.sleep(3000);
		WebElement tableName =driver.findElement(By.xpath("//table[contains(@class,'DataTable TrainList')]"));
		List<WebElement> rowCount=tableName.findElements(By.xpath("//table[contains(@class,'DataTable TrainList')]/tbody/tr"));
		System.out.println("Total numbre of row is :" +rowCount.size());
		//Print all datas from first row
		WebElement firstRow =rowCount.get(1);
		List<WebElement> allDataOfFirstRow =firstRow.findElements(By.tagName("td"));
		List<String> li = new ArrayList<String>();
		for (int i = 0; i < allDataOfFirstRow.size(); i++) {
			String text =allDataOfFirstRow.get(i).getText();
			li.add(text);
		}
		System.out.println(li);
		
		//print all datas from second column
		List<WebElement> allTrianNames=driver.findElements(By.xpath("(//table[contains(@class,'DataTable TrainList')]/tbody/tr/th)[2]"));
		
		for (int i = 0; i < allTrianNames.size(); i++) {
			String trainName=allTrianNames.get(i).getText();
			System.out.println(trainName);
		}
		
		//Get all datas from table
		
		for(int i=0;i<rowCount.size();i++) {
			WebElement allRows =rowCount.get(i);
			List<WebElement> allRowData =allRows.findElements(By.tagName("td"));
			for(int j=0;j<allRowData.size();j++) {
				String datas =allRowData.get(i).getText();
				System.out.println(datas);
			}
			
		}
		
	}

}
