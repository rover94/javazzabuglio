package caribou.personal.adventOfCode2023.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class SymbolCoordinates {
	private final int i;
	private final int j;
	private final List<Integer> neighbours;
	
	public SymbolCoordinates(int i, int j) {
		this.i = i;
		this.j = j;
		this.neighbours = new ArrayList<>();
	}
	
	public int i() {
		return i;
	}
	
	public int j() {
		return j;
	}
	
	public List<Integer> neighbours() {
		return neighbours;
	}
	
	public void addNeighbour(final Integer neighbour) {
		this.neighbours.add(neighbour);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		var that = (SymbolCoordinates) obj;
		return this.i == that.i &&
				this.j == that.j;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(i, j, neighbours);
	}
	
	@Override
	public String toString() {
		return "SymbolCoordinates[" +
				"i=" + i + ", " +
				"j=" + j + ", " +
				"neighbours=" + neighbours + ']';
	}
	
}
