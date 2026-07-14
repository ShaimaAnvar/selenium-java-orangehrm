package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LogoutTest {
    @Test
    public void logoutTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123" );
        loginPage.logout();

        Assert.assertTrue( loginPage.isLoginpageDisplyed());
    }

}
