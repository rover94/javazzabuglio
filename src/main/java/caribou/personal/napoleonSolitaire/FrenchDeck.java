package caribou.personal.napoleonSolitaire;

import caribou.personal.napoleonSolitaire.card.Card;
import caribou.personal.napoleonSolitaire.card.CardValue;
import caribou.personal.napoleonSolitaire.card.Suits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrenchDeck implements Deck {
	private final List<Card> deck = new ArrayList<>();
	
	public FrenchDeck() {
		for (Suits suit: Suits.values()){
			for (CardValue value : CardValue.values()) {
				deck.add(new Card(suit, value));
			}
		}
	}
	
	@Override
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	@Override
	public Card draw() {
		return deck.remove(0);
	}
}
