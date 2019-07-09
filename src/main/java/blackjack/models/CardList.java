package blackjack.models;

import java.util.ArrayList;

import blackjack.constants.Constants;

public class CardList {
	private ArrayList<Card> cardList = new ArrayList<Card>();
	private int listValue = 0;
	
	public ArrayList<Card> getCardList(){
		return cardList;
	}
	
	public void setList(ArrayList<Card> cardList) {
		this.cardList = cardList;
	}
	
	public int getValue() {
		return listValue;
	}
	
	public void add(Card card) {
		cardList.add(card);
		listValue+= card.getValue();
		
		if(isOverMaxValue()) {
			lowerAceValue();
		}
	}
	
	public void add(ArrayList<Card> cards) {
		for(Card card : cards) {
			add(card);
		}
	}
	
	public boolean isOverMaxValue() {
		return listValue > Constants.maxHandValue;
	}
	
	private void lowerAceValue() {
		for(Card card : cardList) {
			if(card.isAce() && card.hasHighValue()) {
				card.setValue(Constants.aceLowValue);
				listValue-= Constants.aceValueDifference;
				if(!isOverMaxValue()) {
					break;
				}
			}
		}
	}
}
