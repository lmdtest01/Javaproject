
package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginMerchant {

    @Test
    void login() throws IOException, InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\LMD-Java\\eclipse-workspace\\Javaproject\\exl sheet\\Login.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int rowCount = sheet.getLastRowNum();
            System.out.println("Rowcount: " + rowCount);

            for (int i = 1; i <= rowCount; i++) {
                XSSFRow row = sheet.getRow(i);
                if (row == null) continue;  // Skip if the row is empty

                String email = getCellValueAsString(row.getCell(0));
                String password = getCellValueAsString(row.getCell(1)).trim(); // Trim any leading or trailing spaces

                // Proceed if either email or password is present
                if (email.isEmpty() && password.isEmpty()) {
                    System.out.println("Skipping row " + i + " as both email and password are missing.");
                    continue;
                }

                driver.get("https://qa.wellbux.com/login");
                driver.manage().window().maximize();
                Thread.sleep(2000); // Wait for the page to load

                try {
                    WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginUserEmailInput")));
                    WebElement passwordInput = driver.findElement(By.id("loginUserPwdInput"));
                    
                    if (!email.isEmpty()) {
                        emailInput.clear();
                        emailInput.sendKeys(email);
                    }
                    
                    if (!password.isEmpty()) {
                        passwordInput.clear();
                        passwordInput.sendKeys(password);
                    }

                    // Only click the submit button if either email or password is provided
                    if (!email.isEmpty() || !password.isEmpty()) {
                        driver.findElement(By.id("loginSubmitBtn")).click();
                    }

                    // Wait for toast message to disappear
                    try {
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".toast-title.ng-star-inserted")));
                    } catch (Exception e) {
                        System.out.println("No overlay or toast message detected.");
                    }

                    // Wait for the dropdown element to be visible
                    WebElement userInfoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='user__top_info dropdown']//child::div")));

                    // Retry clicking on the dropdown element if blocked
                    for (int attempt = 0; attempt < 3; attempt++) {
                        try {
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", userInfoElement);
                            userInfoElement.click();
                            break; // Exit loop if click is successful
                        } catch (Exception e) {
                            System.out.println("Click attempt " + (attempt + 1) + " failed: " + e.getMessage());
                            // Wait briefly before retrying
                            Thread.sleep(1000);
                            // Wait again for the toast message to disappear
                            try {
                                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".toast-title.ng-star-inserted")));
                            } catch (Exception ignore) {
                                // Continue if the toast message is not visible
                            }
                        }
                    }

                    // Wait for the logout link and click it
                    WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']")));
                    logoutLink.click();

                    // Verify that logout was successful
                    wait.until(ExpectedConditions.urlToBe("https://qa.wellbux.com/login")); // Assumes login redirects to login page

                    // Refresh the page only once here, after logout
                    driver.navigate().refresh();
                    Thread.sleep(1000);  // Add a small delay to ensure the refresh completes

                } catch (Exception e) {
                    System.out.println("Exception occurred: " + e.getMessage());
                }
            }
        } finally {
            driver.quit();
        }
    }

    // Helper method to get cell value as String
    private String getCellValueAsString(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.format("%.0f", cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}
