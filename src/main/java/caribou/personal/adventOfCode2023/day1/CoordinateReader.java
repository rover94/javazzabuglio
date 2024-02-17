package caribou.personal.adventOfCode2023.day1;

import java.util.List;

public class CoordinateReader {
	
	private static final List<String> DIGITS =
			List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
					"1", "2", "3", "4", "5", "6", "7", "8", "9");
	
	public String getCoordinate(final List<String> encriptedCoordinate) {
		final int sum = encriptedCoordinate.stream()
				.map(ec -> Integer.valueOf(this.getCoordinate(ec)))
				.mapToInt(Integer::intValue)
				.sum();
		return String.valueOf(sum);
	}
	
	private String getCoordinate(final String ec) {
		return this.getFirstDigit(ec) + this.getLastDigit(ec);
	}
	
	private String getLastDigit(final String c) {
		String result = "";
		int biggerDigit = -1;
		for (final String digit : DIGITS) {
			final int indexOf = c.lastIndexOf(digit);
			if (indexOf >= 0 && indexOf > biggerDigit) {
				biggerDigit = indexOf;
				result = this.getValueAsSingleDigitString(c, digit, biggerDigit);
			}
		}
		
		return result;
	}
	
	private String getFirstDigit(final String c) {
		String result = "";
		int smallerDigit = 1000;
		for (final String digit : DIGITS) {
			final int indexOf = c.indexOf(digit);
			if (indexOf >= 0 && indexOf < smallerDigit) {
				smallerDigit = indexOf;
				result = this.getValueAsSingleDigitString(c, digit, smallerDigit);
			}
		}
		
		return result;
	}
	
	private String getValueAsSingleDigitString(final String c, final String digit, final int biggerDigit) {
		if (digit.length() == 1) {
			return c.substring(biggerDigit, biggerDigit + 1);
		}
		
		final String substring = c.substring(biggerDigit, biggerDigit + digit.length());
		if ("one".equals(substring)) {
			return "1";
		}
		if ("two".equals(substring)) {
			return "2";
		}
		if ("three".equals(substring)) {
			return "3";
		}
		if ("four".equals(substring)) {
			return "4";
		}
		if ("five".equals(substring)) {
			return "5";
		}
		if ("six".equals(substring)) {
			return "6";
		}
		if ("seven".equals(substring)) {
			return "7";
		}
		if ("eight".equals(substring)) {
			return "8";
		}
		return "9";
	}
}
