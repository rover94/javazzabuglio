package caribou.personal.adventOfCode2023.day5;

import java.util.List;

public class SeedToLocationCalculator {
	
	private final Parser parser;
	
	public SeedToLocationCalculator(final Parser parser) {
		this.parser = parser;
	}
	
	public SeedToLocationCalculator() {
		this(new SeedToLocationParse());
	}
	
	public Long getFinalLocationOf(final Long seed, final String maps) {
		List<List<Route>> parse = this.parser.parse(maps);
		Long nextStep = seed;
		for (final List<Route> step: parse ) {
			for (final Route route: step) {
				if (route.contains(nextStep)) {
					nextStep = route.getNextStep(nextStep);
					break;
				}
			}
		}
		return nextStep;
	}
}
