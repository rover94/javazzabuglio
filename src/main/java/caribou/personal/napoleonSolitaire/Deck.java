package caribou.personal.napoleonSolitaire;

import caribou.personal.napoleonSolitaire.card.Card;

import java.awt.*;

public interface Deck {
	void shuffle();
	
	Card draw();
}
