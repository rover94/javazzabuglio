package caribou.personal.napoleonSolitaire;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class SolitaireTest {
	private final Deck deck = mock(Deck.class);
	private Solitaire solitaire;
	
	@BeforeEach
	void setUp() {
		solitaire = new Solitaire(deck);
		
	}
	
	@Test
	void whenPopulatingTheBoard_theDeckIsShuffledAnd52CardsAreDrawn() {
		solitaire.initGame();
		
		verify(deck).shuffle();
		verify(deck, times(52)).draw();
	}
	
	@Test
	void whenTheBoardIsPopulated_youCanDrawUpTo4HiddenCards() {
		Card card = new Card();
		when(deck.draw()).thenReturn(card);
		
		solitaire.initGame();
		
		assertThat(solitaire.getHiddenCard()).isEqualTo(card);
		assertThat(solitaire.getHiddenCard()).isEqualTo(card);
		assertThat(solitaire.getHiddenCard()).isEqualTo(card);
		assertThat(solitaire.getHiddenCard()).isEqualTo(card);
	}
	
	@Test
	void whenTheBoardIsPopulated_youCanDrawFourCardsAndTheFifthIsNull() {
		Card card = new Card();
		when(deck.draw()).thenReturn(card);
		
		solitaire.initGame();
		
		assertThat(solitaire.getHiddenCard()).isEqualTo(card);
		assertThat(solitaire.getHiddenCard()).isEqualTo(card);
		assertThat(solitaire.getHiddenCard()).isEqualTo(card);
		assertThat(solitaire.getHiddenCard()).isEqualTo(card);
		assertThat(solitaire.getHiddenCard()).isEqualTo(null);
	}
	
	@Test
	void whenTheBoardIsPopulated_youCanPutACardOnAnEmptyLineYouReceiveTheCardThatIsONTable() {
		Card card = new Card();
		when(deck.draw()).thenReturn(card);
		
		solitaire.initGame();
		
		solitaire.putCardOnLine(new Card(), 1);
	}
	
	@Test
	void whenTheBoardIsPopulated_youCannotPutACardOfAWrongSuitOnAPopulatedLineAndYouReceiveBackTheSameOne() {
		Card card = new Card();
		when(deck.draw()).thenReturn(card);
		
		solitaire.initGame();
		
		solitaire.putCardOnLine(new Card(), 1);
	}
}