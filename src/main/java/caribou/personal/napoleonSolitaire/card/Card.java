package caribou.personal.napoleonSolitaire.card;

public record Card(Suits suits, CardValue cardValue) {
	@Override
	public String toString() {
		
		return suits.toString() + cardValue.toString();
	}
}
