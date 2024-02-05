package caribou.personal.napoleonSolitaire;

import java.util.ArrayList;
import java.util.List;

public class Solitaire {
	private final Deck deck;
	private final Board board;
	
	public Solitaire(Deck deck, Board board) {
		this.deck = deck;
		this.board = board;
	}
	
	public void initGame() {
		this.deck.shuffle();
		
		for(int i = 0; i < 4; i++) {
			board.putToHiddenCards(this.deck.draw());
		}
		for(int i = 0; i < 48; i++) {
			board.put(this.deck.draw());
		}
	}
	
	public Card getHiddenCard() {
		return board.getNextHiddenCard();
	}
	
	public void putCardOnLine(Card card) {
		board.putDown(card);
	}
	
	public boolean isGameFinished() {
		return board.isGameFinished();
	}
	
	public boolean isGameWon() {
		return isGameFinished() && board.noMoreHiddenCards();
	}
}
