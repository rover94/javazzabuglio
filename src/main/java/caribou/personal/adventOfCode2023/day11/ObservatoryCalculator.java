package caribou.personal.adventOfCode2023.day11;

import caribou.personal.adventOfCode2023.day10.Point;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class ObservatoryCalculator {
	private final ObservatoryParser parser;
	private final ObservatoryExpander expander;
	
	public ObservatoryCalculator() {
		parser = new ObservatoryParser();
		expander = new ObservatoryExpander();
	}
	
	public Long calculateExpansion(final String input) {
		final List<List<String>> parsedStars = parser.parse(input);
		final List<List<String>> expandedUniverse = expander.expandUniverse(parsedStars);
		final List<Point> allGalaxies = getAllGalaxies(expandedUniverse);
		
		expandedUniverse.forEach(System.out::println);
		return calculateAllDistancesAndSum(allGalaxies, expandedUniverse);
	}
	
	private Long calculateAllDistancesAndSum(final List<Point> allGalaxies, final List<List<String>> expandedUniverse) {
		Long result = 0L;
		for (int i = 0; i < allGalaxies.size(); i++) {
			for (int j = i + 1; j < allGalaxies.size(); j++) {
				result +=
						abs(allGalaxies.get(i).getJ() - allGalaxies.get(j).getJ()) +
						abs(allGalaxies.get(i).getI() - allGalaxies.get(j).getI());
				result += getPointsFromPointAToPointB(allGalaxies.get(i), allGalaxies.get(j)).stream()
						.filter(point -> expandedUniverse.get(point.getI()).get(point.getJ()).contains("x")).count()
				* 999999;
			}
		}
		return result;
	}
	
	private List<Point> getPointsFromPointAToPointB(final Point pointA, final Point pointB) {
		final List<Point> result = new ArrayList<>();
		if (pointA.getI() > pointB.getI()) {
			for (int i = pointB.getI(); i < pointA.getI(); i++) {
				result.add(new Point(i, pointA.getJ()));
			}
		}else {
			for (int i = pointA.getI(); i < pointB.getI(); i++) {
				result.add(new Point(i, pointA.getJ()));
			}
		}
		
		if (pointA.getJ() > pointB.getJ()) {
			for (int i = pointB.getJ(); i < pointA.getJ(); i++) {
				result.add(new Point(pointA.getI(), i));
			}
		}else {
			for (int i = pointA.getJ(); i < pointB.getJ(); i++) {
				result.add(new Point(pointA.getI(), i));
			}
		}
		return result;
		
	}
	
	private List<Point> getAllGalaxies(final List<List<String>> expandedUniverse) {
		final List<Point> result = new ArrayList<>();
		for (int i = 0; i < expandedUniverse.size(); i++) {
			for (int j = 0; j < expandedUniverse.get(i).size(); j++) {
				if ("#".equals(expandedUniverse.get(i).get(j))) {
					result.add(new Point(i, j));
				}
			}
		}
		return result;
	}
}
