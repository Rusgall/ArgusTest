package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Constants;

public class LoginPage extends AbstractPage {
	
	@FindBy(xpath = "//input[@class=' login-form-control']")
	WebElement emailInput;
	
	@FindBy(xpath = "//input[@class='login-form-control']")
	WebElement passInput;
	
	@FindBy(xpath = "//input[@class= 'btn __big']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class = 'error-msg']")
	WebElement errorLoginMsg;
	
	public LoginPage(WebDriver driver){
		super(driver, Constants.URL_LOGIN_PAGE);
		
		PageFactory.initElements(driver, this);
	}
	
	private void enterEmail(String email){
		emailInput.click();
		emailInput.clear();
		emailInput.sendKeys(email);
	}
	
	private void enterPass(String pass){
		passInput.click();
		passInput.clear();
		passInput.sendKeys(pass);
	}
	
	private void clickBtnLogin(){
		loginBtn.click();
	}
	
	public UserPage loginSuccess(String email, String pass){
		enterEmail(email);
		enterPass(pass);
		clickBtnLogin();
		return new UserPage(driver);
	}
	
	public void loginFail(String email, String pass){
		enterEmail(email);
		enterPass(pass);
		clickBtnLogin();
		Assert.assertEquals("Неверный текст ошибки", "Неверный логин или пароль", errorLoginMsg.getText());
	}

}
