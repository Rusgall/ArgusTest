package tests;

import org.junit.Test;

import pages.LoginPage;
import pages.MainPage;
import pages.UserPage;
import utils.Constants;

public class TestLogin extends BaseTest{

	@Test
	public void loginSuccessfully(){
		MainPage mainPage = new MainPage(webDriver);
		mainPage.goToPage(); // идем на главную страницу
		
		LoginPage loginPage = mainPage.clickSignIn();//Переходим к логину
		loginPage.checkURL();//Проверяем ссылку
		
		UserPage userPage = loginPage.loginSuccess(Constants.EMAIL, Constants.PASS_CORRECT); // Логинимся под корректными данными
		userPage.checkURL();//Проверяем ссылку
		userPage.checkUserName(Constants.USERNAME);//Проверяем логин и мыло
		userPage.checkEmail(Constants.EMAIL);
	}
	
	@Test
	public void loginFailed(){
		MainPage mainPage = new MainPage(webDriver);
		mainPage.goToPage(); // идем на главную страницу

		LoginPage loginPage = mainPage.clickSignIn();//Переходим к логину
		loginPage.loginFail(Constants.EMAIL, Constants.PASS_INCORRECT); // Логинимся под некорректными данными
		loginPage.checkURL();// Проверяем что остались на странице логина
	}

}
