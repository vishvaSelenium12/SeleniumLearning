package week6.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testleaf.base.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MergeContactExcelData extends BaseClassDynamicParam {
	
	@Test
	public  void runMergeLead() throws InterruptedException {
		// TODO Auto-generated method stub

		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */
		//get title
		String titleName =driver.getTitle();
		System.out.println(titleName);
		
		//5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();

		// 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//7. Click on Widget of From Contact
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following::a/img")).click();
		
		Set<String> allwindows =driver.getWindowHandles();
		System.out.println("Window Count :" + allwindows.size());
		List<String> windowList = new ArrayList<String>(allwindows);
		String parentWindow= windowList.get(0);
		String childWindow= windowList.get(1);		
		driver.switchTo().window(childWindow);
		//8. Click on First Resulting Contact
		driver.findElement(By.xpath("((//table[@class='x-grid3-row-table']/tbody/tr)[7]/td/div/a)[1]")).click();
		driver.switchTo().window(parentWindow);
		//9. Click on Widget of To Contact
		driver.findElement(By.xpath("(//table[@id='widget_ComboBox_partyIdFrom']/following::a/img)[2]")).click();
		
		Set<String> allwindows1 =driver.getWindowHandles();
		System.out.println("Window Count :" + allwindows1.size());
		List<String> windowList1 = new ArrayList<String>(allwindows1);
		String parentWindow1= windowList1.get(0);
		String childWindow1= windowList1.get(1);	
		driver.switchTo().window(childWindow1);
		//10. Click on Second Resulting Contact
		driver.findElement(By.xpath("((//table[@class='x-grid3-row-table']/tbody/tr)[9]/td/div/a)[1]")).click();
		driver.switchTo().window(parentWindow1);
		//11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//* 12. Accept the Alert
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		String title =driver.getTitle();
		if(title.contains("View Contact"))
		{
			System.out.println("Page successfully verified :" + title);
		}
		else {
			System.out.println("Page successfully not verified :" + title);
		}
		
	}

}
