package caribou.personal.adventOfCode2023.day3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EngineGearRatioTest {
	
	@Test
	void testProvided() {
		final EngineGearRatio schematics = new EngineGearRatio();
		
		final Long result = schematics.getGearRatio(List.of(
				"467..114..",
				"...*......",
				"..35..633.",
				"......#...",
				"617*......",
				".....+.58.",
				"..592.....",
				"......755.",
				"...$.*....",
				".664.598.."
		));
		
		assertThat(result).isEqualTo(467835);
	}
}