package caribou.personal.napoleonSolitaire;

public interface Board {
	void putDownHiddenCard(Card card);
	
	Card putDown(Card card);
	
	boolean isGameFinished();
	
	boolean noMoreHiddenCards();
}
