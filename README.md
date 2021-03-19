version 1.0 18-11-2018.

#### About

The application represents a multi-threaded card playing simulation. The game has n players, each numbered 1 to n (which for clarity are named player1, player2, ... , playern, see the illustration in the link below ), with n being a positive integer, and n decks of cards, again, each numbered 1 to n (which for clarity are named deck1, deck2, ... , deckn, see the illustration in the link below ). Each player will hold a hand of 4 cards. Both these hands and the decks will be drawn from a pack which contains 8n cards. Each card has a face value (denomination) of a non-negative integer1.
The decks and players will form a ring topology (see illustration in the link below for the case where n = 4). At the start of the game, each player will be distributed four cards in a round-robin fashion, from the top of the pack, starting by giving one card to player1, then one card to player2, etc. After the hands have been distributed, the decks will then be filled from the remaining cards in the pack, again in a round-robin fashion.

https://user-images.githubusercontent.com/43847681/111757892-bac56200-8893-11eb-8b75-09ff33e68a81.png

The code provides specific tests for each of the following classes: **Card**, **Pack**, **Player**, **Deck** and **CardGame**. These classes are forming the source code for the following card game: there is a pack of 8 * number_of_players cards which is dealt towards the players in the way each of them will have 4 cards in their hand and 4 cards in the left deck; the game starts with first player drawing a card from the top of the left deck, keeping it in hand and discarding one card from hand to the bottom of the his right deck, which corresponds with next player's left deck; and so on until a player has in his hand 4 cards of the same denomination.


