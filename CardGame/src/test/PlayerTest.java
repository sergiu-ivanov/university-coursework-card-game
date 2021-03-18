package test;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import cardgame.Deck;
import cardgame.Player;

public class PlayerTest {
	public PlayerTest() {
    }
	
	/**
     * method tests if method getPlayer_number returns the right player's number
     * @return void method
     */
	@Test
	public void testGetPlayerNumber() {

		Player player3 = new Player(100); //mock player object

		assertEquals(100, player3.getPlayer_number()); //checks if the expected value matches the actual value
	}
	
	/**
     * method tests if method getPlayer_output returns the right player's File output
     * @return void method
     */
    @Test
	public void testGetPlayerOutput() {
		Player player = new Player(7); //mock player object
		File output = new File("output/player7_output.txt"); //mock file object
		assertEquals(output, player.getPlayer_output()); //checks if the expected value matches the actual value
	}
    
    /**
     * method tests if method finalHand displays player's final hand of cards in file *player_output*
     * @return void method
     */
    @Test
	public void testFinalHand() {
		Player player = new Player(5); //mock player object
		player.finalHand();
		File output = new File("output/player5_output.txt"); //mock file object
		assertEquals(output, player.getPlayer_output()); //checks if the expected value matches the actual value
	}
    
    /**
     * method tests if method currentHand displays player's current hand of cards in file *player_output
     * @return void method
     */
    @Test
	public void testCurrentHand() {
		Player player = new Player(6); //mock player object
		player.currentHand();
		File output = new File("output/player6_output.txt"); //mock file object
		assertEquals(output, player.getPlayer_output()); //checks if the expected value matches the actual value
	}
    
    /**
     * method tests if the player's output is displayed in the right corresponding file
     * @return void method
     */
    @Test
	public void testWritePlayerOutput() {
		Player player = new Player(4); //mock player object
		File output = new File("output/player4_output.txt");//mock file object
		player.writeToPlayerOutput(output, "player wins"); 
		assertEquals(output, player.getPlayer_output()); //checks if the expected value matches the actual value
	}
    
    /**
     * method tests the conditions for a player to win (if the player has cards of the same denomination)
     * @return void method
     */
    @Test
	public void testWin() {
		
		Player player = new Player(1); //mock player object
		Player player2 = new Player(2);

		player.add_to_hand(1); //add card to player's hand
		player.add_to_hand(1);
		player.add_to_hand(1);
		player.add_to_hand(1);
		
		player2.add_to_hand(2);
		player2.add_to_hand(0);
		player2.add_to_hand(5);
		player2.add_to_hand(8);

		
		assertTrue(player.win());//is valid if player.win() is True
		assertTrue(!player2.win());

	}
    
    /**
     * method tests if the value of the card added in player's hand actually matches the card face value
     * @return void method
     */
    @Test
	public void testAddToHand() {
	
		Player player = new Player(10); //mock palyer object
		player.add_to_hand(10); //add card player's hand

		assertEquals(10, player.getHand_cards().get(0).getFaceValue());//checks if the expected value matches the actual value
	}
    
    /**
     * method tests if method *initialHand* displays player's initial hand of cards in file *player_output
     * @return void method
     */
    @Test
	public void testInitialHand() {
		Player player = new Player(7); //mock player object
		player.initialHand(); 
		File output = new File("output/player7_output.txt"); //mock file object
		assertEquals(output, player.getPlayer_output()); //checks if the expected value matches the actual value
	}
    
    /**
     * method tests if after the card drawn from the deck by theplayer, the output is the one expected
     * @return void method
     */
    @Test
	public void testDraw() {
		Player player = new Player(8); //mock player object
		Deck deck = new Deck(8); //mock deck object
		deck.addToDeck(2);//add card to deck
		deck.addToDeck(6);
		deck.addToDeck(5);
		deck.addToDeck(1);
		player.draw(deck);
		File output = new File("output/player8_output.txt");//mock file object
		assertEquals(output, player.getPlayer_output()); //checks if the expected value matches the actual value
	}
    
    /**
     * method tests the operation of discarding a card from the deck and displaying the output after that, which has to be in concordance with the action completed
     * @return void method
     */
    @Test
	public void testDiscard() {
		Player player = new Player(8); //mock player object
		player.add_to_hand(2); //add card to player's hand
		Deck deck = new Deck(8); //mock deck object
		player.discard(deck);
		File output = new File("output/player8_output.txt"); //mock file object
		assertEquals(output, player.getPlayer_output()); //checks if the expected value matches the actual value

	}

}
