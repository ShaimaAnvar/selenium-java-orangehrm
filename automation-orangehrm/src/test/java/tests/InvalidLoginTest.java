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
public class InvalidLoginTest {
    // Mark this method as a TestNG test
    @Test
    public void invalidLoginTest() {
        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        // Open OrangeHRM website
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);
        // Login using valid credentials
        loginPage.login("Admin", "wrongpassword");

        // Verify invalid message is displayed after successful login
        Assert.assertEquals(loginPage.getInvalidCredentialsMessage(), "Invalid credentials");
        // Close the browser
        driver.quit();
    }
}