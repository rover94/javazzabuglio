package caribou.personal.adventOfCode2023.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EngineGearRatio {
	private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
	
	public long getGearRatio(final List<String> schematics) {
		long result = 0;
		final List<SymbolCoordinates> allSymbolsCoordinates = this.getAllStars(schematics);
		
		for (int rowIndex = 0; rowIndex < schematics.size(); rowIndex++) {
			final String schematic = schematics.get(rowIndex);
			final Matcher matcher = NUMBER_PATTERN.matcher(schematic);
			
			while (matcher.find()) {
				final int numberStartIndex = matcher.start();
				final int numberEndIndex = matcher.end();
				
				addNeighbourIfNeeded(numberStartIndex, allSymbolsCoordinates, rowIndex, numberEndIndex, Integer.parseInt(matcher.group()));
			}
			
		}
		return allSymbolsCoordinates.stream()
				.filter(coordinate -> coordinate.neighbours().size() == 2)
				.map(coordinate -> coordinate.neighbours().get(0) * coordinate.neighbours().get(1))
				.mapToLong(Long::valueOf)
				.sum();
	}
	
	private void addNeighbourIfNeeded(final int indexOfNumber,
									  final List<SymbolCoordinates> allSymbolsCoordinates,
									  final int i,
									  final int indexEnd,
									  final int number) {
		final List<SymbolCoordinates> coordinatesTocheck = new ArrayList<>();
		for (int index = indexOfNumber - 1; index <= indexEnd; index++) {
			coordinatesTocheck.add(new SymbolCoordinates(i - 1, index));
			coordinatesTocheck.add(new SymbolCoordinates(i + 1, index));
		}
		
		coordinatesTocheck.add(new SymbolCoordinates(i, indexOfNumber - 1));
		coordinatesTocheck.add(new SymbolCoordinates(i, indexEnd));
		allSymbolsCoordinates.stream().filter(coordinatesTocheck::contains)
				.forEach(c -> c.addNeighbour(number));
	}
	
	private List<SymbolCoordinates> getAllStars(final List<String> schematics) {
		final List<SymbolCoordinates> result = new ArrayList<>();
		for (int i = 0; i < schematics.size(); i++) {
			for (int j = 0; j < schematics.get(i).length(); j++) {
				if (schematics.get(i).charAt(j) == '*') {
					result.add(new SymbolCoordinates(i, j));
				}
			}
		}
		return result;
	}
}
