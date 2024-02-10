package caribou.personal.napoleonSolitaire;

import caribou.personal.napoleonSolitaire.card.Card;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static caribou.personal.napoleonSolitaire.card.CardValue.*;
import static caribou.personal.napoleonSolitaire.card.Suits.DIAMOND;
import static org.assertj.core.api.Assertions.assertThat;

class FrenchDeckTest {
	private final FrenchDeck frenchDeck = new FrenchDeck();
	
	@Test
	void whenDrawingACardYouReturnTheFirstOneOnTheList() {
		assertThat(frenchDeck.draw()).isEqualTo(new Card(DIAMOND, ACE));
		assertThat(frenchDeck.draw()).isEqualTo(new Card(DIAMOND, TWO));
		assertThat(frenchDeck.draw()).isEqualTo(new Card(DIAMOND, THREE));
		assertThat(frenchDeck.draw()).isEqualTo(new Card(DIAMOND, FOUR));
	}
	
	@Disabled("Disabled since it could fail sometimes")
	@Test
	void whenTheCardsAreShuffledTheyAreNotInTheNaturalOrder() {
		frenchDeck.shuffle();
		
		assertThat(frenchDeck.draw()).isNotEqualTo(new Card(DIAMOND, ACE));
		assertThat(frenchDeck.draw()).isNotEqualTo(new Card(DIAMOND, TWO));
		assertThat(frenchDeck.draw()).isNotEqualTo(new Card(DIAMOND, THREE));
		assertThat(frenchDeck.draw()).isNotEqualTo(new Card(DIAMOND, FOUR));
	}
}