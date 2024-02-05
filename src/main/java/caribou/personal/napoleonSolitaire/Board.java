package caribou.personal.napoleonSolitaire;

public interface Board {
	void put(Card card);
	
	void putToHiddenCards(Card draw);
	
	Card getNextHiddenCard();
	
	void putDown(Card card);
	
	boolean isGameFinished();
	
	boolean noMoreHiddenCards();
}
