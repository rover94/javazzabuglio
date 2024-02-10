package caribou.personal.napoleonSolitaire;

import caribou.personal.napoleonSolitaire.card.Card;

public interface Stash {
	Card get();
	
	void add(Card card);
}
