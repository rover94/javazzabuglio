package caribou.personal.adventOfCode2023.day8;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class StepCalculator {
	private final StepParser stepParser;
	
	public StepCalculator() {
		this.stepParser = new StepParser();
	}
	
	public int calculateSteps(final String input, final String directions) {
		String currentValue = "RHA";
		final Map<String, Pair<String, String>> parse = this.stepParser.parse(input);
		final String[] split = directions.split("");
		int i = 0;
		while (!currentValue.endsWith("Z")) {
			currentValue = nextStep(split, i, currentValue, parse);
			i++;
		}
		
		return i;
	}
	
	public Long calculateStepsV2(final String input, final String directions) {
		
		final Map<String, Pair<String, String>> parse = this.stepParser.parse(input);
		final List<String> currentPoints = new ArrayList<>();
		currentPoints.add("AAA");
		currentPoints.add("RHA");
		currentPoints.add("NBA");
		currentPoints.add("MSA");
		currentPoints.add("PKA");
		currentPoints.add("CDA");
		
		final String[] split = directions.split("");
		Long counter = 0L;
		int i = 0;
		while (this.isFinished(currentPoints)) {
			for (int currentPointIndex = 0; currentPointIndex < currentPoints.size(); currentPointIndex++) {
				currentPoints.set(currentPointIndex, this.nextStep(split, i, currentPoints.get(currentPointIndex), parse));
			}
			i++;
			if (i / split.length >= 1) {
				i = i - split.length;
			}
			if (currentPoints.get(0).endsWith("Z")) {
				System.out.println("Value i: " + i + " counter: " + counter + " point: 0");
			}
			if (currentPoints.get(1).endsWith("Z")) {
				System.out.println("Value i: " + i + " counter: " + counter + " point: 1");
			}
			if (currentPoints.get(2).endsWith("Z")) {
				System.out.println("Value i: " + i + " counter: " + counter + " point: 2");
			}
			if (currentPoints.get(3).endsWith("Z")) {
				System.out.println("Value i: " + i + " counter: " + counter + " point: 3");
			}
			if (currentPoints.get(4).endsWith("Z")) {
				System.out.println("Value i: " + i + " counter: " + counter + " point: 4");
			}
			if (currentPoints.get(5).endsWith("Z")) {
				System.out.println("Value i: " + i + " counter: " + counter + " point: 5");
			}
			counter++;
		}
		
		return counter;
	}
	
	private boolean isFinished(final List<String> initial) {
		return !initial.stream().allMatch(i -> i.endsWith("Z"));
	}
	
	private String nextStep(final String[] split, final int i, final String currentPoint, final Map<String, Pair<String, String>> parse) {
		if (Objects.equals(split[i % split.length], "R")) {
			return parse.get(currentPoint).getRight();
		}
		return parse.get(currentPoint).getLeft();
	}
}
