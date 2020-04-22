package com.github.jeffmagina.format;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Format {

	public ArrayList<String> splitTokens(String message, String delim) {

		StringTokenizer buffer = new StringTokenizer(message, delim);

		ArrayList<String> stringBuffer = new ArrayList<String>();
		while (buffer.hasMoreTokens()) {
			stringBuffer.add(buffer.nextToken());
		}

		return stringBuffer;
	}

	public void wholeArrayListFirstLetterToUpperCase(ArrayList<String> stringbuffer) {
		for (int i = 0; i < stringbuffer.size(); i++) {
			String name = stringbuffer.get(i);
			stringbuffer.set(i, firstLettertoUpperCase(name));
		}
	}
	
	public String firstLettertoUpperCase(String stringbuffer) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(Character.toUpperCase(stringbuffer.charAt(0)));
		sb.append(stringbuffer.substring(1).toLowerCase());
		
		return sb.toString();
	}

}
