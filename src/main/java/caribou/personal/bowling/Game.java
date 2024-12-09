package caribou.personal.bowling;

import java.util.List;

public class Game {
	final List<Round> rounds;
	
	public Game(final List<Round> rounds) {
		this.rounds = rounds;
	}
	
	public int getScore() {
		return rounds.stream().map(round -> {
					if (isAStrike(round)) {
						return 10 + getNextRound(round) + getNextNextRound(round);
					}
					
			        if (itsASpare(round)) {
						return 15;
					}
					
					return round.firstRoll() + round.secondRoll();
				})
				.mapToInt(Integer::intValue)
				.sum();
	}
	
	private int getNextRound(final Round round) {
		return rounds.get(rounds.indexOf(round) + 1).firstRoll() + rounds.get(rounds.indexOf(round) + 1).secondRoll();
	}
	
	private int getNextNextRound(final Round round) {
		return rounds.get(rounds.indexOf(round) + 2).firstRoll() + rounds.get(rounds.indexOf(round) + 2).secondRoll();
	}
	
	private boolean isAStrike(final Round round) {
		return round.firstRoll() == 10;
	}
	
	private boolean itsASpare(final Round round) {
		return round.firstRoll() + round.secondRoll() == 10;
	}
}
