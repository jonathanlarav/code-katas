package com.jonathanlarav.katas.StringCalculator;

import java.util.Arrays;

public class StringCalculator {
	
	private final String DELIMITER_CHARACTER = "\\";

	public int add(String value) throws NumberFormatException {
		if (value == null)
			throw new IllegalArgumentException("Value can not be null");
		if (value.isEmpty()) {
			return 0;
		} else {
			String delimiter = getDelimeter(value);
			String[] numbers = getNumbers(delimiter, value);
			checkNegatives(numbers);
			return sumStringNumbers(numbers);
		}
	}
	
	private String[] getNumbers(String delimiter, String value) {
		String[] numbers = value.split("["+delimiter+"]");
		if(numbers[0].equals(DELIMITER_CHARACTER)){
			return Arrays.copyOfRange(numbers, 1, numbers.length);
		}
		return numbers;
	}

	private int sumStringNumbers(String[] numbers) {
		int a=0;
		for (String number : numbers) {
			a+=Integer.parseInt(number.trim());
		}
		return a;
	}

	private String getDelimeter(String value){
		if(value.startsWith(DELIMITER_CHARACTER)){
			return value.substring(1, value.indexOf("\n")+1).trim();
		}else {
			return ";";
		}
	}

	private void checkNegatives(String[] numbers) {
		String negativeMsg = "";
		for (String number : numbers) {
			if(Integer.parseInt(number.trim())<0){
				negativeMsg+=number.trim()+", ";
				continue;
			}
		}
		if(!negativeMsg.equals("")){
			throw new RuntimeException("Negatives not allowed: "+negativeMsg.trim());
		}
	}
}