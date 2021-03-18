package cardgame;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Pack is used for pack creation, validity check, 
 * writing and reading the output of a pack.
 *
 * @author Sergiu Ivanov and Dana Buzatu.
 * @version 1.0 18-11-2018.
 */
public class Pack{

    private   ArrayList<Integer> pack = new ArrayList<>();
    private int packSize ;
    private int numOfPlayers ;
    private File packOutput ;

    public Pack() {}
    
    public Pack(int numOfPlayers) {
        packSize = numOfPlayers * 8;
        this.numOfPlayers = numOfPlayers;
        this.packOutput = new File("output/pack_output.txt");
    }

    /**
     * A simple getter that  returns the number of players
     *@return numOfPlayers means number of players
     */
    public int getNumOfPlayers() {
        return numOfPlayers;
    }
    
    /**
     * A simple getter that  returns the pack output
     *@return packOutput means pack output
     */
    public File getPackOutput() {
        return packOutput;
    }
    
    /**
     * A simple getter that  returns the pack
     *@return pack means pack
     */
    public ArrayList<Integer> getPack() {
        return pack;
    }
    
    /**
     * ClearFile empty the arraylist pack
     *
     */
    public void clearFile() {
        pack.clear();
    }

    /**
     * CreatePack creates a pack of cards with the size of 8 * number of 
     * players  with the lowest bound of 1 and highest bound equal to the number of players
     *
     */
    public void createPack() {
        System.out.println("Creating a pack ...\n");
        for (int i = 0; i < packSize ; i++) {
            Random r = new Random();
            final int lowest= 1;
            int highest = numOfPlayers +1;// +1 because i =0, but players start with 1
            int rand = r.nextInt(highest-lowest) + lowest; // low inclusive , high exclusive
            pack.add(rand);
        }
    }

    /**
     * Returns true if a pack is valid and false otherwise
     *@return isValid means true or false
     */
    public Boolean isValid(ArrayList<Integer> pack) {
        boolean isValid = false;
        int count = 0;
        for (int i = 1; i < pack.size(); i++) {
            int count2 = 0;
            for(Integer j: pack) {
                if ( i == j) {
                    count2++;
                }
            }// at least 4 cards with the same value
            if(count2 >= 4) {
                count++;
            }
        }
        if(count >= numOfPlayers) {
            isValid = true;
        }
        return isValid;
    }
    
    /**
     * WriteToPack writes the string to a file
     *
     *@param path is the file path
     */
    public void writeToPack( File path)  {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            System.out.println("*** Writing to "+ packOutput + " ***");
            for (Integer o: pack) {
                writer.write(String.valueOf(o));
                writer.newLine();
            }
            writer.close();
        }catch (IOException ex) {
            System.out.println("The file cannot be found.");
        }
    }
    
    /**
     * ReadPack reads the content of a file
     *
     */
    public void readPack() {
        try{
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(packOutput));
            String line = bufferedReader.readLine();
            System.out.println("*** Reading from "+ packOutput + " ***");
            while(line != null){
                System.out.print(line + " ");
                line = bufferedReader.readLine();
            }
            System.out.println();
            bufferedReader.close();//Always close it.
        } catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }


}