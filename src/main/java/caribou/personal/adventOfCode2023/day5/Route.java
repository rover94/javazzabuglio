package caribou.personal.adventOfCode2023.day5;

import java.util.Objects;

public class Route {
	private final long destinationRangeStart;
	private final long sourceRangeStart;
	private final long rangeLenght;

	public Route(final long destinationRangeStart, final long sourceRangeStart, final long rangeLenght) {
		this.destinationRangeStart = destinationRangeStart;
		this.sourceRangeStart = sourceRangeStart;
		this.rangeLenght = rangeLenght;
	}
	
	public boolean contains(final Long nextStep) {
		return nextStep >= this.sourceRangeStart && nextStep < this.sourceRangeStart + this.rangeLenght;
	}
	
	public long getNextStep(final long nextStep) {
		return nextStep - this.sourceRangeStart + this.destinationRangeStart;
	}
	
	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final Route route = (Route) o;
		return this.destinationRangeStart == route.destinationRangeStart && this.sourceRangeStart == route.sourceRangeStart && this.rangeLenght == route.rangeLenght;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.destinationRangeStart, this.sourceRangeStart, this.rangeLenght);
	}
	
	@Override
	public String toString() {
		return "Route{" +
				"destinationRangeStart=" + this.destinationRangeStart +
				", sourceRangeStart=" + this.sourceRangeStart +
				", rangeLenght=" + this.rangeLenght +
				'}';
	}
}
