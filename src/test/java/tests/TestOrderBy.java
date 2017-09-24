package tests;

import org.junit.Test;

import pages.CatalogPage;
import utils.Constants;
import utils.OrderBy;

public class TestOrderBy extends BaseTest {
	
	@Test
	public void orderByInc() throws Exception{
		CatalogPage catalogPage = new CatalogPage(webDriver);
		catalogPage.goToPage(Constants.URL_MEIZU_PAGE); // Идем на страницу с телефонами Meizu
		catalogPage.orderByPrice(OrderBy.INC); // Делаем сортировку по возрастанию
		catalogPage.checkOrderByPrice(OrderBy.INC); // Проверяем что сортировка прошла успешно
	}
	
	@Test
	public void orderByDec() throws Exception{
		CatalogPage catalogPage = new CatalogPage(webDriver);
		catalogPage.goToPage(Constants.URL_MEIZU_PAGE); // Идем на страницу с телефонами Meizu
		catalogPage.orderByPrice(OrderBy.DEC); // Делаем сортировку по убыванию
		catalogPage.checkOrderByPrice(OrderBy.DEC); // Проверяем что сортировка прошла успешно
	}

}
