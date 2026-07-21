
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameInput;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordInput;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password) {
		wait.until(ExpectedConditions.elementToBeClickable(usernameInput));

		usernameInput.sendKeys(username);

		passwordInput.sendKeys(password);

		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	}
}