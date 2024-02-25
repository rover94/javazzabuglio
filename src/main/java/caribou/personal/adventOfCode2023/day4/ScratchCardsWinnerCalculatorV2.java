package caribou.personal.adventOfCode2023.day4;

import java.util.List;

public class ScratchCardsWinnerCalculatorV2 {
	private final Transformer transformer;
	
	public ScratchCardsWinnerCalculatorV2(final Transformer transformer) {
		this.transformer = transformer;
	}
	
	public Integer calculate(final List<String> scratchCards) {
		final List<ScratchCard> scratchCardList = scratchCards.stream().map(this.transformer::transform).toList();
		for (int i = 0; i < scratchCardList.size(); i++) {
			final ScratchCard scratchCard = scratchCardList.get(i);
			final int numberIntersectingElements = this.getNumberIntersectingElements(scratchCard);
			for (int j = 1; j <= numberIntersectingElements; j++) {
				if (i + j < scratchCardList.size()) {
					scratchCardList.get(i + j).increaseCardinality(scratchCard.getCardinality());
				}
			}
		}
		
		return this.getScratchCardSum(scratchCardList);
	}
	
	private int getScratchCardSum(final List<ScratchCard> scratchCardList) {
		return scratchCardList.stream()
				.mapToInt(ScratchCard::getCardinality)
				.sum();
	}
	
	private int getNumberIntersectingElements(final ScratchCard card) {
		return card.numbers().stream().filter(number -> card.winningNumbers().contains(number)).toList().size();
	}
}
