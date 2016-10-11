package designPatterns.FactoryMethod.example1;

/**
 * Created by Nimrod Golan on 07/08/2016.
 */
public class RoletaGame extends CasinoGameCreator {

    @Override
    public ICasinoGameType createGame() {
        return new RoletaType();
    }
}
