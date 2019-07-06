package blackjack.cardManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import blackjack.models.Card;

public class CardDealer {
	private final int maxCountOfUniqueCards = 4; //How many of a single card, example: 4 Spades (Can only be 4 of them)
	ArrayList<Card> cards = new ArrayList<Card>();

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
		int cardNumber = generateRandomNumber(2, 14);
		
		card.setWorth(generateCardWorth(cardNumber));
		card.setNumber(generateCardNumber(cardNumber));
		card.setSuit(generateCardSuit());
		
		return card;
	}
	
	private boolean isOverMaxCardCount(Card card) {
		int cardInCardsCount = getCardInCardsCount(card);
		System.out.println(cards);
		return cardInCardsCount >= maxCountOfUniqueCards;
	}
	
	private int getCardInCardsCount(Card cardToCount) {
		int counter = 0;
		for(Card card : cards) {
			if(card.equals(cardToCount)) {
				counter++;
			}
		}
		return counter;
	}
	
	private int generateCardWorth(int cardNumber) {
		boolean isFaceCard = cardNumber > 10 && cardNumber < 14;
		boolean isAce = cardNumber == 14;
		
		if(isAce) {
			return 11;
		}else if(isFaceCard) {
			return 10;
		}
		return cardNumber;
	}
	
	private String generateCardNumber(int cardNumber) {
		switch(cardNumber) {
			case 11:
				return "Jack";
			case 12:
				return "Queen";
			case 13:
				return "King";
			case 14:
				return "Ace";
			default:
				return String.valueOf(cardNumber);
		}
	}
	
	private String generateCardSuit() {
		int randomNumber = generateRandomNumber(1, 4); 
		switch(randomNumber) {
			case 1:
				return "Spades";
			case 2:
				return "hearts";
			case 3:
				return "diamonds";
			default:
				return "clubs";
		}
	}
	
	private int generateRandomNumber(int min, int max) {
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}

}
