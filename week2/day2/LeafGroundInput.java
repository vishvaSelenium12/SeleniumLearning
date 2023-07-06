package week2.day2;

import java.awt.RenderingHints.Key;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouneesh\\eclipse-workspace\\SeleniumTrainingJune2023\\selenium2023\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//1. Load url "leaf ground input"
		driver.get("https://www.leafground.com/input.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Type your name
		driver.findElement(By.xpath("//input[@name='j_idt88:name']")).sendKeys("Vishvanathan");
		//Just Press Enter and confirm error message*
		driver.findElement(By.xpath("(//div[@class='card'])[2]/form/div/div/input")).sendKeys(Keys.ENTER);
		
		String errorMess=driver.findElement(By.xpath("//span[text()='Age is mandatory']")).getText();
		
		System.out.println("Error message:"+errorMess );
		
		//Append Country to this City.
		driver.findElement(By.xpath("(//div[@class='card'])[1]/form/div/following-sibling::div/div/input")).sendKeys("Coimbatore");
		
		//Verify if text box is disabled
		boolean textdisabled =driver.findElement(By.xpath("(//div[@class='card'])[1]/form/h5[text()='Verify if text box is disabled']/following-sibling::div/div/input")).isEnabled();
		System.out.println("Text box is disabled:"+ textdisabled);
		
		//Clear the typed text.
		driver.findElement(By.xpath("(//div[@class='card'])[1]/form/h5[text()='Clear the typed text.']/following-sibling::div/div/input")).clear();
		
		String retriveAttrValue=driver.findElement(By.xpath("(//div[@class='card'])[1]/form/h5[text()='Retrieve the typed text.']/following-sibling::div/div/input")).getAttribute("value");
		
		System.out.println("Retrive Value:"+ retriveAttrValue);
		
		//Type email and Tab. Confirm control moved to next element.
		WebElement typeEmail =driver.findElement(By.xpath("(//div[@class='card'])[1]/form/h5[text()='Type email and Tab. Confirm control moved to next element.']/following-sibling::div/div/input"));
		typeEmail.sendKeys("abc@gmail.com", Keys.TAB);
	
		driver.findElement(By.xpath("(//div[@class='card'])[1]/form/h5[text()='Type about yourself']/following-sibling::div/div/textarea")).sendKeys("Myself Vishva and working in TCS");
		
		//click and confirm label position
		int position =driver.findElement(By.xpath("((//div[@class='card'])[2]/span/input)[1]")).getLocation().getY();
		System.out.println("Field Position:"+ position);
		
		//Type your name and choose the third option
		WebElement elementType =driver.findElement(By.xpath("(//div[@class='card'])[2]/div/ul"));
		elementType.click();
		elementType.sendKeys("vishva");
		driver.findElement(By.xpath("//ul[@class='ui-autocomplete-items ui-autocomplete-list ui-widget-content ui-widget ui-corner-all ui-helper-reset']/li[3]")).click();
		
		
		
	}

}
