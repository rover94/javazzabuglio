package caribou.personal.adventOfCode2023.day1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CoordinateReaderTest {
	
	@Test
	void theCoordinateIsComposedFromTheFirstDigitAndFromTheLastDigitOfTheString() {
		final CoordinateReader coordinateReader = new CoordinateReader();
		
		final String coordinate = coordinateReader.getCoordinate(List.of("ab2cd3fd4d"));
		
		Assertions.assertThat(coordinate).isEqualTo("24");
	}
	
	@Test
	void whenTheStringOnlyHaveOneDigitThenIsTheFirstAndLastDigit() {
		final CoordinateReader coordinateReader = new CoordinateReader();
		
		final String coordinate = coordinateReader.getCoordinate(List.of("ab4d"));
		
		Assertions.assertThat(coordinate).isEqualTo("44");
	}
	
	@Test
	void whenTheEncriptedCoordinateHaveMoreThanOneLineThenTheResultIsSummed() {
		final CoordinateReader coordinateReader = new CoordinateReader();
		
		final String coordinate = coordinateReader.getCoordinate(List.of("ab4d", "abc5dssf432224kj33j36"));
		
		Assertions.assertThat(coordinate).isEqualTo("100");
	}
}