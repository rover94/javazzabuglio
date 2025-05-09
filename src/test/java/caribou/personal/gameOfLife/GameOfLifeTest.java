package caribou.personal.gameOfLife;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameOfLifeTest {
	@Test
	void whenALiveCellHasLessThenTwoNeighboursItDies() {
		List<List<Integer>> input = List.of(List.of(0, 0, 0, 0),
				List.of(0, 1, 0, 0),
				List.of(0, 1, 0, 0),
				List.of(0, 0, 0, 0));
		
		final GameOfLife gameOfLife = new GameOfLife(input);
		gameOfLife.nextIteration();
		
		assertThat(gameOfLife.getBoard().get(1).get(1)).isEqualTo(0);
		assertThat(gameOfLife.getBoard().get(2).get(1)).isEqualTo(0);
	}
	
	@Test
	void whenALiveCellHasMoreThenFourNeighboursItDies() {
		List<List<Integer>> input = List.of(
				List.of(0, 0, 0, 0),
				List.of(1, 1, 1, 0),
				List.of(1, 1, 1, 0),
				List.of(0, 0, 0, 0));
		
		final GameOfLife gameOfLife = new GameOfLife(input);
		gameOfLife.nextIteration();
		
		assertThat(gameOfLife.getBoard().get(2).get(1)).isEqualTo(0);
	}
	
	// if a live cell has more than four it dies
	
	// if a live cell has two or three neighbours it stays alive
	
	// if a dead cell has three live neighbours it becomes alive
}