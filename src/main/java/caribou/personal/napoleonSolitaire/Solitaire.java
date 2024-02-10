package caribou.personal.napoleonSolitaire;

import caribou.personal.napoleonSolitaire.card.Card;

public class Solitaire {
	private final Deck deck;
	private final Board board;
	private final Stash stash;
	
	public Solitaire(Deck deck, Board board, Stash stash) {
		this.deck = deck;
		this.board = board;
		this.stash = stash;
	}
	
	public Solitaire() {
		this.deck = new FrenchDeck();
		this.board = new NapoleonSolitaireBoard();
		this.stash = new HiddenStash();
	}
	
	public void initGame() {
		this.deck.shuffle();
		
		for(int i = 0; i < 4; i++) {
			stash.add(this.deck.draw());
		}
		for(int i = 0; i < 48; i++) {
			board.putDownHiddenCard(this.deck.draw());
		}
	}
	
	public Card getHiddenCard() {
		return stash.get();
	}
	
	public Card putDownCard(Card card) {
		return board.putDown(card);
	}
	
	public boolean isGameFinished() {
		return board.isGameFinished();
	}
	
	public boolean isGameWon() {
		return isGameFinished() && board.gameWon();
	}
}
