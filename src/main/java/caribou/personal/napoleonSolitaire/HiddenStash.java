package caribou.personal.napoleonSolitaire;

import java.util.ArrayList;
import java.util.List;

public class HiddenStash implements Stash {
	final List<Card> cards = new ArrayList();
	
	@Override
	public Card get() {
		if (cards.isEmpty()){
			return null;
		}
		return cards.remove(0);
	}
	
	@Override
	public void add(Card card) {
		cards.add(card);
	}
}
