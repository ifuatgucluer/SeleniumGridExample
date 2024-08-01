package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SeleniumGridExample {
    public static void main(String[] args) {
        // Selenium Grid Hub URL
        String hubURL = "http://localhost:4444/wd/hub";

        // Desired capabilities for the browser
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");

        WebDriver driver = null;

        try {
            // Initialize RemoteWebDriver with the hub URL and desired capabilities
            driver = new RemoteWebDriver(new URL(hubURL), capabilities);

            // Navigate to a website
            driver.navigate().to("https://www.example.com");

            // Locate an element and perform actions
            WebElement element = driver.findElement(By.name("q"));
            element.sendKeys("Selenium Grid");
            element.submit();

            // Wait for the page to load
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Print the title of the page
            System.out.println("Page title is: " + driver.getTitle());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                // Close the browser
                driver.quit();
            }
        }
    }
}
