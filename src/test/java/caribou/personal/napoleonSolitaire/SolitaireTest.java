package caribou.personal.napoleonSolitaire;

import caribou.personal.napoleonSolitaire.card.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static caribou.personal.napoleonSolitaire.card.CardValue.ACE;
import static caribou.personal.napoleonSolitaire.card.Suits.CLUB;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class SolitaireTest {
	private final Deck deck = mock(Deck.class);
	private final Board board = mock(Board.class);
	private final Stash stash = mock(Stash.class);
	private Solitaire solitaire;
	
	@BeforeEach
	void setUp() {
		solitaire = new Solitaire(deck, board, stash);
	}
	
	@Test
	void whenPopulatingTheBoard_theDeckIsShuffledAnd52CardsAreDrawn() {
		solitaire.initGame();
		
		verify(deck).shuffle();
		verify(deck, times(52)).draw();
		verify(stash, times(4)).add(any());
		verify(board, times(48)).putDownHiddenCard(any());
	}
	
	@Test
	void whenTheBoard_youCanDrawCardsAndRequestFromStash() {
		solitaire.getHiddenCard();
		
		verify(stash).get();
	}
	
	@Test
	void whenPuttingDownACard_youRequestTableToPutItDown() {
		Card card = new Card(CLUB, ACE);
		when(board.putDown(card)).thenReturn(card);
		
		solitaire.putDownCard(card);
		
		verify(board).putDown(card);
	}
	
	@Test
	void whenVerifyingIfTheGameIsOver_youRequestItToTable() {
		when(board.isGameFinished()).thenReturn(true);
		
		boolean gameFinished = solitaire.isGameFinished();
		
		assertThat(gameFinished).isEqualTo(true);
	}
	
	@Test
	void whenVerifyingIfTheGameIsWon_youRequestItToTable() {
		when(board.isGameFinished()).thenReturn(true);
		when(board.gameWon()).thenReturn(true);
		
		boolean gameFinished = solitaire.isGameWon();
		
		assertThat(gameFinished).isEqualTo(true);
	}
}