package euchre;

public class Card {
	private int value;
	private String URL;
	private int suit;
	public Card(int value, int suit, String URL) {
		this.suit = suit;
		this.value = value;
		this.URL = URL;
	}
	public int getValue() {
		return value;
	}
	public String getImage() {
		return URL;
	}
}
