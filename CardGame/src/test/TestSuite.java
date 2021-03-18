package test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * TestSuite is used to run all the test classes in a specific order
 *
 * @author Sergiu Ivanov and Dana Buzatu.
 * @version 19-11-2018.
 */

@RunWith(Suite.class) 
@Suite.SuiteClasses({CardTest.class, PackTest.class, DeckTest.class, PlayerTest.class, 
	CardGameTest.class,}) 

public class TestSuite {}

