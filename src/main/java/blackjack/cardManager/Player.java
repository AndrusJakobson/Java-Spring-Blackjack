package blackjack.cardManager;

import java.util.ArrayList;

import blackjack.models.Card;

public class Player {
	private ArrayList<Card> playerHand = new ArrayList<Card>();
	private int handWorth = 0;
	
	private void addToHandWorth(int addition) {
		handWorth+= addition;
	}
	
	private void deductFromHandWorth(int deduction) {
		handWorth-= deduction;
	}
	
	public void sethandWorth(int handWorth) {
		this.handWorth = handWorth;
	}
	
	public int getHandWorth() {
		return handWorth;
	}

	public ArrayList<Card> getPlayerHand(){
		return playerHand;
	}
	
	public void addCard(Card card) {
		playerHand.add(card);
		addToHandWorth(card.getWorth());
	}
	
	public void addCards(ArrayList<Card> cards) {
		for(Card card : cards) {
			addCard(card);
		}
	}
	
	
	
	
	public void lowerAceWorth() {
		for(Card card : playerHand) {
			if(isHighWorthAce(card)) {
				card.setWorth(1);
			}
		}
	}
	
	private boolean isAce(Card card) {
		String cardSuit = card.getSuit();
		return cardSuit.equals("Ace");
	}
	
	private boolean isHighWorthAce(Card card) {
		if(isAce(card)) {
			return card.getWorth() == 14;
		}
		return false;
	}
}
