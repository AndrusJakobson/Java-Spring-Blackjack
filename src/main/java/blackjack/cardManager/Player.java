package blackjack.cardManager;

import java.util.ArrayList;

import blackjack.models.Card;

public class Player {
	ArrayList<Card> playerHand = new ArrayList<Card>();
	
	public ArrayList<Card> getPlayerHand(){
		return playerHand;
	}
	
	public void addCard(Card card) {
		playerHand.add(card);
	}
	
	public void addCards(ArrayList<Card> cards) {
		playerHand.addAll(cards);
	}
	
	public int getHandWorth() {
		int totalWorth = 0;
		for(Card card : playerHand) {
			totalWorth+= card.getWorth();
		}
		return totalWorth;
	}
}
