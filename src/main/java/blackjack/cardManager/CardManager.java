package blackjack.cardManager;

import java.util.ArrayList;
import java.util.Random;

import blackjack.constants.Constants;
import blackjack.models.Card;

public class CardManager {
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Card getCard() {
		Card card = generateCard();
		while(isOverMaxCardCount(card)) {
			card = generateCard();
		}
		
		cards.add(card);
		return card;
	}

	public ArrayList<Card> drawStartingHand() {
		ArrayList<Card> startingHand = new ArrayList<Card>();
		startingHand.add(getCard());
		startingHand.add(getCard());
		return startingHand;
	}
	
	private Card generateCard() {
		Card card = new Card();
		int randomNumber = generateRandomNumber(2, 14);
		
		card.setValue(generateCardWorth(randomNumber));
		card.setName(generateCardName(randomNumber));
		card.setSuit(generateCardSuit());
		
		return card;
	}
	
	private boolean isOverMaxCardCount(Card card) {
		int cardInCardsCount = getCardCount(card);
		return cardInCardsCount >= Constants.maxCardDuplicate;
	}
	
	private int getCardCount(Card cardToCount) {
		int counter = 0;
		for(Card card : cards) {
			if(card.equals(cardToCount)) {
				counter++;
			}
		}
		return counter;
	}
	
	private int generateCardWorth(int cardNumber) {
		boolean isFaceCard = cardNumber > Constants.faceCardValue && cardNumber < Constants.aceNumber;
		boolean isAce = cardNumber == Constants.aceNumber;
		
		if(isAce) {
			return Constants.aceHighValue;
		}else if(isFaceCard) {
			return Constants.faceCardValue;
		}
		return cardNumber;
	}
	
	private String generateCardName(int cardNumber) {
		switch(cardNumber) {
			case 11:
				return Constants.jack;
			case 12:
				return Constants.queen;
			case 13:
				return Constants.king;
			case 14:
				return Constants.ace;
			default:
				return String.valueOf(cardNumber);
		}
	}
	
	private String generateCardSuit() {
		int randomNumber = generateRandomNumber(1, 4); 
		switch(randomNumber) {
			case 1:
				return Constants.spades;
			case 2:
				return Constants.hearts;
			case 3:
				return Constants.diamonds;
			default:
				return Constants.clubs;
		}
	}
	
	private int generateRandomNumber(int min, int max) {
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}

}
