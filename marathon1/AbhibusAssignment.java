package marathon1;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AbhibusAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//2)Load URL
		driver.get("https://www.abhibus.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//click on Bus
		driver.findElement(By.xpath("//li[@class='nav-item pr-1 px-md-2']//a[text()='Bus']")).click();
		
		//enter source name
		driver.findElement(By.xpath(" //input[@id='source']")).sendKeys("Chennai");
		Thread.sleep(3000);
		//select the from first option 
		driver.findElement(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content' and @id='ui-id-1']/li[text()='Chennai']")).click();
		
		//enter destination name
		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys("Bangalore");
		Thread.sleep(3000);
		//select the to first option 
		driver.findElement(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content' and @id='ui-id-2']/li[text()='Bangalore']")).click();
		
		//select the date picker
		driver.findElement(By.xpath("//input[@id='datepicker1']")).click();
		
		//select the date as tomorrow
		driver.findElement(By.xpath("(//table[@class='ui-datepicker-calendar']/tbody/tr/td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']/following-sibling::td)[1]")).click();
		
		//click on search button
		driver.findElement(By.linkText("Search")).click();
		
		Thread.sleep(5000);
		//get the first resulting bus name
		String firstBusName =driver.findElement(By.xpath("(//div[@id='SerVicesDetOneway']//div[@class='col2 column-middle']/div/h2)[1]")).getText();
		System.out.println("First Resulting Bus Name is :" + firstBusName) ;
		
		//choose sleeper in Bus type
		driver.findElement(By.xpath("//li[@id='bustypeSLEEPER']/p/following-sibling::input")).click();
		Thread.sleep(3000);
		//Print the first resulting bus seat count
		String busSeatAvailable=driver.findElement(By.xpath("(//div[@id='SerVicesDetOneway']//div[@class='col2 column-middle']/div/h2)[1]/parent::div/parent::div/div[@class='search-column2']/div/p[contains(@class,'noseats')]")).getText();
		System.out.println("Total Number of Seat available:" + busSeatAvailable);
		
		//click on select seat
		driver.findElement(By.xpath("(//a[@class='btn-seatselect book1'])[1]/span")).click();
		
		Thread.sleep(5000);
		//Click on avaialble seat
		driver.findElement(By.xpath("(//li[contains(@class,' sleeper available')])[2]/a")).click();
		
		//get the seat name
		String selecteSeatNo=driver.findElement(By.xpath("//div[@class='jurnydetails']/div/p[contains(text(),'Seats Selected')]/parent::div/p/span")).getText();
		System.out.println("Selected Seat Number :"+ selecteSeatNo);
		String getFare=driver.findElement(By.xpath("(//div[@class='jurnydetails']/div/p[contains(text(),'Total Fare')]/parent::div/p/span)[1]")).getText();
		System.out.println("Fare details :" + getFare);
		
		//selecting boarding point
		WebElement boardDrop=driver.findElement(By.xpath("//select[@name='boardingpoint_id']"));
		Select ss = new Select(boardDrop);
		/*List<WebElement> lisss= ss.getOptions();
		for(WebElement eachList: lisss) {
			eachList.get
		}*/
		ss.selectByIndex(4);
		
		//selecting dropping board
		WebElement dropPoint =driver.findElement(By.xpath("//select[@name='droppingpoint_id']"));
		Select ss1 = new Select(dropPoint);
		ss1.selectByIndex(15);
		
		String titlePage=driver.getTitle();
		System.out.println("Title of the page is:" + titlePage);
		
		driver.close();
	}

}
