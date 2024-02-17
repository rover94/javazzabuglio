package caribou.personal.adventOfCode2023.day2;

public class BagConstraints {
	private final int red;
	private final int green;
	private final int blue;
	
	public BagConstraints(final int red, final int green, final int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public int getRed() {
		return this.red;
	}
	
	public int getGreen() {
		return this.green;
	}
	
	public int getBlue() {
		return this.blue;
	}
}
