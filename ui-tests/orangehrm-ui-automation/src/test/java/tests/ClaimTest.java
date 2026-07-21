
package tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pages.ClaimPage;
import pages.DashboardPage;
import pages.LoginPage;

public class ClaimTest extends BaseTest {

	@Test(description = "Verify claim process")
	public void testInitiateClaimWorkflow() {
		LoginPage loginPage = new LoginPage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);
		ClaimPage claimPage = new ClaimPage(driver);

		String inputEvent = "Accommodation";
		String inputCurrency = "Indian Rupee";
		String inputRemark = "Accommodation expense reimbursement";

		loginPage.login("Admin", "admin123");

		dashboardPage.navigateToClaim();
		claimPage.clickSubmitClaimTab();

		claimPage.fillClaimForm(inputEvent, inputCurrency, inputRemark);

		claimPage.clickCreate();
		claimPage.scrollAndSubmit();

	}
}