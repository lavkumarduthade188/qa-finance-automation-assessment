
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RecruitmentPage {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement addButton;

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstNameInput;

	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastNameInput;

	@FindBy(xpath = "//label[text()='Email']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	private WebElement emailInput;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;

	@FindBy(xpath = "//h6[text()='Application Stage']/following::p[@class='oxd-text oxd-text--p']")
	private WebElement profileHeaderName;

	public RecruitmentPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void addCandidate(String firstName, String lastName, String email) {
		wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
		wait.until(ExpectedConditions.elementToBeClickable(firstNameInput)).sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		emailInput.sendKeys(email);
		saveButton.click();
	}

	public String getSavedCandidateName() {
		return wait.until(ExpectedConditions.visibilityOf(profileHeaderName)).getText();
	}
}