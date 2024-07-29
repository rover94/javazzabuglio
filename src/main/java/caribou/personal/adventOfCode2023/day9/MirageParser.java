package caribou.personal.adventOfCode2023.day9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MirageParser {
	public List<List<Integer>> parse(final String input) {
		return Arrays.stream(input.split("\n"))
				.map(MirageParser::getIntegers)
				.toList();
	}
	
	private static List<Integer> getIntegers(final String list) {
		return Arrays.stream(list.split(" "))
				.map(Integer::valueOf)
				.collect(Collectors.toList());
	}
}
