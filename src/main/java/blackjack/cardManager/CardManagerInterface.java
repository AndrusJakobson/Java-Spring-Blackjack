package blackjack.cardManager;

import java.util.ArrayList;

import blackjack.models.Card;

public interface CardManagerInterface {
	public Card getCard();
	public ArrayList<Card> getStartingHand();
}
