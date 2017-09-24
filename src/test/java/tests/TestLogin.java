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
		mainPage.goToPage(); // ���� �� ������� ��������
		
		LoginPage loginPage = mainPage.clickSignIn();//��������� � ������
		loginPage.checkURL();//��������� ������
		
		UserPage userPage = loginPage.loginSuccess(Constants.EMAIL, Constants.PASS_CORRECT); // ��������� ��� ����������� �������
		userPage.checkURL();//��������� ������
		userPage.checkUserName(Constants.USERNAME);//��������� ����� � ����
		userPage.checkEmail(Constants.EMAIL);
	}
	
	@Test
	public void loginFailed(){
		MainPage mainPage = new MainPage(webDriver);
		mainPage.goToPage(); // ���� �� ������� ��������

		LoginPage loginPage = mainPage.clickSignIn();//��������� � ������
		loginPage.loginFail(Constants.EMAIL, Constants.PASS_INCORRECT); // ��������� ��� ������������� �������
		loginPage.checkURL();// ��������� ��� �������� �� �������� ������
	}

}
