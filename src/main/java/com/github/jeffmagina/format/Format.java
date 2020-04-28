package com.github.jeffmagina.format;

public class Format {
	public String firstLettertoUpperCase(String stringbuffer) {
		StringBuilder sb = new StringBuilder();
		sb.append(Character.toUpperCase(stringbuffer.charAt(0)));
		sb.append(stringbuffer.substring(1).toLowerCase());
		return sb.toString();
	}

}
