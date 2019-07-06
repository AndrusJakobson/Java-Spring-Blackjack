package blackjack.models;

public class Card {
	private int worth;
	private String name;
	private String suit;
	
	public int getValue() {
		return worth;
	}
	
	public void setValue(int worth) {
		this.worth = worth;
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
	
	public boolean equals(Card compareTo) {
		boolean sameSuit = suit == compareTo.getSuit();
		boolean sameNumber = name == compareTo.getName();
		return sameSuit && sameNumber;
	}
}
