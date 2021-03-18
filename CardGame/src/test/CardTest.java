package test;

import static org.junit.Assert.*;
import org.junit.Test;

import cardgame.Card;

public class CardTest {
    public CardTest() {
    }
    
    /**
     * method tests if the value hold by the card is returned through method getFaceValue
     * @return void method
     */
    
	@Test
	public  void testGetFaceValue() {
		
		int value1 = 2;
		int value2 = 10;
		Card card = new Card(value1); //mock object created
		Card card2 = new Card(value2);
	
		assertEquals(value1, card.getFaceValue()); //checks if value expected matches actual value
		assertEquals(value2, card2.getFaceValue());
		
	}

}
