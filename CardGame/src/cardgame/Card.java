package cardgame;
/**
 * Card class is used for storing card face-values.
 * 
 * @author Sergiu Ivanov and Dana Buzatu.
 * @version 1.0 18-11-2018.
 */
public class Card {
    private Integer faceValue;

    public Card(int v) {
        faceValue = v;
    }
    
    /**
     * Simple getter that returns faceValue of a card
     *
     * @return faceValue means the face value
     */
    public int getFaceValue() {
        return faceValue;
    }

}
