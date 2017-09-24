package utils;

public class StringHelper {

	/**
	 * Конвертируем стрингу в число, убираем все лишние знаки кроме цифр
	 */
	public static int getDigit(String string){
		int digital = Integer.valueOf(string.replaceAll("[^0-9]",""));
		return digital;
	}
}
