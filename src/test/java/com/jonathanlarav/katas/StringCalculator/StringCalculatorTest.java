package com.jonathanlarav.katas.StringCalculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
	
	private StringCalculator stringCalculator;
	
	@Before
	public void setup() {
		stringCalculator = new StringCalculator();
	}
	
	@Test
	public void testSimpleAdd() {
		Assert.assertTrue(stringCalculator.add("") == 0);
		Assert.assertTrue(stringCalculator.add("1") == 1);
		Assert.assertTrue(stringCalculator.add("1;2") == 3);
		Assert.assertTrue(stringCalculator.add("1;2;5;6") == 14);
	}
	
	@Test
	public void testComplexAdd() {
		int result = stringCalculator.add("1;\n2;\n3;4");
		Assert.assertTrue(result == 10);
	}
	
	@Test
	public void testAddWithDelimiter() {
		int result = stringCalculator.add("\\;\n1;2");
		Assert.assertTrue(result == 3);
	}
	
	@Test(expected=RuntimeException.class)
	public void testAddNegativesWithDelimiter() {
		stringCalculator.add("\\;\n1;2;-3;4;-5");
	}

}