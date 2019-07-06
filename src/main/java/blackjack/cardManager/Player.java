package blackjack.cardManager;

import java.util.ArrayList;

import blackjack.constants.Constants;
import blackjack.models.Card;

public class Player {
	protected ArrayList<Card> playerHand = new ArrayList<Card>();
	protected int handValue = 0;
	
	public void sethandValue(int handWorth) {
		this.handValue = handWorth;
	}
	
	public int getHandValue() {
		return handValue;
	}
	
	public ArrayList<Card> getPlayerHand(){
		return playerHand;
	}
	
	public void addCard(Card card) {
		playerHand.add(card);
		increaseHandValue(card.getValue());
		lowerAceValueWhenBust();
	}
	
	protected void increaseHandValue(int increasement) {
		handValue+= increasement;
	}
	
	protected void reduceHandValue(int reduction) {
		handValue-= reduction;
	}
	
	private void lowerAceValueWhenBust() {
		if(willBust()) {
			lowerAceValue();
		}
	}
	
	private boolean willBust() {
		return handValue > 21;
	}
	
	public void addCards(ArrayList<Card> cards) {
		for(Card card : cards) {
			addCard(card);
		}
	}
	
	private void lowerAceValue() {
		for(Card card : playerHand) {
			if(isHighValueAce(card)) {
				card.setValue(Constants.aceLowValue);
				reduceHandValue(Constants.aceValueDifference);
				break;
			}
		}
	}
	
	private boolean isAce(Card card) {
		String cardName = card.getName();
		return cardName.equals(Constants.ace);
	}
	
	private boolean isHighValueAce(Card card) {
		if(isAce(card)) {
			return card.getValue() == Constants.aceHighValue;
		}
		return false;
	}
}
