package test;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class tracker {
	WebDriver  driver;

@Test
	 void createtracker() throws Exception {
	MyScreenRecorder.startRecording("createtracker");
		
	WebDriver    driver  = new ChromeDriver();
		
		driver.get("https://qa.wellbux.com/login");
		
		
		driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-login/div/div/div/div/div[2]/div/form/div/div[1]/input")).sendKeys("wellbux@mailinator.com");;
		driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-login/div/div/div/div/div[2]/div/form/div/div[2]/input")).sendKeys("1234567");;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-login/div/div/div/div/div[2]/div/form/div/div[4]/button")).click();
		driver.manage().window().maximize();
	
		
		
	Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"teleporter\"]/li[12]/a")).click();
		Thread.sleep(3000);
	     driver.findElement(By.xpath("//a[@id='addnew']")).click();
	     
	      driver.findElement(By.xpath("//*[@id=\"shownew\"]/div/app-tracker-add-edit-form/form/div/div[1]/div/div/input")).sendKeys("Run the race");

	    Thread.sleep(2000) ;
	      WebElement dropdown =driver.findElement(By.xpath("//span[@ng-reflect-ng-item-label=' Select Locale']")); 
         dropdown.click();
          WebElement locale = driver.findElement(By.xpath("//span[@ng-reflect-ng-item-label=' Global Outreach Church ']"));
          locale.click();
          
          Thread.sleep(2000) ;
          driver.findElement(By.xpath("//*[@id=\"shownew\"]/div/app-tracker-add-edit-form/form/div/div[3]/div/div/ng-select/div")).click();
          WebElement selecttype =driver.findElement(By.xpath("//span[@ng-reflect-ng-item-label=' Activity ']")); 
          selecttype .click();
          Thread.sleep(2000);
          
          driver.findElement(By.xpath("//*[@id=\"shownew\"]/div/app-tracker-add-edit-form/form/div/div[5]/div/div/ng-select/div")).click();
          WebElement  trackertag = driver.findElement(By.xpath("//span[@ng-reflect-ng-item-label='Challenge']"));
          trackertag.click();
           
          Thread.sleep(2000);
          driver.findElement(By.xpath("//*[@id=\"shownew\"]/div/app-tracker-add-edit-form/form/div/div[6]/div/div/ng-select/div")).click();
          WebElement tepmlete = driver.findElement(By.xpath("//span[@ng-reflect-ng-item-label=' Boolean ']"));
          tepmlete.click();
          
          Thread.sleep(2000);
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollBy(0,600)");
          Thread.sleep(4000);
          
          
          
          driver.findElement(By.xpath("//*[@id=\"shownew\"]/div/app-tracker-add-edit-form/form/div/div[8]/div/div/ng-select/div")).click();
         WebElement unit = driver.findElement(By.xpath("//span[@ng-reflect-ng-item-label=' Work done ']"));
          
          unit.click();
          
          driver.findElement(By.xpath("//*[@id=\"shownew\"]/div/app-tracker-add-edit-form/form/div/div[9]/div/div/a")).click();
          
          Thread.sleep(2000);
          
          //chart attribute
          driver.findElement(By.xpath("//*[@id=\"shownew\"]/div/app-tracker-add-edit-form/form/div/div[9]/div/div/div/app-tracker-chart-attribute-form/div/div/div/div[1]/ng-select/div")).click();
          WebElement chart = driver.findElement(By.xpath("//span[@ng-reflect-ng-item-label=' Basic Area ']"));
          chart.click();
          
          Thread.sleep(2000);
          
          driver.findElement(By.xpath("//*[@id=\"shownew\"]/div/app-tracker-add-edit-form/form/div/div[9]/div/div/div/app-tracker-chart-attribute-form/div/div/div[1]/div[2]/input")).click();
        
          WebElement backgroundcolour = driver.findElement(By.xpath("//*[@id=\"shownew\"]/div/app-tracker-add-edit-form/form/div/div[9]/div/div/div/app-tracker-chart-attribute-form/div/div/div[1]/div[2]/color-picker/div/div[2]"));
          backgroundcolour.click();
          
          Thread.sleep(2000);
          
          driver.findElement(By.xpath("//*[@id=\"shownew\"]/div/app-tracker-add-edit-form/form/div/div[9]/div/div/div/app-tracker-chart-attribute-form/div/div/div[1]/div[3]/input")).click();
          
          WebElement bordercolour = driver.findElement(By.xpath("//*[@id=\"shownew\"]/div/app-tracker-add-edit-form/form/div/div[9]/div/div/div/app-tracker-chart-attribute-form/div/div/div[1]/div[3]/color-picker/div/div[2]"));
          bordercolour.click();
          
          
          Thread.sleep(2000);
          WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"shownew\"]/div/app-tracker-add-edit-form/form/div/div[9]/div/div/div[1]/app-tracker-chart-attribute-form/div/div/div[1]/div[5]/a[1]"));
          JavascriptExecutor jss = (JavascriptExecutor) driver;
          js.executeScript("arguments[0].click();", saveButton);  
          
          driver.findElement(By.xpath("//*[@id=\"shownew\"]/div/app-tracker-add-edit-form/form/div/div[11]/div/div/textarea")).sendKeys("Na");
          driver.findElement(By.xpath("//*[@id=\"shownew\"]/div/app-tracker-add-edit-form/form/div/div[12]/div/div/textarea")).sendKeys("Na");
          Thread.sleep(2000);
          driver.findElement(By.xpath("//*[@id=\"shownew\"]/div/app-tracker-add-edit-form/form/div/div[13]/div/div/ng-select/div")).click();
          WebElement interval = driver.findElement(By.xpath("//span[@ng-reflect-ng-item-label=' Day ']"));
          interval.click();
          
          Thread.sleep(2000);
          
          driver.findElement(By.xpath("//*[@id=\"shownew\"]/div/app-tracker-add-edit-form/form/div/div[15]/div/div/ng-select/div")).click();
          WebElement userright= driver.findElement(By.xpath("//span[@ng-reflect-ng-item-label=' User ']"));
          userright.click();
          
          driver.findElement(By.xpath("//label[@for='goalYesa']")).click();
          
          driver.findElement(By.xpath("//*[@id=\"shownew\"]/div/app-tracker-add-edit-form/form/div/div[18]/div/div/div/div[1]/input")).sendKeys("C:\\Users\\LMD-Java\\Downloads\\run.jpg");
       
          Thread.sleep(2000);
          driver.findElement(By.xpath(" //button[@id='save']")).click();
          
          MyScreenRecorder.stopRecording();
		}
 		  
 	  }

	
	
	
	
	
	


