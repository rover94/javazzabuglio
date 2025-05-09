package caribou.personal.gameOfLife;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
	private List<List<Integer>> input;
	
	public GameOfLife(List<List<Integer>> input) {
		this.input = input;
	}
	
	public void nextIteration() {
		List<List<Integer>> output=copyInput();
		for (int row = 0; row < input.size(); row++) {
			for (int column = 0; column < input.get(row).size(); column++) {
				if (input.get(row).get(column) == 1) {
					final int numberOfLiveNeighbours = getNumberOfLiveNeighbours(row, column);
					System.out.println(numberOfLiveNeighbours);
					if (numberOfLiveNeighbours < 2 || numberOfLiveNeighbours > 4) {
						output.get(row).set(column, 0);
					}
				}
			}
		}
		
		input = output;
	}
	
	private List<List<Integer>> copyInput() {
		final List<List<Integer>> output = new ArrayList<>();
		for (final List<Integer> integers : input) {
			final List<Integer> columnList = new ArrayList<>(integers);
			output.add(columnList);
		}
		return output;
	}
	
	private int getNumberOfLiveNeighbours(final int row, final int column) {
		int counter = 0;
		if (row - 1 >= 0 && column - 1 >= 0 && input.get(row - 1).get(column - 1) == 1) {
			counter++;
		}
		
		if (row - 1 >= 0 && input.get(row - 1).get(column) == 1) {
			counter++;
		}
		
		if (row - 1 >= 0 && column + 1 < input.get(row).size() && input.get(row - 1).get(column + 1) == 1) {
			counter++;
		}
		
		
		if (column - 1 >= 0 && input.get(row).get(column - 1) == 1) {
			counter++;
		}
		
		if (column + 1 < input.get(row).size() && input.get(row).get(column + 1) == 1) {
			counter++;
		}
		
		if (row + 1 < input.size() && column - 1 > 0 && input.get(row + 1).get(column - 1) == 1) {
			counter++;
		}
		
		if (row+1 < input.size() && column + 1 < input.get(row).size() && input.get(row+1).get(column + 1) == 1) {
			counter++;
		}
		
		if (row + 1 < input.size() && column + 1 < input.get(row).size() && input.get(row + 1).get(column + 1) == 1) {
			counter++;
		}
		
		return counter;
	}
	
	public List<List<Integer>> getBoard() {
		return input;
	}
}
