package com.github.jeffmagina.format;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.github.jeffmagina.takeout.format.Format;

public class FirstLetterToUpperCaseTest {
	
	String testString;
	Format format = new Format();
	
	@Before
	public void setup() {

	}
	
	@Test
	public void whenConvertinguppercaseToUppercase() {
		
		//Experiment
		String expected = "Uppercase";
		String actual = format.firstLettertoUpperCase("uppercase");
		
		//Assert
		assertTrue(expected.equals(actual));
		

	}

}
