package pages;

// Import By class to locate web elements
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;

// Import WebDriver to control the browser
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
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
    By invalidCredentialsMessage = By.xpath("//p[text()='Invalid credentials']");
    By profileDropdown = By.className("oxd-userdropdown-tab");
    By logoutLink = By.xpath("//a[text()='Logout']");
    By loginPageHeader = By.xpath("//h5[text()='Login']");

    // Constructor to receive WebDriver from the test class
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Login method that accepts username and password
    public void login(String username, String password) {
        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait for usernamnefield
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);

        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(loginButton).click();
    }
    public void logout(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileDropdown)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink)).click();


    }

    // Verify whether Dashboard is displayed after login
    public boolean isDashboardDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).isDisplayed();
    }
    public String getInvalidCredentialsMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialsMessage)).getText();

    }
    public boolean isLoginpageDisplyed(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageHeader)).isDisplayed();

    }
}