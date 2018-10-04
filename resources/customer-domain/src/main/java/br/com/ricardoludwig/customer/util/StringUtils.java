package br.com.ricardoludwig.customer.util;

public class StringUtils {

	public static boolean isEmpty(String value) {

		if (value == null) {
			return true;
		}

		if ("".equals(value.trim())) {
			return true;
		}
		return false;
	}
	
	public static boolean isNotEmpty(String value) {
		return !isEmpty(value);
	}

}
