package com.example.demo;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vietn\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/vietn/Downloads/projects/Testing%20with%20Selenium/TestingWithSelenium/Untitled-1.html");

    }

    @Test
    public void testSuccessfulLogin() {
        // Nhập thông tin đăng nhập
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin123");
        driver.findElement(By.id("loginButton")).click();

        // Kiểm tra sự hiển thị của phần tử errorMessage
        WebDriverWait waitForErrorMessage = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement errorMessage = waitForErrorMessage.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMessage")));

            // Kiểm tra thông báo lỗi không hiển thị

            Assert.assertFalse(errorMessage.isDisplayed(), "Error message should not be displayed.");
        } catch (TimeoutException e) {
            // Nếu phần tử không hiển thị sau 10 giây, nghĩa là login thành công và không có lỗi
            System.out.println("No error message displayed, login might be successful.");
        }
    }
    @Test
    public void testInvalidLogin() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.id("loginButton")).click();

        // Kiểm tra thông báo lỗi
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMessage")));

        // Kiểm tra thông báo lỗi khi đăng nhập sai
        Assert.assertEquals(errorMessage.getText(), "Tên người dùng hoặc mật khẩu không đúng");
    }
    @Test
    public void testEmptyFields() {
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("loginButton")).click();

        // Kiểm tra thông báo lỗi
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMessage")));

        // Kiểm tra thông báo yêu cầu nhập thông tin
        Assert.assertEquals(errorMessage.getText(), "Vui lòng nhập tên người dùng và mật khẩu");
    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

