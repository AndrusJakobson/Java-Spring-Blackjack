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
		while(isOverMaxCount(card)) {
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
		card.setWorth(cardNumber);
		card.setNumber(generateCardNumber(cardNumber));
		card.setSuit(generateCardSuit());
		
		return card;
	}
	
	private boolean isOverMaxCount(Card card) {
		int countOfCardInCards = Collections.frequency(cards, card);
		return countOfCardInCards >= maxCountOfUniqueCards;
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
	
	private int generateRandomNumber(int start, int end) {
		Random random = new Random();
		return random.nextInt(end - start) + start;
	}

}
