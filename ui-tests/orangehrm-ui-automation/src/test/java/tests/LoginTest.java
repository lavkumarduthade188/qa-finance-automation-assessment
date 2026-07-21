package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "Verify successful login and redirection to Dashboard")
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        
        boolean isDashboardReached = wait.until(ExpectedConditions.urlContains("dashboard"));
        Assert.assertTrue(isDashboardReached, "Authentication unsuccessful. Timed out waiting for Dashboard.");
        
    }
}