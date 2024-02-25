package caribou.personal.adventOfCode2023.day5;

import java.util.Arrays;
import java.util.List;

public class SeedToLocationParse implements Parser {
	@Override
	public List<List<Route>> parse(String maps) {
		final String[] split = maps.split(".*?map:");
		return Arrays.stream(split).map(s -> Arrays.stream(s.split("\n"))
						.filter(r -> !r.isBlank())
						.map(this::getRoute).toList())
				.filter(list -> !list.isEmpty())
				.toList();
		
	}
	
	private Route getRoute(final String route) {
		return new Route(Long.parseLong(route.split(" ")[0]), Long.parseLong(route.split(" ")[1]), Long.parseLong(route.split(" ")[2]));
	}
}
