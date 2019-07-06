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
		lowerAceWorthWhenBust();
	}
	
	public void addCards(ArrayList<Card> cards) {
		for(Card card : cards) {
			addCard(card);
		}
	}
	
	private void lowerAceWorthWhenBust() {
		if(willBust()) {
			lowerAceWorth();
		}
	}
	
	private boolean willBust() {
		return handWorth > 21;
	}
	
	private void lowerAceWorth() {
		for(Card card : playerHand) {
			if(isHighWorthAce(card)) {
				card.setWorth(1);
				deductFromHandWorth(10);
				break;
			}
		}
	}
	
	private boolean isAce(Card card) {
		String cardNumber = card.getNumber();
		return cardNumber.equals("Ace");
	}
	
	private boolean isHighWorthAce(Card card) {
		if(isAce(card)) {
			return card.getWorth() == 11;
		}
		return false;
	}
}
