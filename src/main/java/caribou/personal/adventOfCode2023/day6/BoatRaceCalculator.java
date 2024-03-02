package caribou.personal.adventOfCode2023.day6;

import java.util.List;

public class BoatRaceCalculator {
	private final TimeAndRecordParser parser;
	
	public BoatRaceCalculator() {
		this.parser = new TimeAndRecordParser();
	}
	
	public Long calculator(final String timesAndRecords) {
		final List<TimeAndRecord> timeAndRecordList = this.parser.getAsTimeAndRecordList(timesAndRecords);
		return timeAndRecordList.stream().map(this::getNumberOfRecordBreakingCombinations).reduce(1L, (a, b) -> a * b);
	}
	
	private long getNumberOfRecordBreakingCombinations(final TimeAndRecord timeAndRecord) {
		long counter = 0;
		for (long i = 1; i < timeAndRecord.time(); i++) {
			if (this.getDistanceFor(i, timeAndRecord.time()) > timeAndRecord.record()) {
				counter++;
			}
		}
		return counter;
	}
	
	private Long getDistanceFor(final Long pushingTime, final Long totalTime) {
		return (totalTime - pushingTime) * pushingTime;
	}
}
