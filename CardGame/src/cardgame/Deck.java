package cardgame;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Deck is used to store card objects in a deck, add and remove
 *  cards from the deck and write its output.
 * 
 *
 * @author Sergiu Ivanov and Dana Buzatu.
 * @version 1.0 18-11-2018.
 */
public class Deck {

    private int deck_number;
    private Queue <Card> hand_decks;
    private File deck_output;


    public Deck(int n) {
        this.deck_number = n;
        this.hand_decks = new LinkedList<Card>();
        this.deck_output = new File( "output/deck" + deck_number + "_output.txt");
    }

    /**
     * A simple getter that  returns the deck number
     *@return deck_number means deck number 
     */
    public int getDeck_number() {
        return deck_number;
    }
    /**
     * Returns the top of the deck but doesn't remove it
     *@return hand_decks.peek().getFaceValue()  means face 
     *value of the top card
     */
    public int seeTop(){
        return hand_decks.peek().getFaceValue();
    }
    /**
     * GetTop returns the top of the deck and remove it
     *@return hand_decks.poll() means top of the card
     */
    public Card getTop() {
        return hand_decks.poll();
    }
    /**
     * AddToDeck adds a card object with the value of parameter i
     *  to the bottom of the deck
     *  
     *@param i means the face value
     */
    public void addToDeck(Integer i){
        hand_decks.add(new Card(i));
    }
    /**
     * WriteToDeckWriter writes the string to a file
     *
     *@param path is the file path
     *@param string is the string that needs to be written
     */
    public void writeToDeckWriter( File path, String string )  {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(string);
            writer.newLine();
            writer.close();
        }catch (IOException ex) {
            System.out.println("The file cannot be found.");
        }
    }
    /**
     * writeToDeck creates a string that is passed as a parameter 
     * to writeToDeckWriter writes the string to a file
     *
     */
    public void writeToDeck(){
        String deckContent = "deck_" + deck_number + " contents: ";
        for ( Card card: hand_decks){
            deckContent += card.getFaceValue() + " ";
        }
        writeToDeckWriter(deck_output, deckContent);
    }



}

