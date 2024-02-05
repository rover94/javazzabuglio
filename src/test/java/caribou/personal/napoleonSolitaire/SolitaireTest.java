package caribou.personal.napoleonSolitaire;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class SolitaireTest {
	private final Deck deck = mock(Deck.class);
	private final Board board = mock(Board.class);
	private Solitaire solitaire;
	
	@BeforeEach
	void setUp() {
		solitaire = new Solitaire(deck, board);
	}
	
	@Test
	void whenPopulatingTheBoard_theDeckIsShuffledAnd52CardsAreDrawn() {
		solitaire.initGame();
		
		verify(deck).shuffle();
		verify(deck, times(52)).draw();
		verify(board, times(4)).putToHiddenCards(any());
		verify(board, times(48)).put(any());
	}
	
	@Test
	void whenTheBoard_youCanDrawFourCardsAndTheFifthIsNull() {
		solitaire.getHiddenCard();
		
		verify(board).getNextHiddenCard();
	}
	
	@Test
	void whenPuttingDownACard_youRequestTableToPutItDown() {
		Card card = new Card();
		
		solitaire.putCardOnLine(card);
		
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
		when(board.noMoreHiddenCards()).thenReturn(true);
		
		boolean gameFinished = solitaire.isGameWon();
		
		assertThat(gameFinished).isEqualTo(true);
	}
}