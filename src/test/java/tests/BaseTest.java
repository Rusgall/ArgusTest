package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

	WebDriver webDriver;
	ChromeOptions options;

	@BeforeClass
	public static void beforeClass() {
		// Тут захардкодил путь к драйверу
		System.setProperty("webdriver.chrome.driver", "D:/Ruslan/chromedriver_win32/chromedriver.exe");
	}

	@Before
	public void beforeTest() {
		options = new ChromeOptions();
		options.addArguments("--start-maximized");

		webDriver = new ChromeDriver(options);
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@After
	public void afterTest() {
		webDriver.quit();
	}

}
