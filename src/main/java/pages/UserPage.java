package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Constants;

public class UserPage extends AbstractPage {
	
	
	@FindBy(xpath = "//input[@name = 'name']")
	WebElement nameInput;
	
	@FindBy(xpath = "//input[@name = 'email']")
	WebElement emailInput;
	
	public UserPage(WebDriver driver){
		super(driver, Constants.URL_USER_PAGE);
		
		PageFactory.initElements(driver, this);
	}
	
	public void checkUserName(String name){
		Assert.assertEquals("ФИО не совпадает", name, nameInput.getAttribute("value"));
	}
	
	public void checkEmail(String email){
		Assert.assertEquals("Email не совпадает", email, emailInput.getAttribute("value"));
	}
}
