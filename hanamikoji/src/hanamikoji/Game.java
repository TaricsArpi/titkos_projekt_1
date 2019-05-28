package hanamikoji;

import java.util.ArrayList;
import java.util.Random;

public class Game {
	
	// A j�t�kban a szab�ly szerint ennyi lappal kell kezdeni.
	public static final int STARTING_HAND_SIZE = 6;
	
	private static Random randomGenerator = new Random();
	
	// A g�s�k t�pusai: 0 - Piros(2 db), 1 - S�rga(2), 2 - Lila(2), 3 - Narancs(3)
	//					4 - K�k(3), 5 - Z�ld(4), 6 - R�zsasz�n(5)
	private static ArrayList<Card> deck = new ArrayList<>() {
		{
			add(new Card(0)); add(new Card(0)); 				  									  // Piros
			add(new Card(1)); add(new Card(1)); 				  									  // S�rga
			add(new Card(2)); add(new Card(2)); 				  									  // Lila
			add(new Card(3)); add(new Card(3)); add(new Card(3)); 									  // Narancs
			add(new Card(4)); add(new Card(4)); add(new Card(4)); 									  // K�k
			add(new Card(5)); add(new Card(5)); add(new Card(5)); add(new Card(5));					  // Z�ld
			add(new Card(6)); add(new Card(6)); add(new Card(6)); add(new Card(6)); add(new Card(6)); // R�zsasz�n
		}
	};
	
	private static Player player1 = new Player();
	private static Player player2 = new Player();
	
	// A j�t�kot elind�t� f�ggv�ny.
	public static void startGame() 
	{
		// Kezd�snek kivesz�nk egy lapot a paklib�l.
		getNewCard();
		
		// Kezd�lapok kih�z�sa.
		drawStartingHands();
		
		// TESZT!!!
		testProgress();
		
	}
	
	// A kezd�kezek kih�z�sa.
	private static void drawStartingHands()
	{
		for (int i = 0; i < STARTING_HAND_SIZE; i++) 
		{
			player1.drawCard();
			player2.drawCard();
		}
	}
	
	// Visszaad egy h�zott lapot a paklib�l, amennyiben ez m�g lehets�ges
	// egy�bk�nt "null"-al t�r vissza.
	public static Card getNewCard()
	{
		if (deck.size() != 0) 
		{
			int index = randomGenerator.nextInt(deck.size());
			Card card = deck.get(index);
			deck.remove(index);
			return card;
		}
		else 
			return null;
		
	}
	
	// TESZTF�GGV�NY!!!
	private static void testProgress() 
	{
		System.out.print("Player1 hand: ");
		for(int i = 0; i < player1.getHand().size(); i++)
			System.out.print(player1.getHand().get(i).getCardType() + ",");
		System.out.println();
		System.out.print("Player2 hand: ");
		for(int i = 0; i < player2.getHand().size(); i++)
			System.out.print(player2.getHand().get(i).getCardType() + ",");
		System.out.println();
		System.out.print("Deck remaining cards: ");
		for(int i = 0; i < deck.size(); i++) 
			System.out.print(deck.get(i).getCardType() + ",");
	}
	
}
