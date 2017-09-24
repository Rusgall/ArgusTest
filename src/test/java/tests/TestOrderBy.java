package tests;

import org.junit.Test;

import pages.CatalogPage;
import utils.Constants;
import utils.OrderBy;

public class TestOrderBy extends BaseTest {
	
	@Test
	public void orderByInc() throws Exception{
		CatalogPage catalogPage = new CatalogPage(webDriver);
		catalogPage.goToPage(Constants.URL_MEIZU_PAGE); // ���� �� �������� � ���������� Meizu
		catalogPage.orderByPrice(OrderBy.INC); // ������ ���������� �� �����������
		catalogPage.checkOrderByPrice(OrderBy.INC); // ��������� ��� ���������� ������ �������
	}
	
	@Test
	public void orderByDec() throws Exception{
		CatalogPage catalogPage = new CatalogPage(webDriver);
		catalogPage.goToPage(Constants.URL_MEIZU_PAGE); // ���� �� �������� � ���������� Meizu
		catalogPage.orderByPrice(OrderBy.DEC); // ������ ���������� �� ��������
		catalogPage.checkOrderByPrice(OrderBy.DEC); // ��������� ��� ���������� ������ �������
	}

}
