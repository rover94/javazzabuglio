package caribou.personal.adventOfCode2023.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoatRaceCalculator {
	public Long calculator(final String timesAndRecords) {
		return this.calculator(this.getAsTimeAndRecordList(timesAndRecords));
	}
	
	private Long calculator(final List<TimeAndRecord> timesAndRecords) {
		return timesAndRecords.stream().map(timeAndRecord -> {
			long counter = 0;
			for (long i = 1; i < timeAndRecord.time(); i++) {
				if (this.getDistanceFor(i, timeAndRecord.time()) > timeAndRecord.record()) {
					counter++;
				}
			}
			return counter;
		}).reduce(1L, (a, b) -> a * b);
	}
	
	private Long getDistanceFor(final Long pushingTime, final Long totalTime) {
		return (totalTime - pushingTime) * pushingTime;
	}
	
	private List<TimeAndRecord> getAsTimeAndRecordList(final String timesAndRecords) {
		final List<String> times = this.getTimes(timesAndRecords);
		final List<String> distances = this.getDistances(timesAndRecords);
		final List<TimeAndRecord> timesAndRecordsList = new ArrayList<>();
		for (int i = 0; i < times.size(); i++) {
			timesAndRecordsList.add(new TimeAndRecord(Long.valueOf(times.get(i)), Long.valueOf(distances.get(i))));
		}
		return timesAndRecordsList;
	}
	
	private List<String> getDistances(final String timesAndRecords) {
		final String distance = timesAndRecords.split("\n")[1].split(":")[1];
		return Arrays.stream(distance.split(" ")).filter(s -> !s.isBlank()).toList();
	}
	
	private List<String> getTimes(final String timesAndRecords) {
		final String time = timesAndRecords.split("\n")[0].split(":")[1];
		return Arrays.stream(time.split(" ")).filter(s -> !s.isBlank()).toList();
	}
}
