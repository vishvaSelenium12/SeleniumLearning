package marathon3;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesForceChromeContent extends BaseClassSalesForce {

	@BeforeTest
	public void setValues() {

		WorkBookName="SalesForceMarathon3";
		SheetName="SalesForceContent";
	}


	@Test(dataProvider="sendDataSalesForce")
	public void runSalesForceContentChrome(String quesData, String detailsData) throws InterruptedException {
		// TODO Auto-generated method stub

		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//p[text()='Content']")).click();

		//driver.findElement(By.xpath("(//*[@data-key='down']//*[local-name()='path'])[2]")).click();
		Thread.sleep(3000);
		WebElement chatEle=driver.findElement(By.xpath("//a[@title='Chatter']"));
		//Java script.
		driver.executeScript("arguments[0].click();", chatEle);
		
		String chatterTitle=driver.getTitle();
		if(chatterTitle.contains("Chatter Home")) {
			System.out.println("Page loaded correctly:" + chatterTitle);
		}
		else {
			System.out.println("Page loaded Incorrectly:" + chatterTitle);
		}
		driver.findElement(By.xpath("(//span[text()='Question'])")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//textarea[contains(@placeholder,'What would ')]")).sendKeys(quesData);
		driver.findElement(By.xpath("//div[contains(@data-placeholder,'If you have more to say, add details here...')]")).sendKeys(detailsData);

		driver.findElement(By.xpath("//button[text()='Ask']")).click();
		String queText =driver.findElement(By.xpath("//div[@class='cuf-feedItemHeader cuf-media l-first']/following-sibling::div[@class='cuf-body cuf-questionTitle forceChatterFeedBodyQuestionWithoutAnswer']/span[@class='uiOutputText']")).getText();
		System.out.println(queText);
		if(queText.contains(quesData)) {
			System.out.println("Question is Correct:" + queText);
		}
		else {
			System.out.println("Question is InCorrect:" + queText);
		}



	}

}
