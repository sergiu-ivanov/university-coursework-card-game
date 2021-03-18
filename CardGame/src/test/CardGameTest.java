package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import cardgame.Player;
import cardgame.CardGame;
import cardgame.Deck;
import cardgame.Pack;
public class CardGameTest {
	
	public CardGameTest() {
    }
    

	 
    /**
     * method tests if the pack created is a valid one for the number of players introduced
     * @return void method
     */
    @Test
	public void testCreatePack() {
    	Pack pack = new Pack(4); //mock pack object
    	CardGame.createPack(pack);
    	assertTrue(!pack.getPack().isEmpty()); //is valid if pack is not empty

	}
    
    /**
     * method tests if the card game is played by any players
     * @return void method
     */
    @Test
	public void testCreatePlayers() {
        ArrayList<Player> players = new ArrayList<Player>(); //mock ArrayList of players
        
        assertTrue(players.isEmpty()); //is valid if there are no players in the game
    	CardGame.createPlayers(4,  players);
    	assertTrue(!players.isEmpty()); //is valid if there are players in the game

	}
    
    /**
     * method tests if the deck created is empty or not
     * @return void method
     */
    @Test
	public void testCreateDeck() {
        ArrayList<Deck> decks = new ArrayList<Deck>();

        assertTrue(decks.isEmpty()); //is valid if decks are empty
    	CardGame.createDeck(5, decks);
    	assertTrue(!decks.isEmpty());//is valid if decks are not empty

	}
    
  
	@Test
	public void testClearFolder() {

    	CardGame.clearFolder();

	}
	 
    /**
     * method tests if the players in concordance with the new mock object, pack generated can be outputed in the CardGame
     * @return void method
     */
	@Test
	public void testWritePlayersOutput() {
        ArrayList<Player> players = new ArrayList<Player>(); //mock ArrayList of players
    	Pack pack = new Pack(2); //mock pack object
    	CardGame.writePlayersOutput(players, pack); //write in CardGame the players and pack

	}
	 
    /**
     * method tests if the decks in concordance with the new mock object, pack generated can be outputed in the CardGame
     * @return void method
     */
	@Test
	public void testWriteDeckOutput() {
		ArrayList<Deck> decks = new ArrayList<Deck>(); //mock array list of decks
    	Pack pack = new Pack(3); //mock pack object
    	CardGame.writeDeckOutput(decks, pack); //write in CardGame the decks and pack
    	

	}
	
	@Test
	public void testMainGame() {

    	CardGame.main(null);

	}
	


}
