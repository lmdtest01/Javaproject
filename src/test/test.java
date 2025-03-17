package test;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class test {

    @Test
    void login() throws IOException, InterruptedException {
        ChromeOptions options = new ChromeOptions();
        
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa.wellbux.com/login");
        driver.manage().window().maximize();
        
        FileInputStream fis = new FileInputStream("C:\\Users\\LMD-Java\\eclipse-workspace\\Javaproject\\exl sheet\\Login.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(1).getLastCellNum();
        System.out.println("Row count: " + rowCount + " Column count: " + colCount);

        for (int i = 1; i <= rowCount; i++) {
            try {
                XSSFRow row = sheet.getRow(i);
                String email = row.getCell(0).getStringCellValue();
                int password = (int) row.getCell(1).getNumericCellValue();

                driver.findElement(By.id("loginUserEmailInput")).clear();
                driver.findElement(By.id("loginUserEmailInput")).sendKeys(email);
                driver.findElement(By.id("loginUserPwdInput")).clear();
                driver.findElement(By.id("loginUserPwdInput")).sendKeys(String.valueOf(password));
                
                driver.findElement(By.id("loginSubmitBtn")).click();
                System.out.println(i + "." + email + "||" + password);

                Thread.sleep(5000);

                WebElement element = driver.findElement(By.xpath("//li[@class='user__top_info dropdown']//child::div"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                element.click();

                Thread.sleep(2000);
                driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();

            } catch (Exception e) {
                System.out.println("Login attempt failed for row " + (i + 1) + ": " + e.getMessage());
            }
            driver.navigate().refresh();
        }
        
        driver.quit();
        workbook.close();
        fis.close();
    }
}
