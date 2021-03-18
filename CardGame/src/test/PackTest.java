package test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import org.junit.Test;
import cardgame.Pack;

public class PackTest {
    public PackTest() {
    }

    /**
     * method tests if method getNumOfPlayers actually returns the right number of players
     * @return void method
     */
    @Test
	public void testGetNumOfPlayers() {
		
		int numOfPlayers = 2;
		int numOfPlayers2 = 10;
		Pack pack = new Pack(numOfPlayers); //mock object created
		Pack pack2 = new Pack(numOfPlayers2);
	
		assertEquals(numOfPlayers, pack.getNumOfPlayers()); //checks if the expected value matches the actual value
		assertEquals(numOfPlayers2, pack2.getNumOfPlayers());
		
	}
    
    /**
     * method tests if method *getpackOutput* returns the actual file expected (output/pack_output.txt)
     * @return void method
     */
    @Test
	public void testGetpackOutput() {
		Pack pack = new Pack(2); //mock pack object
		File output = new File("output/pack_output.txt"); //mock file object
		assertEquals(output, pack.getPackOutput()); //checks if the expected value matches the actual value
	}
    
    /**
     * method tests if method *getPack* returns a not null pack
     * @return void method
     */
    @Test
	public void testGetpack() {
		Pack pack_mock = new Pack(2); //mock pack object
		assertNotNull(pack_mock.getPack()); //checks if the pack is null; valid if pack is not null

	}
    
    /**
     * method tests if the file containing the output is cleared after using method clearFile
     * @return void method
     */
    @Test
	public void testClearFile() {
		Pack pack_mock = new Pack(2); //mock pack object
		pack_mock.createPack();
		pack_mock.clearFile();
		int packClear = pack_mock.getPack().size();
		assertEquals(0, packClear); //checks if the actual value of packClear size equals 0

	}
    
    /**
     * method tests if the created pack is created through method createPack
     * @return void method
     */
    @Test
	public void testCreatePack() {
		Pack pack_mock = new Pack(4); //mock pack object
		pack_mock.createPack();
		int packSize = pack_mock.getPack().size();
		assertNotNull(packSize); //checks if packSize is null; is valid when size is not null
	}
    
    /**
     * method tests if the pack created is a valid one
     * @return void method
     */
    @Test
	public void testIsValid() {
		
		ArrayList<Integer> packTrue = new ArrayList<>(); //mock ArrayList
		
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 4; j++) {
				packTrue.add(i);	
			}
		}

		Pack pack_mock = new Pack();
		
		Boolean isValid = pack_mock.isValid(packTrue);
		
		assertTrue(isValid); //checks if the pack is actually valid

	}
    
    @Test
    public void testReadFile ()  {
		Pack pack = new Pack(4);
        pack.readPack();
    }
	
//	    @Test
//(expected=IllegalArgumentException.class)
//    public void testReadFile2 () throws FileNotFoundException {
//		Pack pack = new Pack(4, "nonExistentOutput");
//        pack.readPack();
//    }
	
    /**
     * method tests a IOExeption for file output/pack_output.txt
     * @return void method
     */
    @Test
    public void testWriteToPack () {
		Pack pack = new Pack(4);
        pack.writeToPack(pack.getPackOutput());     
    }

}
