package designPatterns.singleton.FactoryMethod.example1;

/**
 * Created by Nimrod Golan on 07/08/2016.
 */
public abstract class CasinoGameCreator {

    public void playGame() {
        ICasinoGameType gameType = createGame();
        gameType.play();
    }

    public abstract ICasinoGameType createGame();
}
