package heroes.rogue;

import heroes.Player;
import heroes.PlayerAbilities;
import heroes.knight.Knight;
import heroes.knight.KnightAbilities;
import heroes.pyromancer.Pyromancer;
import heroes.pyromancer.PyromancerAbilities;
import heroes.wizard.Wizard;
import heroes.wizard.WizardAbilities;
import main.Map;

public class Rogue extends Player {
    protected int startHp = 600;
    private int battles = 0;

    public Rogue(final int N, final int M, final Map map) {
        super("R", map, new RogueAbilities(), N, M);
    }

    public void isAttackedBy(Pyromancer attacker) {
        int damageFireblast = Math.round(attacker.getAbilities().ability1(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        int damageIgnite = Math.round(attacker.getAbilities().ability2(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        int totalDmg = damageFireblast + damageIgnite;
        this.takeDmg(totalDmg);
    }

    public void isAttackedBy(Knight attacker) {
        int damageExecute =Math.round(attacker.getAbilities().ability1(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        int damageSlam =Math.round(attacker.getAbilities().ability2(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        int totalDmg = damageExecute + damageSlam;
        if (this.getHp() <= this.startHp * Math.min(0.4f, 0.2f + 0.1f * getLvUp())){
            this.setDead();
        } else {
            this.takeDmg(totalDmg);
        }
    }

    public void isAttackedBy(Rogue attacker) {
        int damageBackstab =Math.round(attacker.getAbilities().ability1(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        int damageParalysis =Math.round(attacker.getAbilities().ability2(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        int totalDmg = damageBackstab + damageParalysis;
    }

    public void isAttackedBy(Wizard attacker) {
        int damageDrain = Math.round(attacker.getAbilities().ability1(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        int damageDeflect =Math.round(attacker.getAbilities().ability2(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        int totalDmg = damageDeflect + damageDrain;
    }

    public void attackPlayer(Player enemy) {
        enemy.isAttackedBy(this);
    }

    public final void lvUp() {
        if (this.getLvUp() > 0) {
            this.startHp = this.startHp + 40 * this.getLvUp();
            this.setHp(this.startHp);
            this.setLv(this.getLv() + this.getLvUp());
            this.getAbilities().dmgUp(this.getLvUp());
        }
    }

    public final int getBattles() {
        return battles;
    }

    public final void incrementBattles() {
        battles++;
    }

    public final boolean roundEffect() {
        return false;
    }


}
