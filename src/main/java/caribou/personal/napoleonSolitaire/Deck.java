package caribou.personal.napoleonSolitaire;

import caribou.personal.napoleonSolitaire.card.Card;

public interface Deck {
	void shuffle();
	
	Card draw();
}
