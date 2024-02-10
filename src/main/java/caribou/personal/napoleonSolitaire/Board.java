package caribou.personal.napoleonSolitaire;

import caribou.personal.napoleonSolitaire.card.Card;

public interface Board {
	void putDownHiddenCard(Card card);
	
	Card putDown(Card card);
	
	boolean isGameFinished();
	
	boolean gameWon();
}
