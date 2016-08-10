package designPatterns.singleton.FactoryMethod.example1;

/**
 * Created by Nimrod Golan on 07/08/2016.
 */
public class CasinoTest {

    public static void main(String[] args) {

        CasinoGameCreator casinoGameCreator = new BlackJackGame();
        casinoGameCreator.playGame();

        casinoGameCreator = new PokerGame();
        casinoGameCreator.playGame();

        casinoGameCreator = new RoletaGame();
        casinoGameCreator.playGame();
    }
}
