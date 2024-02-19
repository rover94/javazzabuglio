package caribou.personal.adventOfCode2023.day4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ScratchCardTransformerTest {
	
	@Test
	void scratchCardIsTranformed() {
		final ScratchCardTransformer scratchCardTransformer = new ScratchCardTransformer();
		
		final ScratchCard scratchCard = scratchCardTransformer.transform("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");
		
		Assertions.assertThat(scratchCard.winningNumbers()).isEqualTo(List.of(41, 48, 83, 86, 17));
		Assertions.assertThat(scratchCard.numbers()).isEqualTo(List.of(83, 86, 6, 31, 17, 9, 48, 53));
	}
}