package caribou.personal.napoleonSolitaire;

import java.util.ArrayList;
import java.util.List;

public class Solitaire {
	private final Deck deck;
	private List<Card> hidden;
	private Table table;
	
	public Solitaire(Deck deck) {
		this.deck = deck;
		hidden = new ArrayList<>();
	}
	
	public void initGame() {
		this.deck.shuffle();
		
		for(int i = 0; i < 4; i++) {
			hidden.add(this.deck.draw());
		}
		for(int i = 0; i < 48; i++) {
			Card card = this.deck.draw();
			table.put(card);
		}
	}
	
	public Card getHiddenCard() {
		if (hidden.isEmpty()) {
			return null;
		}
		
		Card card = hidden.get(0);
		hidden.remove(0);
		return card;
	}
	
	public Card putCardOnLine(Card card, Integer line) {
		return null;
	}
}
