package caribou.personal.adventOfCode2023.day9;

import java.util.ArrayList;
import java.util.List;

public class MirageMaintenance {
	private final MirageParser mirageParser;
	
	public MirageMaintenance() {
		mirageParser = new MirageParser();
	}
	
	public Integer calculate(final String input) {
		final List<List<Integer>> parse = this.mirageParser.parse(input);
		return parse.stream().map(this::calculateNext)
				.mapToInt(Integer::intValue)
				.sum();
	}
	
	private int calculateNext(final List<Integer> list) {
		if (allElemsAreZeros(list)) {
			return 0;
		} else {
			return list.get(list.size() - 1) + calculateNext(getNewList(list));
		}
	}
	
	
	private List<Integer> getNewList(final List<Integer> list) {
		final List<Integer> newList = new ArrayList<>();
		for (int i = 0; i < list.size() - 1; i++) {
			newList.add(list.get(i +1) -list.get(i) );
		}
		return newList;
	}
	
	private boolean allElemsAreZeros(final List<Integer> list) {
		return list.stream().allMatch(elem -> elem == 0);
	}
	
	public Integer calculateSecondStar(final String input) {
		final List<List<Integer>> parse = this.mirageParser.parse(input);
		return parse.stream().map(this::calculateNextSecondStar)
				.mapToInt(Integer::intValue)
				.sum();
	}
	
	private int calculateNextSecondStar(final List<Integer> list) {
		if (allElemsAreZeros(list)) {
			return 0;
		} else {
			return list.get(0) - calculateNextSecondStar(getNewList(list));
		}
	}
}
