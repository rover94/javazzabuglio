package caribou.personal.napoleonSolitaire;

public class NapoleonSolitaireBoard implements Board {
	@Override
	public void putDownHiddenCard(Card card) {
	
	}
	
	@Override
	public Card putDown(Card card) {
		return null;
	}
	
	@Override
	public boolean isGameFinished() {
		return false;
	}
	
	@Override
	public boolean noMoreHiddenCards() {
		return false;
	}
}
