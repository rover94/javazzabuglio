package caribou.personal.adventOfCode2023.day10;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

public class Point {
	private final int i;
	private final int j;
	
	public Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public int getI() {
		return this.i;
	}
	
	public int getJ() {
		return this.j;
	}
	
	@Override
	public boolean equals(final Object o) {
		return reflectionEquals(this, o);
	}
	
	@Override
	public int hashCode() {
		return reflectionHashCode(this);
	}
}
