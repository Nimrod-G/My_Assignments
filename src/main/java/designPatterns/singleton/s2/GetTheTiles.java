package designPatterns.singleton.s2;

import java.util.LinkedList;

/**
 * Created by Nimrod Golan on 06/10/2016.
 */
public class GetTheTiles implements Runnable {
    public void run(){

        // How you create a new instance of Singleton

        Singleton newInstance = Singleton.getInstance();

        // Get unique id for instance object

        System.out.println("1st Instance ID: " + System.identityHashCode(newInstance));

        // Get all of the letters stored in the List

        System.out.println(newInstance.getLetterList());

        LinkedList<String> playerOneTiles = newInstance.getTiles(7);

        System.out.println("Player 1: " + playerOneTiles);

        System.out.println("Got Tiles");
    }
}
