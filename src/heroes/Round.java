package heroes;

import main.Map;
import heroes.Player;

public class Round {
    public Round() {

    }
     public final void battle(final Player player1, final Player player2, final Map map) {
        if (!player1.isDead() && !player2.isDead()) {
            player1.attackPlayer(player2);
            player2.attackPlayer(player1);
            player1.setDead();
            player2.setDead();
        }
     }
}
