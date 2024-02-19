package caribou.personal.adventOfCode2023.day3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EngineSchematicsTest {
	@Test
	void whenASchematicHaveSymbolsOnSameLineThenTheResultingNumberIsPartOfTheSchematics() {
		final EngineSchematics schematics = new EngineSchematics();
		
		final Integer result = schematics.getPartNumberSum(List.of("......", "..12*."));
		
		assertThat(result).isEqualTo(12);
	}
	
	@Test
	void whenASchematicHaveSymbolsOnUpperLineThenTheResultingNumberIsPartOfTheSchematics() {
		final EngineSchematics schematics = new EngineSchematics();
		
		final Integer result = schematics.getPartNumberSum(List.of("..*...", "..12.."));
		
		assertThat(result).isEqualTo(12);
	}
	
	@Test
	void whenMoreThanOnenumberIsValidThenTheyAreSummed() {
		final EngineSchematics schematics = new EngineSchematics();
		
		final Integer result = schematics.getPartNumberSum(List.of(".3*...", "..12.."));
		
		assertThat(result).isEqualTo(15);
	}
	
	@Test
	void testProvided() {
		final EngineSchematics schematics = new EngineSchematics();
		
		final Integer result = schematics.getPartNumberSum(List.of(
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
		
		assertThat(result).isEqualTo(4361);
	}
}