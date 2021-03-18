package test;

import static org.junit.Assert.*;
import org.junit.Test;
import cardgame.Card;
import cardgame.Deck;

public class DeckTest {

    public DeckTest() {
    }
   

    /**
     * method tests if what method getDeck_number returns is the right value of deck's number 
     * @return void method
     */
	@Test
	public void testGetDeckNumber() {
		Deck deck1 = new Deck(2); //mock deck object
		Deck deck2 = new Deck(10);

		assertEquals(2, deck1.getDeck_number()); //checks if the expected value matches the actual value
		assertEquals(10, deck2.getDeck_number());
		
	}
	
	/**
     * method tests if the last card in the deck value is returned correctly by method seeTop
     * @return void method
     */
	@Test
	public void testSeeTop() { //mock card object
		Card card1 = new Card(1);
		Card card2 = new Card(2);
		Card card3 = new Card(3);
		Card card4 = new Card(4);
		Deck deck = new Deck(1);
		
		deck.addToDeck(card1.getFaceValue());//adding a card to the deck
		deck.addToDeck(card2.getFaceValue());
		deck.addToDeck(card3.getFaceValue());
		deck.addToDeck(card4.getFaceValue());

		assertEquals(card1.getFaceValue(), deck.seeTop()); //checks if the expected value matches the actual value
	}
	
	/**
     * method tests if the last card in the deck value is returned correctly by method getTop
     * @return void method
     */
	@Test
	public void testGetTop() {
		Card card1 = new Card(1); //mock card object
		Card card2 = new Card(2);
		Deck deck = new Deck(4); //mock deck object
		deck.addToDeck(card1.getFaceValue()); //adding a card to the deck
		deck.addToDeck(card2.getFaceValue());

		assertEquals(card1.getFaceValue(), deck.getTop().getFaceValue()); //checks if the expected value matches the actual value
	}
	
	/**
     * method tests that for each card added in the deck, it is written in the output file
     * @return void method
     */
	@Test
	public void testWriteToDeck() {
		Card card1 = new Card(1); //mock card object
		Card card2 = new Card(2);
		Deck deck = new Deck(1); //mock deck object
		
		deck.addToDeck(card1.getFaceValue()); //adding a card to the deck
		deck.addToDeck(card2.getFaceValue());
		deck.writeToDeck();
	}

}
