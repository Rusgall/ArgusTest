package utils;

public class StringHelper {

	/**
	 * ������������ ������� � �����, ������� ��� ������ ����� ����� ����
	 */
	public static int getDigit(String string){
		int digital = Integer.valueOf(string.replaceAll("[^0-9]",""));
		return digital;
	}
}
