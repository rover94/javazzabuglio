package caribou.personal.napoleonSolitaire;

import caribou.personal.napoleonSolitaire.card.Card;
import caribou.personal.napoleonSolitaire.card.CardValue;
import caribou.personal.napoleonSolitaire.card.Suits;
import org.junit.jupiter.api.Test;

import static caribou.personal.napoleonSolitaire.card.CardValue.ACE;
import static caribou.personal.napoleonSolitaire.card.CardValue.TWO;
import static caribou.personal.napoleonSolitaire.card.Suits.*;
import static org.assertj.core.api.Assertions.assertThat;

class NapoleonSolitaireBoardTest {
	private final Board board = new NapoleonSolitaireBoard();
	
	@Test
	void gameFinishesWhenTheFirstFourElementsAreNotNull() {
		board.putDown(new Card(DIAMOND, ACE));
		board.putDown(new Card(SPADE, ACE));
		board.putDown(new Card(CLUB, ACE));
		board.putDown(new Card(HEART, ACE));
		
		boolean gameFinished = board.isGameFinished();
		
		assertThat(gameFinished).isTrue();
	}
	
	@Test
	void gameDoesNotFinishUntilTheFirstFourElementsAreNotFilled() {
		board.putDown(new Card(DIAMOND, ACE));
		board.putDown(new Card(SPADE, ACE));
		board.putDown(new Card(CLUB, ACE));
		
		boolean gameFinished = board.isGameFinished();
		
		assertThat(gameFinished).isFalse();
	}
	
	@Test
	void whenPuttingDownACardYouReturnTheOneOnTheTable() {
		Card card = new Card(CLUB, ACE);
		board.putDownHiddenCard(card);
		
		Card result = board.putDown(new Card(DIAMOND, TWO));
		
		assertThat(result).isEqualTo(card);
	}
	
	@Test
	void whenYouPutDownACardItsOnlyPlacedOnce() {
		Card card = new Card(CLUB, ACE);
		board.putDownHiddenCard(card);
		
		Card firstCard = board.putDown(new Card(DIAMOND, TWO));
		Card secondCard = board.putDown(new Card(HEART, TWO));
		
		assertThat(secondCard).isNotEqualTo(firstCard);
	}
	
	@Test
	void gameNotIsWonIfNotAllCardsArePlacesOnTheCorrectPosition() {
		board.putDown(new Card(DIAMOND, TWO));
		
		assertThat(board.gameWon()).isFalse();
	}
	
	@Test
	void gameIsWonIfAllCardsArePlacesOnTheCorrectPosition() {
		for (Suits suit: Suits.values()){
			for (CardValue value : CardValue.values()) {
				board.putDown(new Card(suit, value));
			}
		}
		
		assertThat(board.gameWon()).isTrue();
	}
}