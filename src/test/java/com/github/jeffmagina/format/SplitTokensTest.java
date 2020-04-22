package com.github.jeffmagina.format;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SplitTokensTest {
	
	Format format = new Format();
	ArrayList<String> actual;
	ArrayList<String> expected = new ArrayList<String>();
	
	@Before
	public void setup() {
	expected.add("How");
	expected.add("Are");
	expected.add("You");
	
	}
	
	@Test
	public void whensplittingHowAreYou() {
		
		//Experiment
		actual = format.splitTokens("How Are You", " ");
		
		//Assert
		assertTrue(expected.equals(actual));
		
	}

}