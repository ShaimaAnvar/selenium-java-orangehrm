package tests;
// Import WebDriver interface
import org.openqa.selenium.WebDriver;
// Import ChromeDriver to launch Chrome browser
import org.openqa.selenium.chrome.ChromeDriver;
// Import TestNG assertion methods
import org.testng.Assert;
// Import TestNG @Test annotation
import org.testng.annotations.Test;
// Import LoginPage class
import pages.LoginPage;
public class LoginTest {
    // Mark this method as a TestNG test
    @Test
    public void validLoginTest() {
        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        // Open OrangeHRM website
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);
        // Login using valid credentials
        loginPage.login("Admin", "admin123");
        // Verify Dashboard is displayed after successful login
        Assert.assertTrue(loginPage.isDashboardDisplayed());
        // Close the browser
        driver.quit();
    }
}