package caribou.personal.adventOfCode2023.day4;

import java.util.List;
import java.util.Objects;

public final class ScratchCard {
	private final List<Integer> winningNumbers;
	private final List<Integer> numbers;
	private int cardinality;
	
	public ScratchCard(final List<Integer> winningNumbers, final List<Integer> numbers) {
		this.winningNumbers = winningNumbers;
		this.numbers = numbers;
		this.cardinality = 1;
	}
	
	public List<Integer> winningNumbers() {
		return this.winningNumbers;
	}
	
	public List<Integer> numbers() {
		return this.numbers;
	}
	
	public void increaseCardinality(final int quantity) {
		this.cardinality += quantity;
	}
	
	public int getCardinality() {
		return this.cardinality;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		var that = (ScratchCard) obj;
		return Objects.equals(this.winningNumbers, that.winningNumbers) &&
				Objects.equals(this.numbers, that.numbers);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(winningNumbers, numbers);
	}
	
	@Override
	public String toString() {
		return "ScratchCard[" +
				"winningNumbers=" + winningNumbers + ", " +
				"numbers=" + numbers + ']';
	}
}
