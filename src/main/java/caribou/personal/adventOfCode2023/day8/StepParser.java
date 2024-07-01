package caribou.personal.adventOfCode2023.day8;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class StepParser {
	public Map<String, Pair<String, String>> parse(final String input) {
		return Arrays.stream(input.split("\n"))
				.collect(Collectors.toMap(
						ts -> ts.split(" = ")[0],
						ts -> Pair.of(getLeft(ts), getRight(ts)),
						(a1, a2) -> a1
				));
	}
	
	private static String getRight(final String ts) {
		return ts.substring(12, 15);
	}
	
	private static String getLeft(final String ts) {
		return ts.substring(7, 10);
	}
}
