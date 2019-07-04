package blackjack.cardManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import blackjack.models.Card;

public class CardGenerator implements CardManagerInterface {
	private final int maxCountOfUniqueCards = 4; //How many of a single card, example: 4 Spades (Can only be 4 of them)
	ArrayList<Card> cards = new ArrayList<Card>();

	@Override
	public Card getCard() {
		Card card = generateCard();
		while(isOverMaxCount(card)) {
			card = generateCard();
		}
		
		cards.add(card);
		return card;
	}

	@Override
	public ArrayList<Card> getStartingHand() {
		ArrayList<Card> startingHand = new ArrayList<Card>();
		startingHand.add(getCard());
		startingHand.add(getCard());
		return startingHand;
	}
	
	private Card generateCard() {
		Card card = new Card();
		card.setNumber(generateCardNumber());
		card.setSuit(generateCardSuit());
		
		return card;
	}
	
	private boolean isOverMaxCount(Card card) {
		int countOfCardInCards = Collections.frequency(cards, card);
		return countOfCardInCards >= maxCountOfUniqueCards;
	}
	
	private String generateCardNumber() {
		int randomNumber = generateRandomNumber(2, 14);
		switch(randomNumber) {
			case 11:
				return "Jack";
			case 12:
				return "Queen";
			case 13:
				return "Queen";
			default:
				return String.valueOf(randomNumber);
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
