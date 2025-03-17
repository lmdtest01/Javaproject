package test;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

public class ForgotPasswordTest {
   
    WebDriver driver;
    WebDriverWait wait;

    public void setup() {
        // Setup WebDriver (Assuming ChromeDriver is used)
       
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void runTest() throws Exception {
        // Load Excel data
        FileInputStream file = new FileInputStream(new File("C:\\Users\\LMD-Java\\eclipse-workspace\\Javaproject\\exl sheet\\Login.xlsx"));
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet("Sheet1");

        // Iterate over email, OTPs, and passwords, starting from the second row (index 1)
        for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Start from row 1 (skip header)
            Row row = sheet.getRow(i);
            if (row == null) continue; // Skip if row is empty

            String email = row.getCell(0).getStringCellValue();
            String oldPassword = row.getCell(1).getStringCellValue();
            String otp = row.getCell(2).getStringCellValue();

            // Step 1: Navigate to Login Page and Click "Forgot Password"
            driver.get("https://qa.wellbux.com/login");
            driver.findElement(By.id("loginFPLink")).click(); // Replace with actual locator for "Forgot Password"

            // Step 2: Enter Email in Forgot Password Screen
            WebElement emailInput = driver.findElement(By.id("forgotPwdEmailInput"));
            emailInput.sendKeys(email);
            driver.findElement(By.id("forgotPasswordSubmitBtn")).click();

            // Step 3: Wait for "Update Password" screen to appear (check for OTP input field or heading)
            try {
                WebElement otpInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("updatePasswordOtpInput")));
                System.out.println("Valid email. Proceeding to 'Update Password' screen...");

                // Step 4: Enter OTP and Old Password on the Update Password Screen
                otpInput.sendKeys(otp);

                WebElement oldPasswordInput = driver.findElement(By.id("updatePasswordPwdInput"));
                oldPasswordInput.sendKeys(oldPassword); // Entering old password from Excel

                // Static new password (changed to string)
                WebElement newPasswordInput = driver.findElement(By.id("newPasswordInput"));
                newPasswordInput.sendKeys("123456"); // Static new password as a string

                driver.findElement(By.id("updatePasswordUpdateBtn")).click(); // Replace with actual locator for submit button

                // Step 5: Check if OTP and Old Password are valid or invalid
                // Use another element to verify successful password update (e.g., success message)
                boolean success = wait.until(ExpectedConditions.urlContains("success_screen"));
                if (success) {
                    System.out.println("OTP and Old Password are valid. Password updated successfully.");
                } else {
                    System.out.println("Invalid OTP or Old Password. Please check the input.");
                }
            } catch (TimeoutException e) {
                System.out.println("Invalid email or page did not load correctly. Skipping to the next test case.");
            }
        }

        workbook.close();
        file.close();
    }

    public void tearDown() {
        // Close the browser
        driver.quit();
    }

    public static void main(String[] args) throws Exception {
        ForgotPasswordTest test = new ForgotPasswordTest();
        test.setup();
        test.runTest();
        test.tearDown();
    }
}
