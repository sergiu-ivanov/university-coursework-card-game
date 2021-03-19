version 1.0 18-11-2018.

#### About

The application represents a multi-threaded card playing simulation. The game has n players, each numbered 1 to n (which for clarity are named player1, player2, ... , playern, see the illustration in the link below ), with n being a positive integer, and n decks of cards, again, each numbered 1 to n (which for clarity are named deck1, deck2, ... , deckn, see the illustration in the link below ). Each player will hold a hand of 4 cards. Both these hands and the decks will be drawn from a pack which contains 8n cards. Each card has a face value (denomination) of a non-negative integer1.
The decks and players will form a ring topology (see illustration in the link below for the case where n = 4). At the start of the game, each player will be distributed four cards in a round-robin fashion, from the top of the pack, starting by giving one card to player1, then one card to player2, etc. After the hands have been distributed, the decks will then be filled from the remaining cards in the pack, again in a round-robin fashion.

https://user-images.githubusercontent.com/43847681/111757892-bac56200-8893-11eb-8b75-09ff33e68a81.png

Our code provides specific tests for each of the following classes: **Card**, **Pack**, **Player**, **Deck** and **CardGame**. These classes are forming the source code for the following card game: there is a pack of 8 * number_of_players cards which is dealt towards the players in the way each of them will have 4 cards in their hand and 4 cards in the left deck; the game starts with first player drawing a card from the top of the left deck, keeping it in hand and discarding one card from hand to the bottom of the his right deck, which corresponds with next player's left deck; and so on until a player has in his hand 4 cards of the same denomination.

#### Installing and Running the CardGame jar file

1.Unarchive the CardGame.zip

2.In the unarchived folder should be a folder named "output". In case you want to run CardGame.jar in other directory, create a folder named "output" to store output files in the same directory as CardGame.jar file.

3.To run the CardGame jar file use the following command:
java -jar CarGame.jar

Important note:
Make sure before running CardGame.jar to have the folder "output" created, otherwise the application will not find the folder where to store the files.


#### Running the tests

Tests are grouped in a test Suite, named **TestSuite**. They can be run in IDE.

**TestSuite** Class when run, executes the following Test classes in specified order: **CardTest**, **PackTest**, **DeckTest**, **PlayerTest**, **CardGameTest** corresponding to our code classes.

To run the TestSuite do the following:

1.In the eclipse IDE import the project CardGame

2. Open the TestSuite.java and press the button Lunch which is located next to Run button


Additional way to run TestSuite:

Compile and Run java org.junit.runner.JUnitCore TestSuite with your class path


######

* **CardTest**

  Method *testGetFaceValue* tests if the value hold by the card is returned through method *getFaceValue*. A mock object is created each time we want to test a new card value, for the card.



  Example value for valid, positive, card face value (minimum card face value is 1):

  ```java
  int value1 = 2;
  Card card = new Card(value1);
  assertEquals(value1, card.getFaceValue());
  ```

* **PackTest**

  Method *testGetNumOfPlayers* tests if method getNumOfPlayers actually returns the right number of players. A mock object is created every time we want to test how many players use  a specific amount of cards in a pack (8*numOfPlayers).

  ```java
  int numOfPlayers = 2;
  Pack pack = new Pack(numOfPlayers);
  assertEquals(numOfPlayers, pack.getNumOfPlayers());
  ```

  Method *testGetpackOutput* tests if method *getpackOutput* returns the actual file expected (output/pack_output.txt). A mock object is created for testing the expected file for a pack of cards dealt with 2 players.

  ```java
  Pack pack = new Pack(2);
  File output = new File("output/pack_output.txt");
  assertEquals(output, pack.getPackOutput());
  ```

  Method *testGetPack* tests if method *getPack* returns a not null pack. A mock object is created for a pack of cards dealt with 2 players.

  ```java
  Pack pack_mock = new Pack(2);
  assertNotNull(pack_mock.getPack());
  ```

  Method *testClearFile* tests if the file containing the output is cleared after using method *clearFile*. A mock object is created for a pack of cards dealt with 2 players. To test if the file is clear, its size is compared with a value of 0.

  ```java
  Pack pack_mock = new Pack(2);
  pack_mock.createPack();
  pack_mock.clearFile();
  int packClear = pack_mock.getPack().size();
  assertEquals(0, packClear);
  ```

  Method *testCreatePack* tests if the created pack is created through method *createPack*. A mock object is created for a pack of cards dealt with 4 players.  The test works by comparing this mock pack's size with the value of 0.

  ```java
  Pack pack_mock = new Pack(4);
  pack_mock.createPack();
  int packSize = pack_mock.getPack().size();
  assertNotNull(packSize);
  ```

  Method *testIsValid* tests if the pack created is a valid one (with at least 16 cards). A mock list is created to initiate the pack with cards values and a mock object is created for the creation of the pack. *AssertTrue* checks if the pack is valid.

  ```java
  Boolean isValid = pack_mock.isValid(packTrue);
  assertTrue(isValid);
  ```

  Method testWriteToPack tests a IOExeption for file *output/pack_output.txt*.with the use of a mock object, created to for a pack of cards dealt to 4 players.

  ```java
  Pack pack = new Pack(4);
  pack.writeToPack(pack.getPackOutput());
  ```

* **DeckTest**

  Method *testGetDeckNumber* tests if what  method *getDeck_number* returns is the right value of deck's number. A mock object is created and used every time a new deck is created.

  ```java
  Deck deck1 = new Deck(2);
  assertEquals(2, deck1.getDeck_number());
  ```

  Method *testSeeTop* tests if the last card in the deck value is returned correctly by method *seeTop*. To test this we created a mock deck object of 4 cards.

  ```java
  Card card1 = new Card(1);
  Card card2 = new Card(2);
  Card card3 = new Card(3);
  Card card4 = new Card(4);
  Deck deck = new Deck(1);

  deck.addToDeck(card1.getFaceValue());
  deck.addToDeck(card2.getFaceValue());
  deck.addToDeck(card3.getFaceValue());
  deck.addToDeck(card4.getFaceValue());

  assertEquals(card1.getFaceValue(), deck.seeTop());
  ```

  Method *testGetTop* test if the last card in the deck value is returned correctly by method *getTop*. To test this we created a mock deck of 2 cards.

  ```java
  Card card1 = new Card(1);
  Card card2 = new Card(2);
  Deck deck = new Deck(4);

  deck.addToDeck(card1.getFaceValue());
  deck.addToDeck(card2.getFaceValue());

  assertEquals(card1.getFaceValue(), deck.getTop().getFaceValue());
  ```

  Method *testWriteToDeck* tests that for each card added in the deck, it is written in the output file. Mock objects are created for each added card when we run a test.

  ```java
  Card card1 = new Card(1);									Card card2 = new Card(2);
  Deck deck = new Deck(1);
  deck.addToDeck(card1.getFaceValue());
  deck.addToDeck(card2.getFaceValue());
  deck.writeToDeck();
  ```

* **PlayerTest**

  Method *testGetPlayerNumber* tests if method getPlayer_number returns the right player's number. A mock object is used as a player for each time a test is implemented.

  ```java
  Player player = new Player(100);
  assertEquals(100, player.getPlayer_number());
  ```

  Method *testGetPlayerOutput* tests if method *getPlayer_output* returns the right player's File output. A mock object was used for the player (any player) as well as a file *output/player_output.txt*.(corresponding file to player's number).

   ```java
  Player player = new Player(7);
  File output = new File("output/player7_output.txt");
  assertEquals(output, player.getPlayer_output());
   ```

  Method *testFinalHand* tests if method *finalHand* displays player's final hand of cards in file *player_output*. We used mock objects for both player and file to be able to test it.

  ```java
  Player player = new Player(5);
  player.finalHand();
  File output = new File("output/player5_output.txt");
  assertEquals(output, player.getPlayer_output());
  ```

  Method *testCurrentHand* tests if method *currentHand* displays player's current hand of cards in file *player_output*. We used mock objects for both player and file to be able to test it.

  ```java
  Player player = new Player(6);
  player.currentHand();
  File output = new File("output/player6_output.txt");
  assertEquals(output, player.getPlayer_output());
  ```

  Method *testWritePlayerOutput* tests if the player's output is displayed in the right corresponding file, using the mock objects for player with the value as an argument of the number of the player we want to test and file.

  ```java
  Player player = new Player(4);
  File output = new File("output/player4_output.txt");
  player.writeToPlayerOutput(output, "player wins");
  assertEquals(output, player.getPlayer_output());
  ```

  Method *testWin* tests the conditions for a player to win (if the player has cards of the same denomination). We can test multiple times with different values for the cards in hand (using a mock object, player).

  ```java
  Player player = new Player(1);

  player.add_to_hand(1);
  player.add_to_hand(1);
  player.add_to_hand(1);
  player.add_to_hand(1);

  assertTrue(player.win());
  ```

  Method *testAddToHand* tests if the value of the card added in player's hand actually matches the card face value. The test can be run several times by indicating which player adds a card to his hand (using a mock object, player).

  ```java
  Player player = new Player(10);
  player.add_to_hand(10);
  assertEquals(10), player.getHand_cards().get(0).getFaceValue());
  ```

  Method *testInitailHand* tests if method *initialHand* displays player's initial hand of cards in file *player_output*. We used mock objects for both player and file to be able to test it.

  ```java
  Player player = new Player(7);
  player.initialHand();
  File output = new File("output/player7_output.txt");
  assertEquals(output, player.getPlayer_output());
  ```

  Method *testDraw* tests if after the card drawn from the deck by theplayer, the output is the one expected. The use of mock objects for player, deck and file makes possible to test several times for different card values.

  ```java
  Player player = new Player(8);
  Deck deck = new Deck(8);
  deck.addToDeck(2);
  deck.addToDeck(6);
  deck.addToDeck(5);
  deck.addToDeck(1);
  player.draw(deck);
  File output = new File("output/player8_output.txt");
  assertEquals(output, player.getPlayer_output());
  ```

  Method *testDiscard* tests the operation of discarding a card from the deck and displaying the output after that, which has to be in concordance with the action completed. The use of mock objects for player, deck and file makes possible to test several times for different card values.

  ```java
  Player player = new Player(8);
  player.add_to_hand(2);
  Deck deck = new Deck(8);
  player.discard(deck);
  File output = new File("output/player8_output.txt");
  assertEquals(output, player.getPlayer_output());
  ```

* **CardGameTest**

  Method *testCreatePack* tests if the pack created is a valid one for the number of players introduced. Mock Object Pack was used for the test to implement the number of players.

  ```java
  Pack pack = new Pack(4);
  CardGame.createPack(pack);
  assertTrue(!pack.getPack().isEmpty());
  ```

  Method  *testCreatePlayers* tests if the card game is played by any players using mock object Pack.

  ```java
  ArrayList<Player> players = new ArrayList<Player>();
  assertTrue(players.isEmpty());
  CardGame.createPlayers(4,  players);
  assertTrue(!players.isEmpty());
  ```

  Method *testCreateDeck* tests if the deck created is empty or not, using a mock arrayList to initialize the deck.

  ```java
  ArrayList<Deck> decks = new ArrayList<Deck>();
  assertTrue(decks.isEmpty());
  CardGame.createDeck(5, decks);
  assertTrue(!decks.isEmpty());
  ```

  Method *testWritePlayersOutput* tests if the players in concordance with the new mock object, pack generated can be outputed in the CardGame.

  ```java
  ArrayList<Player> players = new ArrayList<Player>();
  Pack pack = new Pack(2);
  CardGame.writePlayersOutput(players, pack);
  ```

  Method testWriteDeckOutput tests if the decks in concordance with the new mock object, pack generated can be outputed in the CardGame.

  ```java
  ArrayList<Deck> decks = new ArrayList<Deck>()
  Pack pack = new Pack(3);
  CardGame.writeDeckOutput(decks, pack);
  ```


#### Authors

Sergiu Ivanov

Dana Buzatu







