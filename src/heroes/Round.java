package heroes;

public class Round {
    public Round() {

    }
    /*batalia propriu-zisa*/
     public final void battle(final Player player1, final Player player2) {
        if (!player1.isDead() && !player2.isDead()) {
            player1.attackPlayer(player2);
            player1.setBattled(true);
            player2.attackPlayer(player1);
            player1.setBattled(false);
            player1.setDead();
            player2.setDead();
            if (player1.getHp() == 0) {
                player2.setXpUp(player1);
                player2.lvUp();
            }
            if (player2.getHp() == 0) {
                player1.setXpUp(player2);
                player1.lvUp();
            }
        }
     }

    public final void gameRounds(final Player[] player, final int nrPlayer,
                                 final String direction) {
         /*misca eroul*/
        for (int i = 0; i < nrPlayer; i++) {
            if (!player[i].getRoundStun() && !player[i].isDead()) {
                player[i].direction(direction.charAt(i));
            }
            if (!player[i].isDead()) {
                player[i].takeDmgOverTime();
            }
            if (player[i].getHp() <= 0) {
                player[i].setDead();
            }
        }
        /*incepe batalia*/
        for (int i = 0; i < nrPlayer - 1; i++) {
            for (int j = i + 1; j < nrPlayer; j++) {
                if (player[i].getNPosition() == player[j].getNPosition()
                        && player[i].getMPosition() == player[j].getMPosition()
                        && player[i].getMPosition()
                        != -1) {
                    this.battle(player[i], player[j]);
                }
            }
        }
    }
}
