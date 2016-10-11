package designPatterns.FactoryMethod.example1;

/**
 * Created by Nimrod Golan on 07/08/2016.
 */
public class BlackJackType implements ICasinoGameType {

    @Override
    public void play() {
        System.out.println("Playing BlackJack!");
    }
}
