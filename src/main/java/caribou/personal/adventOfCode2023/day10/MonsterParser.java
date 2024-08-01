package caribou.personal.adventOfCode2023.day10;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MonsterParser {
	public List<List<String>> parse(final String input) {
		return Stream.of(input.split("\n"))
				.map(line -> Stream.of(line.split(""))
				.collect(Collectors.toList()))
				.collect(Collectors.toList());
	}
}
