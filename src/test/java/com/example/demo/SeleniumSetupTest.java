package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumSetupTest {
    public static void main(String[] args) {
        // Thiết lập đường dẫn đến ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vietn\\Downloads\\chromedriver_win32\\chromedriver.exe");

        // Cấu hình các tùy chọn cho Chrome
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\program files\\google\\chrome\\application");

        // Khởi tạo WebDriver với các tùy chọn
        WebDriver driver = new ChromeDriver(options);

        // Mở trang Google
        driver.get("https://www.google.com");

        // In tiêu đề trang
        System.out.println("Title: " + driver.getTitle());

        // Đóng trình duyệt
        driver.quit();
    }
}

