package pages;

// Import By class to locate web elements
import org.openqa.selenium.By;

// Import WebDriver to control the browser
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    // Store the browser instance
    WebDriver driver;

    // Locator for Username textbox
    By usernameField = By.name("username");

    // Locator for Password textbox
    By passwordField = By.name("password");

    // Locator for Login button
    By loginButton = By.cssSelector("button[type='submit']");

    // Locator for Dashboard heading (used to verify successful login)
    By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    // Constructor to receive WebDriver from the test class
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Login method that accepts username and password
    public void login(String username, String password) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);

        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(loginButton).click();
    }

    // Verify whether Dashboard is displayed after login
    public boolean isDashboardDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).isDisplayed();
    }
}