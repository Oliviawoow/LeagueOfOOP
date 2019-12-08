package main;

import heroes.Player;
import heroes.knight.Knight;
import heroes.pyromancer.Pyromancer;
import heroes.rogue.Rogue;
import heroes.wizard.Wizard;

/*creaza un erou de un anumit tip*/
public final class PlayerGenerator {
    public static final PlayerGenerator INSTANCE = new PlayerGenerator();
    private PlayerGenerator() {

    }

    /*in functie de tip se defineste eroul si pozitia lui initiala pe harta*/
    public Player generatePlayer(final String type, final int n, final int m, final Map map) {
        if (type.equals("K")) {
            return new Knight(n, m, map);
        } else if (type.equals("P")) {
            return new Pyromancer(n, m, map);
        } else if (type.equals("R")) {
            return new Rogue(n, m, map);
        } else if (type.equals("W")) {
            return new Wizard(n, m, map);
        } else {
            return null;
        }
    }
}
