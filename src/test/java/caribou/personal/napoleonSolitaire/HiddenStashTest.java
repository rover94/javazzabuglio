package caribou.personal.napoleonSolitaire;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class HiddenStashTest {
	private final HiddenStash hiddenStash = new HiddenStash();
	
	@Test
	void youAddACardAndYouCanRetrieveIt() {
		Card card = new Card();
		
		hiddenStash.add(card);
		
		assertThat(hiddenStash.get()).isEqualTo(card);
	}
	
	@Test
	void whenNoCardIsAdded_thenReturnNull() {
		assertThat(hiddenStash.get()).isEqualTo(null);
	}
	
	@Test
	void whenYouAddACardYouCanRetrieveItOnlyOnce() {
		Card card = new Card();
		
		hiddenStash.add(card);
		
		assertThat(hiddenStash.get()).isEqualTo(card);
		assertThat(hiddenStash.get()).isEqualTo(null);
	}
}