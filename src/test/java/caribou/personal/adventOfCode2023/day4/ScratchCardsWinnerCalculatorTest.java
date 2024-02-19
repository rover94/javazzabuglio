package caribou.personal.adventOfCode2023.day4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ScratchCardsWinnerCalculatorTest {
	private final Transformer transformer = mock(Transformer.class);
	private final ScratchCardsWinnerCalculator scratchCardsWinnerCalculator = new ScratchCardsWinnerCalculator(this.transformer);
	
	@Test
	void whenNoWinners_thenReturn0() {
		when(this.transformer.transform("INPUT")).thenReturn(new ScratchCard(List.of(), List.of()));
		
		final Integer calculate = this.scratchCardsWinnerCalculator.calculate(List.of("INPUT"));
		
		assertThat(calculate).isEqualTo(0);
	}
	
	@Test
	void whenThereIsAScratchCardWithOneWinner_thenReturnValue1() {
		when(this.transformer.transform("INPUT")).thenReturn(new ScratchCard(List.of(1, 2), List.of(1)));
		
		final Integer calculate = this.scratchCardsWinnerCalculator.calculate(List.of("INPUT"));
		
		assertThat(calculate).isEqualTo(1);
	}
	
	@Test
	void whenThereIsAScratchCardWithTwoWinningNumbers_thenReturnValue2() {
		when(this.transformer.transform("INPUT")).thenReturn(new ScratchCard(List.of(1, 2), List.of(1, 2)));
		
		final Integer calculate = this.scratchCardsWinnerCalculator.calculate(List.of("INPUT"));
		
		assertThat(calculate).isEqualTo(2);
	}
	
	@Test
	void whenThereAreTwoScratchCardsWithTwoWinningNumbers_thenReturnValue4() {
		when(this.transformer.transform("INPUT")).thenReturn(new ScratchCard(List.of(1, 2), List.of(1, 2)));
		
		final Integer calculate = this.scratchCardsWinnerCalculator.calculate(List.of("INPUT", "INPUT"));
		
		assertThat(calculate).isEqualTo(4);
	}
	
	@Test
	void whenThereAreTwoScratchCardsWithThreeWinningNumbers_thenReturnValue4() {
		when(this.transformer.transform("INPUT")).thenReturn(new ScratchCard(List.of(1, 2, 3), List.of(1, 2, 3)));
		
		final Integer calculate = this.scratchCardsWinnerCalculator.calculate(List.of("INPUT", "INPUT"));
		
		assertThat(calculate).isEqualTo(8);
	}
}