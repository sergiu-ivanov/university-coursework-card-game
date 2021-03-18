package cardgame;

import java.io.File;
import java.util.*;
/**
 * CardGame is used to execute the game.
 * 
 *
 * @author Sergiu Ivanov and Dana Buzatu.
 * @version 1.0 18-11-2018.
 */

public class CardGame {
	/**
     * A static method that creates a pack of cards.
     * This method call the createPack() method from pack class upon its argument.
     *
     *@param pack represents a Pack object
     * @return true means a valid pack
     */
    public static void createPack(Pack pack){
        Boolean isTrue = true;
        do {
            pack.createPack();
            pack.writeToPack(pack.getPackOutput());//write to Pack_output.txt the pack content
            pack.readPack();
            if (pack.isValid(pack.getPack())) {
                System.out.printf("The pack is valid, the location of the pack is: %s \n\n", pack.getPackOutput());
                isTrue = false;
            }else {
                System.out.println("This pack is not valid, another pack is generating...\n");
                pack.clearFile();
            }
        }while (isTrue);
    }
    /**
     * A static method that creates Players and add them to the Player Arraylist.
     *
     *@param p represents an Arraylist of players
     *@param n represent player's number
     */
    public static void createPlayers(int n, ArrayList<Player> p) {
        for(int i = 1; i< n+1; i++) {
            p.add(new Player(i));
        }
    }
    /**
     * A static method that creates Deck and add them to the  Deck Arraylist.
     *
     *@param p represents an Arraylsit of decks
     *@param n represent deck's number
     */
    public static void createDeck(int n, ArrayList<Deck> p) {
        for(int i = 1; i< n+1; i++) {
            p.add(new Deck(i));
        }
    }

    /**
     * A static method that clear all files in the folder "output".
     * It is used when the game is executed multiple times, so the buffered 
     * writer in other classes don't append new results to the old ones
     *
     */
    public static void clearFolder(){
        File file = new File("output");
        String[] files;
        if(file.isDirectory()){
            files = file.list();
            for (int i=0; i<files.length; i++) {
                File myFile = new File(file, files[i]);
                myFile.delete();
            }
        }else{
            System.out.println(" There is not such directory ");
        }
    }
    /**
     * A static method that distribute 4 cards to each player in round-robin fashion
     *
     *@param players represents an Arraylsit of players
     *@param pack represent  a pack of cards
     */
    public static void writePlayersOutput(ArrayList<Player> players, Pack pack){
        int index = 0;
        for (int i = 1; i<=4; i++){
            for (Player player: players){
                player.add_to_hand(pack.getPack().get(index));// set the value of i to players list
                index++;
            }
        }
    }
    /**
     * A static method that distribute 4 cards to each deck in round-robin fashion
     *
     *@param decks represents an Arraylsit of decks
     *@param pack represent  a pack of cards
     */
    public static void writeDeckOutput(ArrayList<Deck> decks, Pack pack){
        int index = pack.getNumOfPlayers() * 4;
        for (int i = 1; i<=4; i++){
            for (Deck deck: decks){
                deck.addToDeck(pack.getPack().get(index));
                index++;
            }
        }
    }
    /**
     * A static method ask the user for input, warns if it is not an integer 
     * or the number of players is less than two and returns the user's input.
     *
     *@return value means the user's value
     */
    public static int startGame() {
        Scanner in = new Scanner(System.in);
        int value = 0;
        boolean done = false;
        while (!done) {
            try {
                System.out.print("Please enter the number of players: ");
                value = in.nextInt();
                if (value <= 1){
                    System.out.println("The game cannot start with less than 2 players, please enter a value bigger than 1");
                }else {
                    done = true;

                }

            }catch(InputMismatchException e){
                System.out.println("Wrong input, please type in an integer ");
                in.nextLine();
                }
            }
            return value;
        }
    
    /**
     * execute the program
     *
     * @param args String array for input
     */

    public static void main(String[] args) throws  IllegalThreadStateException {
        clearFolder();
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Deck> decks = new ArrayList<Deck>();
        Pack pack = new Pack(startGame());
        int num = pack.getNumOfPlayers();
        createPack(pack);
        createPlayers(num, players);// create  players and add them to arrayList players
        createDeck(num, decks);
        writePlayersOutput(players, pack);
        writeDeckOutput(decks, pack);

        boolean done = true;
        for(Player player:players) {
            player.initialHand();
        }
        // check if there is a winner that wins immediately after cards distribution
        for (Player player: players){
            if (player.win()) {
                for(Player player2:players) {
                    decks.get(player2.getPlayer_number() - 1).writeToDeck();
                }
                System.out.println("Player " + player.getPlayer_number() + " wins");
                String winner = "Player " + player.getPlayer_number()+ " wins\n"
                        + "Player " + player.getPlayer_number() + " exits" ;
                player.writeToPlayerOutput(player.getPlayer_output(), winner);
                System.out.println("Player " + player.getPlayer_number() + " exits");
                player.finalHand();
                done = false;
                break;
            }
        }


        while (done){
        // an array list for seting up the threads and prepare them for starting point
            ArrayList<Thread> threads = new ArrayList<Thread>();
            for (int i = 0; i < players.size(); i++) {
                threads.add(new Thread( Integer.toString(i) ) {
                    public void run() {// anonymmous thread class run method
                        int j = Integer.parseInt(this.getName());
                        if (players.get(j).getPlayer_number() == decks.size()){
                            players.get(j).draw(decks.get(j));
                            players.get(j).discard(decks.get(0));
                            players.get(j).currentHand();

                        }else{
                            players.get(j).draw(decks.get(j));
                            players.get(j).discard(decks.get(j+1));
                            players.get(j).currentHand();
                        }
                    }
                });
            }

            // an array list of winners.
            ArrayList<Player> winner = new ArrayList<Player>();
            for ( Thread thread : threads){
                try {
                    thread.start();
                    thread.join();
                }catch (InterruptedException | IndexOutOfBoundsException err){
                    System.out.println("Interrupted or IndexOutOfBounds exception");
                }
                int i = Integer.parseInt(thread.getName());
                if(players.get(i).win()){
                    winner.add(players.get(i));
                }
            }


            if (!winner.isEmpty()){
            	// the first winner in the list is anounce  the winner
                String winnerString ="Player " + winner.get(0).getPlayer_number() + " wins\n"
                + "Player " + winner.get(0).getPlayer_number() + " exits";
                winner.get(0).writeToPlayerOutput(winner.get(0).getPlayer_output(), winnerString);
                System.out.println(winnerString);
                winner.get(0).finalHand();
                done = false;
                for (Deck deck: decks){
                    deck.writeToDeck();
                }
            }
        }
        System.out.println("The game has ended");


        

    }

}
