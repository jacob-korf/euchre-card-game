package euchre;

public class Card {
	private int value;
	private String URL;
	public Card(int val, String image) {
		value = val;
		URL = image;
	}
	public int getValue() {
		return value;
	}
	public String getImage() {
		return URL;
	}
}
