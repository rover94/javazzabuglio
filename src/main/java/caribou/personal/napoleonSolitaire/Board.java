package caribou.personal.napoleonSolitaire;

public interface Board {
	void putDownHiddenCard(Card card);
	
	void putDown(Card card);
	
	boolean isGameFinished();
	
	boolean noMoreHiddenCards();
}
