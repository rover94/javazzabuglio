package caribou.personal.adventOfCode2023.day2;

import java.util.HashMap;
import java.util.List;

public class CubeGame {
	public int evaluateGames(BagConstraints bagConstraints, List<String> games) {
		return games.stream().filter(game -> {
					final String draws = game.split(": ")[1];
					for (final String draw : draws.split("; ")) {
						for (final String dices : draw.split(", ")) {
							final String[] dice = dices.split(" ");
							if ("green".equals(dice[1]) && bagConstraints.getGreen() < Integer.parseInt(dice[0])) {
								return false;
							}
							if ("red".equals(dice[1]) && bagConstraints.getRed() < Integer.parseInt(dice[0])) {
								return false;
							}
							if ("blue".equals(dice[1]) && bagConstraints.getBlue() < Integer.parseInt(dice[0])) {
								return false;
							}
						}
					}
					return true;
				}).map(game -> game.split(": ")[0].split(" ")[1])
				.map(Integer::valueOf)
				.mapToInt(Integer::intValue)
				.sum();
	}
	
	public Long getPower(List<String> games) {
		return games.stream().map(game -> {
					final HashMap<String, Integer> map = new HashMap<>();
					final String draws = game.split(": ")[1];
					for (final String draw : draws.split("; ")) {
						for (final String dices : draw.split(", ")) {
							final String[] dice = dices.split(" ");
							if (!map.containsKey(dice[1]) || map.get(dice[1]) < Integer.parseInt(dice[0])) {
								map.put(dice[1], Integer.parseInt(dice[0]));
							}
						}
					}
					return map.get("green") * map.get("blue") * map.get("red");
				})
				.mapToLong(Long::valueOf)
				.sum();
	}
}
