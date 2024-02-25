package caribou.personal.adventOfCode2023.day5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class SeedToLocationCalculatorTest {
	private final Parser parser = mock(Parser.class);
	private final static String MAPS = "MAPS";
	
	@Test
	void whenSeedToLocationIsOutsideRange_useNumeralValues() {
		final SeedToLocationCalculator seedToLocationCalculator = new SeedToLocationCalculator(this.parser);
		
		final Long finalLocationOf = seedToLocationCalculator.getFinalLocationOf(1L, MAPS);
		
		assertThat(finalLocationOf).isEqualTo(1L);
	}
	
	@Test
	void whenSeedToLocationIsInsideRange_useProvidedRoute() {
		when(this.parser.parse(MAPS)).thenReturn(List.of(List.of(new Route(98, 0, 2), new Route(52, 50, 48))));
		final SeedToLocationCalculator seedToLocationCalculator = new SeedToLocationCalculator(this.parser);
		
		final Long finalLocationOf = seedToLocationCalculator.getFinalLocationOf(1L, MAPS);
		
		verify(this.parser).parse(MAPS);
		assertThat(finalLocationOf).isEqualTo(99L);
	}
	
	@Test
	void whenMoreThanOneStepHasToBeConsidered_UseAllOfThem() {
		when(this.parser.parse(MAPS)).thenReturn(List.of(List.of(new Route(98, 0, 2), new Route(52, 50, 48)),
				List.of(new Route(0, 90, 10), new Route(52, 50, 48))));
		final SeedToLocationCalculator seedToLocationCalculator = new SeedToLocationCalculator(this.parser);
		
		final Long finalLocationOf = seedToLocationCalculator.getFinalLocationOf(1L, MAPS);
		
		verify(this.parser).parse(MAPS);
		assertThat(finalLocationOf).isEqualTo(9L);
	}
}