package br.com.ricardoludwig.customer.util;

public class JsonBuild {

	public static String jsonFormat(String... args) {

		if (args.length <= 0) {
			return "{}";
		}

		StringBuilder strB = new StringBuilder();
		strB.append("{");
		for (int index = 0; index < args.length; index++) {
			if (index %2 == 0) {
				strB.append("\"" + args[index] + "\":");
			} else {
				if (index + 1 == args.length) {
					strB.append("\"" + args[index] + "\"");
				} else {
					strB.append("\"" + args[index] + "\",");
				}
				
			}
		}
		strB.append("}");
		return strB.toString();
	}

}
