package caribou.personal.napoleonSolitaire;

import caribou.personal.napoleonSolitaire.card.Card;
import org.junit.jupiter.api.Test;

import static caribou.personal.napoleonSolitaire.card.CardValue.ACE;
import static caribou.personal.napoleonSolitaire.card.Suits.CLUB;
import static org.assertj.core.api.Assertions.assertThat;

class HiddenStashTest {
	private final HiddenStash hiddenStash = new HiddenStash();
	
	@Test
	void youAddACardAndYouCanRetrieveIt() {
		Card card = new Card(CLUB, ACE);
		
		hiddenStash.add(card);
		
		assertThat(hiddenStash.get()).isEqualTo(card);
	}
	
	@Test
	void whenNoCardIsAdded_thenReturnNull() {
		assertThat(hiddenStash.get()).isEqualTo(null);
	}
	
	@Test
	void whenYouAddACardYouCanRetrieveItOnlyOnce() {
		Card card = new Card(CLUB, ACE);
		
		hiddenStash.add(card);
		
		assertThat(hiddenStash.get()).isEqualTo(card);
		assertThat(hiddenStash.get()).isEqualTo(null);
	}
}