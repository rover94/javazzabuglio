package caribou.personal.adventOfCode2023.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EngineSchematics {
	private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
	
	public Integer getPartNumberSum(final List<String> schematics) {
		int result = 0;
		final List<SymbolCoordinates> allSymbolsCoordinates = this.getAllSymbolsCoordinates(schematics);
		
		for (int rowIndex = 0; rowIndex < schematics.size(); rowIndex++) {
			final String schematic = schematics.get(rowIndex);
			final Matcher matcher = NUMBER_PATTERN.matcher(schematic);
			
			while (matcher.find()) {
				final int numberStartIndex = matcher.start();
				final int numberEndIndex = matcher.end();
				
				if (this.hasSymbolAround(numberStartIndex, allSymbolsCoordinates, rowIndex, numberEndIndex)) {
					result += Integer.parseInt(matcher.group());
				}
			}
		
		}
		return result;
	}
	
	private boolean hasSymbolAround(final int indexOfNumber,
									final List<SymbolCoordinates> allSymbolsCoordinates,
									final int i,
									final int indexEnd) {
		final List<SymbolCoordinates> coordinatesTocheck = new ArrayList<>();
		for (int index = indexOfNumber - 1; index <= indexEnd; index++) {
			coordinatesTocheck.add(new SymbolCoordinates(i - 1, index));
			coordinatesTocheck.add(new SymbolCoordinates(i + 1, index));
		}
		
		coordinatesTocheck.add(new SymbolCoordinates(i, indexOfNumber -1));
		coordinatesTocheck.add(new SymbolCoordinates(i, indexEnd));
		return coordinatesTocheck.stream().anyMatch(allSymbolsCoordinates::contains);
	}
	
	private List<SymbolCoordinates> getAllSymbolsCoordinates(final List<String> schematics) {
		final List<SymbolCoordinates> result = new ArrayList<>();
		for (int i = 0; i < schematics.size(); i++) {
			final String schematic = schematics.get(i);
			final String s = schematic.replaceAll("[0-9]", ".");
			
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) != '.') {
					result.add(new SymbolCoordinates(i, j));
				}
			}
		}
		return result;
	}
}
