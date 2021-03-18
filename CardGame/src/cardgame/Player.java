package cardgame;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Player is used to store the player's hand of cards 
 * and perform different actions with the cards.
 *
 * @author Sergiu Ivanov and Dana Buzatu.
 * @version 1.0 18-11-2018.
 */
public class Player {
    private int player_number;
    private ArrayList<Card> hand_cards;
    private File player_output;
// Constructor that sets player number equal to n parameter
    public Player(int n) {
        this.player_number = n;
        this.hand_cards = new ArrayList<Card>();
        this.player_output = new File( "output/player" + player_number + "_output.txt");
        }
    /**
     * A simple getter that  returns the player output
     *@return player_output means player output 
     */
    public File getPlayer_output() {
        return player_output;
    }
    /**
     * A simple getter that  returns the player number
     *@return player_number means player number 
     */
    public int getPlayer_number() {
        return player_number;
    }
    
    /**
     * Prints the initial hand of the player and
     * pass this string to the writer to write it
     */
    public void initialHand(){
        String initialH = "Player " + player_number + " initial hand ";
        for ( Card card: hand_cards){
            initialH += " " + card.getFaceValue();
        }
        initialH += "\n";
        System.out.println(initialH);
        writeToPlayerOutput( player_output, initialH);
    }
    
    /**
     * Prints the final hand of the player  and
     * pass this string to the writer to write it
     */
    public void finalHand(){
        String finalH ="Player " + player_number + " final hand: ";
        for ( Card card: hand_cards){
            finalH += " " + card.getFaceValue();
        }
        System.out.println(finalH);
        writeToPlayerOutput(player_output,finalH);
    }
    /**
     * Prints the current hand of the player and
     * pass this string to the writer to write it
     */
    public void currentHand(){
        String currentH ="Player " + player_number + " current hand:";
        for ( Card card: hand_cards){
            currentH += " " + card.getFaceValue();
        }
        currentH += "\n";
        System.out.println(currentH);

        writeToPlayerOutput(player_output,currentH);
    }
    /**
     * A simple getter that  returns the an arraylist of cards
     *@return hand_cards means the cards in the hand
     */
    public ArrayList<Card> getHand_cards() {
		return hand_cards;
	}
    
    /**
     *  Adds the card object with the face value of parameter i
     *@param i means the face value
     */
    public void add_to_hand( Integer i) {
        hand_cards.add(new Card(i));
    }
    
    /**
     * Check if the player has won and returns true if so, false- otherwise.
     *@return true 
     *@return false
     */
    public Boolean win(){
        ArrayList<Card> i = hand_cards;
        if (i.get(0).getFaceValue() == i.get(1).getFaceValue()&&
                i.get(1).getFaceValue() == i.get(2).getFaceValue()&&
                i.get(2).getFaceValue() == i.get(3).getFaceValue()){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Get the card object from the top of the deck specified as its parameter
     * and pass it as a string to the writer
     * 
     * @param a means a deck object
     */
    public void draw(Deck a) {
        String playerDraw = "Player " + player_number + " draws a " + a.seeTop()
                + " from deck " + a.getDeck_number();
        hand_cards.add(a.getTop());
        System.out.println(playerDraw);
        writeToPlayerOutput( player_output, playerDraw);
    }
    
    /**
     * Discards a card object from the players hand to the bottom of the 
     * deck specified in its argument
     * and pass it as a string to the writer
     * 
     * @param a means a deck object
     */
    public void discard(Deck a) {
        String playerDiscards = "Player " + player_number + " discards  ";
        for (Card card : hand_cards){
            if (card.getFaceValue() != player_number){
                a.addToDeck(card.getFaceValue());
                System.out.println("Player " + player_number + " discards " + card.getFaceValue() +
                " to deck " + a.getDeck_number());
                playerDiscards += card.getFaceValue() +
                        " to deck " + a.getDeck_number();
                hand_cards.remove(card);
                break;
            }
        }
        writeToPlayerOutput( player_output, playerDiscards);
    }
    
    /**
     * Writes the string to a file
     *
     *@param path is the file path
     *@param string is the string that needs to be written
     */
    public  void writeToPlayerOutput( File path, String string){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            writer.write(string);
            writer.newLine();
            writer.close();
        }catch (IOException ex) {
            System.out.println("The file cannot be found.");
        }
    }
    
    

    





}
