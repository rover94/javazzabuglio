package caribou.personal.adventOfCode2023.day12;

import java.util.List;
import java.util.stream.Stream;

public class SpringArrengementsParser {
	public List<SpringArrengement> parse(final String input) {
		return Stream.of(input.split("\n"))
				.map(line -> {
					final String[] split = line.split(" ");
					return new SpringArrengement().setDetail(Stream.of(split[0].split("")).toList())
							.setContiguous(Stream.of(split[1].split(",")).map(Integer::parseInt).toList());
				}).toList();
	}
}
