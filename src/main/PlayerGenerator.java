package main;

import heroes.Player;
import heroes.knight.Knight;
import heroes.pyromancer.Pyromancer;
import heroes.rogue.Rogue;
import heroes.wizard.Wizard;
import main.Map;

/*creaza un erou de un anumit tip*/
public final class PlayerGenerator {
    public static final PlayerGenerator instance = new PlayerGenerator();
    private PlayerGenerator() {

    }

    /*in functie de tip se defineste eroul si pozitia lui initiala pe harta*/
    public Player generatePlayer(final String type, final int N, final int M, final Map map) {
        if (type.equals("K")) {
            return new Knight(N, M, map);
        } else if (type.equals("P")) {
            return new Pyromancer(N, M, map);
        } else if (type.equals("R")) {
            return new Rogue(N, M, map);
        } else if (type.equals("W")) {
            return new Wizard(N, M, map);
        } else {
            return null;
        }
    }
}
