package caribou.personal.adventOfCode2023.day4;

import java.util.List;

public class ScratchCardsWinnerCalculator {
	private final Transformer transformer;
	
	public ScratchCardsWinnerCalculator(final Transformer transformer) {
		this.transformer = transformer;
	}
	
	public Integer calculate(final List<String> scratchCards) {
		return scratchCards.stream().map(this.transformer::transform)
				.map(card -> (int) Math.pow(2, getNumberIntersectingElements(card) - 1))
				.mapToInt(Integer::intValue)
				.sum();
	}
	
	private static int getNumberIntersectingElements(final ScratchCard card) {
		return card.numbers().stream().filter(number -> card.winningNumbers().contains(number)).toList().size();
	}
}
