package caribou.personal.adventOfCode2023.day5;

import java.util.List;

public class SeedToLocationCalculatorV2 {
	
	private final Parser parser;
	private final List<List<Route>> routes;
	
	public SeedToLocationCalculatorV2(final Parser parser, final String maps) {
		this.parser = parser;
		this.routes = this.parser.parse(maps);
	}
	
	public SeedToLocationCalculatorV2(final String maps) {
		this(new SeedToLocationParse(), maps);
	}
	
	public Long getFinalLocationOf(final Long seed) {
		Long nextStep = seed;
		for (final List<Route> step: this.routes) {
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
