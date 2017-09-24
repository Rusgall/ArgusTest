package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Constants;

public class MainPage extends AbstractPage {
	
	@FindBy(xpath = "//a[@href = '/user/login']")
	WebElement loginLink;
	
	public MainPage(WebDriver driver){
		super(driver, Constants.URL_MAIN_PAGE);
		
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickSignIn(){
		loginLink.click();
		return new LoginPage(driver);
	}

}
