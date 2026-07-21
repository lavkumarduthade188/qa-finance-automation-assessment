package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.RecruitmentPage;

public class RecruitmentTest extends BaseTest {

	@Test(description = "Verify Recruitment")
	public void testAddCandidateWorkflow() {
		LoginPage loginPage = new LoginPage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);
		RecruitmentPage recruitmentPage = new RecruitmentPage(driver);

		loginPage.login("Admin", "admin123");

		dashboardPage.navigateToRecruitment();
		recruitmentPage.addCandidate("John", "Cena", "johncena@gmail.com");

		Assert.assertEquals(recruitmentPage.getSavedCandidateName(), "John Cena", "Candidate verification mismatch.");
	}
}