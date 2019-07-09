package blackjack.cardManager;

import java.util.ArrayList;

import blackjack.models.Card;
import blackjack.models.CardList;

public class Player {
	protected CardList playerHand = new CardList();
	
	public CardList getPlayerHand() {
		return playerHand;
	}
	
	public boolean isOverMaxValue() {
		return playerHand.isOverMaxValue();
	}
	
	public void addCard(Card card) {
		playerHand.add(card);
	}
	
	public void addCards(ArrayList<Card> cards) {
		playerHand.add(cards);
	}
}
