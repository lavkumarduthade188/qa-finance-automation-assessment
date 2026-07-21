
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DashboardPage {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//a[contains(@href, 'recruitment/viewRecruitmentModule')]")
	private WebElement recruitmentMenu;

	@FindBy(xpath = "//a[contains(@href, 'claim/viewClaimModule')]")
	private WebElement claimMenu;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void navigateToRecruitment() {
		wait.until(ExpectedConditions.visibilityOf(recruitmentMenu)).click();
	}

	public void navigateToClaim() {
		wait.until(ExpectedConditions.visibilityOf(claimMenu)).click();
	}

}