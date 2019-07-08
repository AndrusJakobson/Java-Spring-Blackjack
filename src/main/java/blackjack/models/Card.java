package blackjack.models;

import blackjack.constants.Constants;

public class Card {
	private int value;
	private String name;
	private String suit;
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public boolean isAce() {
		return name.equals(Constants.ace);
	}
	
	public boolean hasHighValue() {
		return value == Constants.aceHighValue;
	}
	
	public boolean equals(Card compareTo) {
		boolean sameSuit = suit == compareTo.getSuit();
		boolean sameNumber = name == compareTo.getName();
		return sameSuit && sameNumber;
	}
}
