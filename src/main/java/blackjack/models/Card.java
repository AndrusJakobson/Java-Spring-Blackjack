package blackjack.models;

public class Card {
	private int worth;
	private String number;
	private String suit;
	
	public int getWorth() {
		return worth;
	}
	
	public void setWorth(int worth) {
		this.worth = worth;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public void setSuit(String suit) {
		this.suit = suit;
	}
}
