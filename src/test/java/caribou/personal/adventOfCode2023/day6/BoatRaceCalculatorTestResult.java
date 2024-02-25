package caribou.personal.adventOfCode2023.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoatRaceCalculatorTestResult {
	@Test
	void smallInput() {
		Long result = new BoatRaceCalculator().calculator("""
				Time:      7  15   30
				Distance:  9  40  200
				""");
		
		System.out.println(result);
	}
	
	@Test
	void bigInput() {
		Long result = new BoatRaceCalculator().calculator("""
				Time:        41     66     72     66
				Distance:   244   1047   1228   1040
				""");
		
		System.out.println(result);
	}
	
	@Test
	void smallInputPartTwo() {
		Long result = new BoatRaceCalculator().calculator("""
				Time:      71530
				Distance:  940200
				""");
		
		System.out.println(result);
	}
	
	@Test
	void bigInputPartTwo() {
		Long result = new BoatRaceCalculator().calculator("""
				Time:        41667266
				Distance:   244104712281040
				""");
		
		System.out.println(result);
	}
}