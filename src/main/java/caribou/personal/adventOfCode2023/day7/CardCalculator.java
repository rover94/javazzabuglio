package caribou.personal.adventOfCode2023.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardCalculator {
	
	public Integer calculate(final String cards) {
		final List<HandAndBet> handsAndBets = this.getAsHandsAndBets(cards);
		List<HandAndBet> ordered = handsAndBets.stream().sorted().toList();
		Integer result = 0;
		for (int i = 0; i < ordered.size(); i++) {
			System.out.println(ordered.get(i).hand() + " " + i);
			result += ordered.get(i).bet() * (i + 1);
		}
		return result;
	}
	
	private List<HandAndBet> getAsHandsAndBets(final String cards) {
		return Arrays.stream(cards.split("\n"))
				.map(string -> {
					final String[] split = string.split(" ");
					return new HandAndBet(this.getCards(split), Integer.parseInt(split[1]));
				}).toList();
	}
	
	private List<String> getCards(final String[] split) {
		final List<String> carte = new ArrayList<>();
		for (int i = 0; i < split[0].length(); i++) {
			carte.add(String.valueOf(split[0].charAt(i)));
		}
		return carte;
	}
}
