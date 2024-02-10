package caribou.personal.napoleonSolitaire.card;

public enum CardValue {
	ACE("A"),
	TWO("2"),
	THREE("3"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGHT("8"),
	NINE("9"),
	TEN("T"),
	JACK("J"),
	QUEEN("Q"),
	KING("K");
	
	private final String value;
	
	CardValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
