package caribou.personal.adventOfCode2023.day10;

import java.util.List;

public class MonsterLoop {
	private final MonsterParser monsterParser;
	
	public MonsterLoop() {
		this.monsterParser = new MonsterParser();
	}
	
	
	public Long calculateEnclosedTiles(final String input) {
		final List<List<String>> parse = monsterParser.parse(input);
		
		Point previousPoint = getStartingPoint(parse);
		final Point startingPoint = getStartingPoint(parse);
		Point currentPoint = new Point(startingPoint.getI(), startingPoint.getJ() - 1);
		
		Long counter = 1L;
		while (!doesParseContainsCharacter(parse, currentPoint, "S")) {
			final Point nextPoint = getNextPoint(parse, previousPoint, currentPoint);
			setToParse(parse, currentPoint);
			previousPoint = currentPoint;
			currentPoint = nextPoint;
			counter++;
		}
		
		
		for (List<String> strings : parse) {
			System.out.println(strings);
		}
		
		return counter;
	}
	
	private static void setToParse(List<List<String>> parse, Point currentPoint) {
		if (parse.get(currentPoint.getI()).get(currentPoint.getJ()).equals("|")) {
			parse.get(currentPoint.getI()).set(currentPoint.getJ(), "X");
			return;
		}
		parse.get(currentPoint.getI()).set(currentPoint.getJ(), "Y");
	}
	
	public Long calculate(final String input) {
		final List<List<String>> parse = monsterParser.parse(input);
		
		final Point startingPoint = getStartingPoint(parse);
		
		Point previousPoint = getStartingPoint(parse);
		Point currentPoint = new Point(startingPoint.getI(), startingPoint.getJ() - 1);
		
		Long counter = 1L;
		while (!doesParseContainsCharacter(parse, currentPoint, "S")) {
			final Point nextPoint = getNextPoint(parse, previousPoint, currentPoint);
			previousPoint = currentPoint;
			currentPoint = nextPoint;
			counter++;
		}
		
		return counter;
	}
	
	private Point getNextPoint(final List<List<String>> parse,
							   final Point previousPoint,
							   final Point currentPoint) {
		
		if (doesParseContainsCharacter(parse, currentPoint, "|")) {
			if (previousPoint.getI() == currentPoint.getI() - 1) {
				return new Point(currentPoint.getI() + 1, currentPoint.getJ());
			}
			return new Point(currentPoint.getI() - 1, currentPoint.getJ());
		}
		if (doesParseContainsCharacter(parse, currentPoint, "J")) {
			if (previousPoint.getJ() == currentPoint.getJ() -1) {
				return new Point(currentPoint.getI() - 1, currentPoint.getJ());
			}
			return new Point(currentPoint.getI(), currentPoint.getJ() - 1);
		}
		
		if (doesParseContainsCharacter(parse, currentPoint, "-")) {
			if (previousPoint.getJ() == currentPoint.getJ() + 1) {
				return new Point(currentPoint.getI(), currentPoint.getJ() - 1);
			}
			return new Point(currentPoint.getI(), currentPoint.getJ() + 1);
		}
		
		if (doesParseContainsCharacter(parse, currentPoint, "L")) {
			if (previousPoint.getJ() == currentPoint.getJ() + 1) {
				return new Point(currentPoint.getI() - 1, currentPoint.getJ());
			}
			return new Point(currentPoint.getI(), currentPoint.getJ() + 1);
		}
		
		if (doesParseContainsCharacter(parse, currentPoint, "7")) {
			if (previousPoint.getJ() == currentPoint.getJ() - 1) {
				return new Point(currentPoint.getI() + 1, currentPoint.getJ());
			}
			return new Point(currentPoint.getI(), currentPoint.getJ() - 1);
		}
		
		if (previousPoint.getJ() == currentPoint.getJ() + 1) {
			return new Point(currentPoint.getI() + 1, currentPoint.getJ());
		}
		return new Point(currentPoint.getI(), currentPoint.getJ() + 1);
		
	}
	
	private boolean doesParseContainsCharacter(final List<List<String>> parse,
											   final Point currentPoint,
											   final String character) {
		return character.equals(parse.get(currentPoint.getI()).get(currentPoint.getJ()));
	}
	
	private Point getStartingPoint(final List<List<String>> parse) {
		for (int i = 0; i < parse.size(); i++) {
			for (int j = 0; j < parse.get(i).size(); j++) {
				if ("S".equals(parse.get(i).get(j))) {
					return new Point(i, j);
				}
			}
		}
		throw new RuntimeException();
	}
}
