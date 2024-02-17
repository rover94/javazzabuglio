package caribou.personal.adventOfCode2023.day2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CubeGameTest {
	private final CubeGame cubeGame = new CubeGame();
	
	@Test
	void aGameIsPossibleIfAllCubesAreLessOrEqualToTheDesiredOnes() {
		final List<String> games = List.of("Game 1: 3 blue, 4 red; 1 red, 3 green");
		
		final int result = this.cubeGame.evaluateGames(new BagConstraints(12, 13, 14), games);
		
		assertThat(result).isEqualTo(1);
	}
	
	@Test
	void whenMoreThanOneGameIsSuccessfullThenReturnSum() {
		final List<String> games = List.of("Game 1: 3 blue, 4 red; 1 red, 3 green", "Game 2: 3 blue, 4 red; 1 red, 3 green");
		
		final int result = this.cubeGame.evaluateGames(new BagConstraints(12, 13, 14), games);
		
		assertThat(result).isEqualTo(3);
	}
	
	@Test
	void aGameIsNotPossibleIfAnyDrawnCubesAreMoreThanTheDesiredOnes() {
		final List<String> games = List.of("Game 1: 3 blue, 4 red; 1 red, 3 green");
		
		final int result = this.cubeGame.evaluateGames(new BagConstraints(1, 10, 10), games);
		
		assertThat(result).isEqualTo(0);
	}
	
	@Test
	void getPowerReturnTheMinimunValuesOfAGameMultiplied() {
		final List<String> games = List.of("Game 1: 3 blue, 2 red; 2 green, 4 blue");
		
		final Long result = this.cubeGame.getPower(games);
		
		assertThat(result).isEqualTo(16L);
	}

	@Test
	void getPowerAddTogheterTwoGames() {
		final List<String> games = List.of("Game 1: 1 blue, 1 red; 1 red, 1 green", "Game 2: 1 blue, 1 red; 1 red, 1 green");

		final long result = this.cubeGame.getPower(games);

		assertThat(result).isEqualTo(2L);
	}

}