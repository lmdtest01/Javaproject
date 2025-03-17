package test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;  




public class merchantsignup {

	@Test
	public  void signupmerchant() throws Exception {
		// TODO Auto-generated method stub
		MyScreenRecorder.startRecording("signupmerchan");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa.wellbux.com/signup");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-sign-up/div/div/div/div[1]/div[2]/div/form/div/div[1]/div[1]/div/input")).sendKeys("Royal");
		driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-sign-up/div/div/div/div[1]/div[2]/div/form/div/div[1]/div[2]/div/input")).sendKeys("merchnat");
		driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-sign-up/div/div/div/div[1]/div[2]/div/form/div/div[2]/div/div/input")).sendKeys("royal6");
		driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-sign-up/div/div/div/div[1]/div[2]/div/form/div/div[3]/div/div/input")).sendKeys("royal6@mailinator.com");
		driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-sign-up/div/div/div/div[1]/div[2]/div/form/div/div[4]/div/div/input")).sendKeys("123456");
	    driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-sign-up/div/div/div/div[1]/div[2]/div/form/div/div[5]/div/div/input")).click();
	    driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-sign-up/div/div/div/div[1]/div[2]/div/form/div/div[5]/div/div/input")).sendKeys("New York");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-sign-up/div/div/div/div[1]/div[2]/div/form/div/div[5]/div/div/input")).sendKeys(Keys.ARROW_DOWN);
	    driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-sign-up/div/div/div/div[1]/div[2]/div/form/div/div[5]/div/div/input")).sendKeys(Keys.ENTER);
	    driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-sign-up/div/div/div/div[1]/div[2]/div/form/div/div[7]/div[1]/div/input")).sendKeys("8987678767");
	    driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-sign-up/div/div/div/div[1]/div[2]/div/form/div/div[7]/div[2]/div/input")).sendKeys("New York");
	    driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-sign-up/div/div/div/div[1]/div[2]/div/form/div/div[9]/div/div/input")).sendKeys("3454");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-sign-up/div/div/div/div[1]/div[2]/div/form/div/div[10]/div[1]/div[1]/input")).sendKeys("C:\\Users\\LMD-Java\\Downloads\\home depot.jpg");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-sign-up/div/div/div/div[1]/div[2]/div/form/div/div[11]/div/a")).click();
	    Thread.sleep(5000);
	    
	   driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/app-sign-up/div/div/div/div[2]/div[2]/div/div[2]/app-store-add-edit-template/form/div/div[11]/div/div[1]/button")).click();
	
	   MyScreenRecorder.stopRecording();
	}


}
