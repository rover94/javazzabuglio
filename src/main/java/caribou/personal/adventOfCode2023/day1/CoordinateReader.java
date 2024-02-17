package caribou.personal.adventOfCode2023.day1;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CoordinateReader {
	
	public String getCoordinate(final List<String> encriptedCoordinate) {
		final int sum = encriptedCoordinate.stream()
				.map(ec -> Integer.valueOf(this.getFirstDigit(ec) + this.getLastDigit(ec)))
				.mapToInt(Integer::intValue)
				.sum();
		return String.valueOf(sum);
	}
	
	private String getLastDigit(String c) {
		return this.getFirstDigit(new StringBuilder(c).reverse().toString());
	}
	
	private String getFirstDigit(String c) {
		final Matcher matcher = Pattern.compile("\\d").matcher(c);
		matcher.find();
		return matcher.group();
	}
}
