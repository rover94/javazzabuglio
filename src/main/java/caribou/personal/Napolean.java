package caribou.personal;

import caribou.personal.napoleonSolitaire.Solitaire;
import caribou.personal.napoleonSolitaire.card.Card;

import static java.util.Objects.isNull;

public class Napolean {
	public Napolean() {
		int gameCounter = 0;
		for (int i = 0; i < 1; i++) {
			
			final Solitaire solitaire = new Solitaire();
			solitaire.initGame();
			
			Card currentCard = solitaire.getHiddenCard();
			while (gameIsNotFinished(solitaire)) {
				if (isNull(currentCard)) {
					currentCard = solitaire.getHiddenCard();
				}
				currentCard = solitaire.putDownCard(currentCard);
			}
			
			if (solitaire.isGameWon()) {
				gameCounter++;
			}
		}
		
		System.out.println("Played a lot, won " + gameCounter + " times");
		
		
	}
	
	private static boolean gameIsNotFinished(Solitaire solitaire) {
		return !solitaire.isGameFinished();
	}
}
