package caribou.personal.adventOfCode2023.day9;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MirageParserTest {
	@Test
	void parserTest1() {
		final String s = """
				0 3 6 9
				1 2 3
				1 2 3
				""";
		
		final List<List<Integer>> parsed = new MirageParser().parse(s);
		
		assertThat(parsed).isEqualTo(List.of(List.of(0, 3, 6, 9), List.of(1, 2, 3), List.of(1, 2, 3)));
	}
}