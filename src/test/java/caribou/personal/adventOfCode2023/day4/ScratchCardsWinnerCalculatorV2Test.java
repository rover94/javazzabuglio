package caribou.personal.adventOfCode2023.day4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ScratchCardsWinnerCalculatorV2Test {
	private final Transformer transformer = mock(Transformer.class);
	private final ScratchCardsWinnerCalculatorV2 calculator = new ScratchCardsWinnerCalculatorV2(this.transformer);
	
	@Test
	void whenNoWinner_thenTheTotalNumberOfTicketsDoNotIncrease() {
		when(this.transformer.transform("INPUT")).thenReturn(new ScratchCard(List.of(), List.of()));
		
		final Integer calculate = this.calculator.calculate(List.of("INPUT", "INPUT"));
		
		assertThat(calculate).isEqualTo(2);
	}
	
	@Test
	void whenOneTicketWin_thenTheTotalNumberOfTicketsIncreaseByOne() {
		when(this.transformer.transform("INPUT"))
				.thenReturn(new ScratchCard(List.of(1, 2, 3), List.of(1, 2, 3)))
				.thenReturn(new ScratchCard(List.of(1, 2, 3), List.of(1, 2, 3)));
		
		final Integer calculate = this.calculator.calculate(List.of("INPUT", "INPUT"));
		
		assertThat(calculate).isEqualTo(3);
	}
	
	@Test
	void whenTwoTicketsWin_thenTheTotalNumberOfTicketsIncreaseByTwo() {
		when(this.transformer.transform("INPUT"))
				.thenReturn(new ScratchCard(List.of(1, 2, 3), List.of(1, 2, 3)))
				.thenReturn(new ScratchCard(List.of(1, 2, 3), List.of(1, 2, 3)))
				.thenReturn(new ScratchCard(List.of(1, 2, 3), List.of(1, 2, 3)));
		
		final Integer calculate = this.calculator.calculate(List.of("INPUT", "INPUT", "INPUT"));
		
		assertThat(calculate).isEqualTo(7);
	}
}