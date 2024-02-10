package caribou.personal.napoleonSolitaire;

import caribou.personal.napoleonSolitaire.card.Card;
import caribou.personal.napoleonSolitaire.card.CardValue;
import caribou.personal.napoleonSolitaire.card.Suits;

import java.util.Objects;

import static caribou.personal.napoleonSolitaire.card.CardValue.ACE;
import static caribou.personal.napoleonSolitaire.card.Suits.*;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class NapoleonSolitaireBoard implements Board {
	private final Card[][] cards;
	
	public NapoleonSolitaireBoard() {
		cards = new Card[4][13];
	}
	
	@Override
	public void putDownHiddenCard(Card card) {
		for (Suits suit: values()){
			for (CardValue value : CardValue.values()) {
				if (isNull(cards[suit.ordinal()][value.ordinal()]) && value != ACE) {
					cards[suit.ordinal()][value.ordinal()] = card;
					return;
				}
			}
		}
	}
	
	@Override
	public Card putDown(Card card) {
		Card returningCard = cards[card.suits().ordinal()][card.cardValue().ordinal()];
		cards[card.suits().ordinal()][card.cardValue().ordinal()] = card;
		return returningCard;
	}
	
	@Override
	public boolean isGameFinished() {
		return nonNull(cards[SPADE.ordinal()][0]) &&
				nonNull(cards[CLUB.ordinal()][0]) &&
				nonNull(cards[DIAMOND.ordinal()][0]) &&
				nonNull(cards[HEART.ordinal()][0]);
	}
	
	@Override
	public boolean gameWon() {
		for (Suits suit: values()) {
			for (CardValue value : CardValue.values()) {
				if (!Objects.equals(cards[suit.ordinal()][value.ordinal()], new Card(suit, value))) {
					return false;
				}
			}
		}
		return true;
	}
	
	private void printBoard() {
		for (Suits suit: values()) {
			for (CardValue value : CardValue.values()) {
				System.out.print(cards[suit.ordinal()][value.ordinal()] + " - ");
			}
			System.out.println("");
		}
	}
}
