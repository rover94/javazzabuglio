package caribou.personal.adventOfCode2023.day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObservatoryExpander {
	public List<List<String>> expandUniverse(final List<List<String>> parsedStars) {
		return expandColumns(expandLines(parsedStars));
	}
	
	private List<List<String>> expandColumns(final List<List<String>> expandedLines) {
		final List<List<String>> expanded = expandLines(transpose(expandedLines));
		return transpose(expanded);
	}
	
	private List<List<String>> expandLines(final List<List<String>> parsedStars) {
		final List<List<String>> results = new ArrayList<>();
		parsedStars.forEach(starLine -> {
			if (!starLine.contains("#")) {
				Collections.fill(starLine, "x");
				results.add(starLine);
			} else {
				results.add(starLine);
			}
		});
		return results;
	}
	
	private List<List<String>> transpose(final List<List<String>> table) {
		final List<List<String>> ret = new ArrayList<>();
		final int n = table.get(0).size();
		for (int i = 0; i < n; i++) {
			final List<String> col = new ArrayList<>();
			for (final List<String> row : table) {
				col.add(row.get(i));
			}
			ret.add(col);
		}
		return ret;
	}
}
