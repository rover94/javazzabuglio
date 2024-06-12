package caribou.personal.adventOfCode2023.day7;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public record HandAndBet(List<String> hand, Integer bet) implements Comparable<HandAndBet> {
	@Override
	public int compareTo(final HandAndBet otherBet) {
		final Integer otherType = otherBet.getHandType();
		final Integer myType = this.getHandType();
		if (myType > otherType) {
			return 1;
		} else if (myType < otherType) {
			return -1;
		} else {
			return this.calculateHighCard(this, otherBet, 0);
		}
	}
	
	private int calculateHighCard(final HandAndBet handAndBet, final HandAndBet otherBet, final int i) {
		if (handAndBet.hand.get(i).equals(otherBet.hand.get(i))) {
			return this.calculateHighCard(handAndBet, otherBet, i + 1);
		}
		if (this.isBiggerThan(handAndBet.hand.get(i), otherBet.hand.get(i))) {
			return 1;
		} else {
			return -1;
		}
	}
	
	private boolean isBiggerThan(final String thiss, final String other) {
		return Integer.parseInt(thiss.replace("A", "14").replace("K", "13").replace("Q", "12").replace("T", "10").replace("J", "1")) >
				Integer.parseInt(other.replace("A", "14").replace("K", "13").replace("Q", "12").replace("T", "10").replace("J", "1"));
	}
	
	private Integer getHandType() {
		if (this.isFiveOfAKind()) {
			return 6;
		}
		if (this.isAPoker()) {
			return 5;
		}
		if (this.isAFull()) {
			return 4;
		}
		if (this.isATris()) {
			return 3;
		}
		if (this.isDoublePair()) {
			return 2;
		}
		if (this.isPair()) {
			return 1;
		}
		return 0;
	}
	
	private boolean isDoublePair() {
		return this.collect().values().stream().filter(value -> value.size() == 2).toList().size() == 2;
	}
	
	private boolean isPair() {
		return this.collect().values().stream().anyMatch(value -> value.size() == 2);
	}
	
	private boolean isATris() {
		return this.collect().values().stream().anyMatch(value -> value.size() == 3);
	}
	
	private boolean isAFull() {
		return this.collect().values().stream().anyMatch(value -> value.size() == 3) &&
				this.collectbasic().values().stream().anyMatch(value -> value.size() == 2);
	}
	
	private boolean isAPoker() {
		return this.collect().values().stream().anyMatch(value -> value.size() == 4);
	}
	
	private boolean isFiveOfAKind() {
		return this.collect().values().stream().anyMatch(value -> value.size() == 5);
	}
	
	private Map<String, List<String>> collect() {
		final Map<String, List<String>> collect = this.hand.stream().collect(Collectors.groupingBy(e -> e));
		for (int i = 0; i < this.hand.stream().filter("J"::equals).toList().size(); i++) {
			collect.entrySet().stream()
					.filter(entry -> !"J".equals(entry.getKey()))
					.max(Comparator.comparingInt(v -> v.getValue().size()))
					.ifPresent(stringListEntry -> stringListEntry.getValue().add("J"));
		}
		return collect;
	}
	
	private Map<String, List<String>> collectbasic() {
		return this.hand.stream().filter(anObject -> !"J".equals(anObject)).collect(Collectors.groupingBy(e -> e));
	}
}
