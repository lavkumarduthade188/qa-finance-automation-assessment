
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ClaimPage {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//a[text()='Submit Claim']")
	private WebElement submitClaimTab;

	@FindBy(xpath = "//label[text()='Event']/following::div[@class='oxd-select-text-input']")
	private WebElement eventDropdown;

	@FindBy(xpath = "//label[text()='Currency']/following::div[@class='oxd-select-text-input']")
	private WebElement currencyDropdown;

	@FindBy(xpath = "//textarea")
	private WebElement remarksField;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement createButton;

	@FindBy(xpath = "//button[text()=' Submit ']")
	private WebElement submitButton;

	@FindBy(xpath = "//div[text()='Event']/following-sibling::div")
	private WebElement savedEventText;

	@FindBy(xpath = "//div[text()='Currency']/following-sibling::div")
	private WebElement savedCurrencyText;

	@FindBy(xpath = "//div[text()='Remarks']/following-sibling::div")
	private WebElement savedRemarksText;

	public ClaimPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void clickSubmitClaimTab() {
		wait.until(ExpectedConditions.elementToBeClickable(submitClaimTab)).click();
	}

	public void fillClaimForm(String event, String currency, String remark) {

		wait.until(ExpectedConditions.elementToBeClickable(eventDropdown)).click();
		By dynamicEventLocator = By.xpath("//div[@role='listbox']//div[@role='option']//*[text()='" + event + "']");
		wait.until(ExpectedConditions.elementToBeClickable(dynamicEventLocator)).click();

		wait.until(ExpectedConditions.elementToBeClickable(currencyDropdown)).click();
		By dynamicCurrencyLocator = By
				.xpath("//div[@role='listbox']//div[@role='option']//*[contains(text(), '" + currency + "')]");
		wait.until(ExpectedConditions.elementToBeClickable(dynamicCurrencyLocator)).click();

		wait.until(ExpectedConditions.visibilityOf(remarksField)).sendKeys(remark);
	}

	public void clickCreate() {
		wait.until(ExpectedConditions.elementToBeClickable(createButton)).click();
	}

	public void scrollAndSubmit() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()=' Submit ']")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);

		wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	}

}