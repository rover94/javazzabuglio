package caribou.personal.adventOfCode2023.day5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SeedToLocationParseTest {
	@Test
	void theInputIsParsedCorrectly() {
		final String input = """
				seed-to-soil map:
				50 98 2
				52 50 48
				
				soil-to-fertilizer map:
				0 15 37
				37 52 2
				39 0 15
				
				fertilizer-to-water map:
				49 53 8
				0 11 42
				42 0 7
				57 7 4
				
				water-to-light map:
				88 18 7
				18 25 70
				""";
		final List<List<Route>> result = new SeedToLocationParse().parse(input);
		
		assertThat(result).isEqualTo(
				List.of(
						List.of(new Route(50, 98, 2), new Route(52, 50, 48)),
						List.of(new Route(0, 15, 37), new Route(37, 52, 2), new Route(39, 0, 15)),
						List.of(new Route(49, 53, 8), new Route(0, 11, 42), new Route(42, 0, 7), new Route(57, 7, 4)),
						List.of(new Route(88, 18, 7), new Route(18, 25, 70))
				)
		);
	}
}