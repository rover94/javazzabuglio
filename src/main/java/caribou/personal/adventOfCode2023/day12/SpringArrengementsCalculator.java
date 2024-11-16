package caribou.personal.adventOfCode2023.day12;

import java.util.*;

public class SpringArrengementsCalculator {
	private static final Map<Input, Long> memoizationMap = new HashMap<>();
	
	
	private long countPermutations(String condition, List<Integer> groups) {
		Input input = new Input(condition, groups);
		if (memoizationMap.containsKey(input)) {
			return memoizationMap.get(input);
		}
		
		if (condition.isBlank()) {
			// We have processed the complete condition, so if there are no groups left we
			// have a valid permutation, otherwise a non-valid one.
			return groups.isEmpty() ? 1 : 0;
		}
		
		char firstChar = condition.charAt(0);
		long permutations = 0;
		if (firstChar == '.') {
			// Working spring, so just skip over it and continue.
			permutations = countPermutations(condition.substring(1), groups);
		} else if (firstChar == '?') {
			// Spring of unknown status, so count the permutations for both a working and a
			// damaged spring.
			permutations = countPermutations("." + condition.substring(1), groups)
					+ countPermutations("#" + condition.substring(1), groups);
		} else {
			// First character is #
			if (groups.size() == 0) {
				// No more groups but we still have a #, this is not valid.
				permutations = 0;
			} else {
				int nrDamaged = groups.get(0);
				// We want to include a group of nrDamaged springs, so the remaining length of
				// the condition should be at least the size of that group. Also, the next
				// nrDamaged springs should all be damaged (#) or unknown (?).
				if (nrDamaged <= condition.length()
						&& condition.chars().limit(nrDamaged).allMatch(c -> c == '#' || c == '?')) {
					List<Integer> newGroups = groups.subList(1, groups.size());
					if (nrDamaged == condition.length()) {
						// The remaining length of the condition is equal to the nr of damaged springs
						// in the group, so we are done if there are no remaining groups.
						permutations = newGroups.isEmpty() ? 1 : 0;
					} else if (condition.charAt(nrDamaged) == '.') {
						// We have just added a group of damaged springs (#) and the next spring is
						// operational, this is valid, so skip over that operational spring.
						permutations = countPermutations(condition.substring(nrDamaged + 1), newGroups);
					} else if (condition.charAt(nrDamaged) == '?') {
						// We have just added a group of damaged springs (#), so the next spring can
						// only be operational (.).
						permutations = countPermutations("." + condition.substring(nrDamaged + 1), newGroups);
					} else {
						// We have just added a group of damaged springs (#), but the next character is
						// also a damaged spring, this is not valid.
						permutations = 0;
					}
				} else {
					// Either size of the group is greater than the remaining length of the
					// condition or the next nrDamaged springs are not either damaged (#) or unknown
					// (?).
					permutations = 0;
				}
			}
		}
		memoizationMap.put(input, permutations);
		return permutations;
	}
	
	private String unfoldCondition(String condition, int times) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < times - 1; i++) {
			sb.append(condition);
			sb.append("?");
		}
		sb.append(condition);
		return sb.toString();
	}
	
	private List<Integer> unfoldGroups(List<Integer> groups, int times) {
		List<Integer> unfoldedGroups = new ArrayList<>();
		for (int i = 0; i < times; i++) {
			unfoldedGroups.addAll(groups);
		}
		return unfoldedGroups;
	}
	
	public long runPart2(final String input) {
		long max = 0;
		
		for (String line : input.split("\n")) {
			String[] parts = line.split(" ");
			String record = unfoldCondition(parts[0], 5);
			List<Integer> groups = unfoldGroups(Arrays.asList(parts[1].split(",")).stream().map(p -> Integer.valueOf(p))
					.toList(), 5);
			long permutations = countPermutations(record, groups);
			max += permutations;
		}
		
		return max;
	}
	
	public long runPart1(final String input) {
		long max = 0;
		for (String line : input.split("\n")) {
			String[] parts = line.split(" ");
			String record = parts[0];
			List<Integer> groups = Arrays.asList(parts[1].split(",")).stream().map(p -> Integer.valueOf(p)).toList();
			max += countPermutations(record, groups);
		}
		return max;
	}

}
