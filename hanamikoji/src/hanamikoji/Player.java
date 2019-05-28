package hanamikoji;

import java.util.ArrayList;
import java.util.Random;

public class Player {
	
	// Kezdetben "null"-al feltöltve.
	private ArrayList<Card> hand = new ArrayList<>();
	
	public Player() 
	{
		
	}
	
	public void drawCard() 
	{
		hand.add(Game.getNewCard());
	}
	
	
	// Teszelni!!!
	public ArrayList<Card> getHand() { return hand; }

}
