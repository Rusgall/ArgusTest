package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
	WebDriver driver;

	String url;

	public AbstractPage(WebDriver driver, String url) {
		this.driver = driver;
		this.url = url;
	}

	public void checkURL() {
		Assert.assertEquals("Url не совпадает", url, driver.getCurrentUrl());
	}

	// Идем на страницу вызывающего пейджа(Если это возможно)
	public void goToPage() {
		if (url != null) {
			goToPage(url);
		}
	}

	public void goToPage(String url) {
		driver.get(url);
	}

}

