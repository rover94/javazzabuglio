package caribou.personal.adventOfCode2023.day4;

import java.util.Arrays;
import java.util.List;

public class ScratchCardTransformer implements Transformer {
	@Override
	public ScratchCard transform(final String scratcCardAsString) {
		final String numbersAndWinningNumbers = scratcCardAsString.split(": ")[1];
		return new ScratchCard(getWinningNumbers(numbersAndWinningNumbers.split(" \\| ")[0]), getWinningNumbers(numbersAndWinningNumbers.split(" \\| ")[1]));
	}
	
	private static List<Integer> getWinningNumbers(final String numbers) {
		return Arrays.stream(numbers.split(" ")).filter(i -> !i.isBlank()).map(Integer::parseInt).toList();
	}
	
}
