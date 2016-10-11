package designPatterns.singleton.s2;

/**
 * Created by Nimrod Golan on 06/10/2016.
 */
public class ScrabbleTestThreads {
    public static void main(String[] args){

        // Create a new Thread created using the Runnable interface
        // Execute the code in run after 10 seconds

        Runnable getTiles = new GetTheTiles();

        Runnable getTilesAgain = new GetTheTiles();

        // Call for the code in the method run to execute

        new Thread(getTiles).start();
        new Thread(getTilesAgain).start();

    }
}
