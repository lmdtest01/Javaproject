package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class users {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    @BeforeTest
    void login() throws InterruptedException {
        driver.get("https://qa.wellbux.com/login");
        driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-login/div/div/div/div/div[2]/div/form/div/div[1]/input")).sendKeys("wellbux@mailinator.com");
        driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-login/div/div/div/div/div[2]/div/form/div/div[2]/input")).sendKeys("1234567");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-login/div/div/div/div/div[2]/div/form/div/div[4]/button")).click();
    }

    @Test
    void userlist() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"teleporter\"]/li[1]")).click();
        Thread.sleep(2000);
        
      
        
        ((JavascriptExecutor) driver)
        .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
       
        int Paginationsize = driver.findElements(By.xpath("//pagination/ul/li")).size();
        List <String> names = new ArrayList<String>();
       
        for (int i=2;i <Paginationsize;i++ ) {
        	String paginationselector ="//pagination/ul/li["+i+"]";
        	driver.findElement(By.xpath(paginationselector)).click();
        	Thread.sleep(3000);
        	List<WebElement>namesElements = driver.findElements(By.xpath("//div[@class='hd-limit']"));
        	for (WebElement namesElement : namesElements ) {
        		names.add(namesElement.getText());
        		Thread.sleep(2000);
        	}
        	
        }
        for(String name : names) {
        	System.out.println(name);
        	
        }
        int totalNames= names.size();
        System.out.println("Total number of names:" + totalNames);
       
        String displayedNames = driver.findElement(By.xpath("//a[@class='active' and @ng-reflect-ng-class='[object Object]']")).getText();

   
     displayedNames = displayedNames.substring(displayedNames.indexOf("(") + 1, displayedNames.indexOf(")"));

    
     System.out.println("Total number of displayed names: " + displayedNames);
     Assert.assertEquals(displayedNames, String.valueOf(totalNames));
     Thread.sleep(3000);
    }
    
   
   // @Test
  //  void addNew() {
    	
    //	driver.findElement(By.xpath("//a[@id='addnew' and  @ng-reflect-klass ='btn_outline']")).click();
    	
    	
    	
    	
    	
    	
    	
    	
  //  }
    
    
}
