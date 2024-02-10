package caribou.personal.napoleonSolitaire.card;

public enum Suits {
	DIAMOND("D"),
	CLUB("C"),
	HEART("H"),
	SPADE("S");
	
	private final String suit;
	
	Suits(String suit) {
		this.suit = suit;
	}
	
	@Override
	public String toString() {
		return suit;
	}
}
