package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.OrderBy;
import utils.StringHelper;

public class CatalogPage extends AbstractPage {

	@FindBy(xpath = "//div[@class = 'product-list __catalog']")
	WebElement catalog;

	@FindBy(xpath = "//span[@id = 'ui-id-1-button']")
	WebElement orderBtn;

	@FindBy(xpath = "//li[@id = 'ui-id-3']")
	WebElement orderByIncPriceBtn;

	@FindBy(xpath = "//li[@id = 'ui-id-4']")
	WebElement orderByDecPriceBtn;

	public CatalogPage(WebDriver driver) {
		super(driver, null); // ��� ����� �� ���������� ��������, ������� ���� �� �����

		PageFactory.initElements(driver, this);
	}

	//��������� ������ �� ��������
	public void orderByPrice(OrderBy orderBy) throws Exception {
		orderBtn.click();
		
		switch (orderBy) {
		case INC:
			orderByIncPriceBtn.click();
			break;
		case DEC:
			orderByDecPriceBtn.click();
			break;
		default:
			throw new Exception("�������� �� ��� ��� ����������");
		}
	}

	public void checkOrderByPrice(OrderBy orderBy) throws Exception {
		List<WebElement> productList = catalog.findElements(By.className("item")); // �������� ������ ���������

		for (int i = 1; i < productList.size(); i++) { // �������� ����� �� 2 ��������
			Integer price1, price2; // ���� ������������ �������

			// ����� ���� ����������� ��������
			String priceString = productList.get(i - 1).findElement(By.className("price")).findElement(By.tagName("ins")).getText(); 
			price1 = StringHelper.getDigit(priceString); // ������������ ������� � ���

			// ����� ���� �������� ��������
			priceString = productList.get(i).findElement(By.className("price")).findElement(By.tagName("ins")).getText(); 
			price2 = StringHelper.getDigit(priceString); // ������������ ������� � ���

			int result;
			switch (orderBy) {
			case INC:
				result = price1.compareTo(price2);
				break;
			case DEC:
				result = price2.compareTo(price1);
				break;
			default:
				throw new Exception("�������� �� ��� ��� ����������");
			}

			if (result > 0) { // ���� ���������� ���������� ���������, �� result �� ������ ���� ������ 0
				Assert.assertFalse("���� �� �� �������", true);
			}

		}
	}

}
