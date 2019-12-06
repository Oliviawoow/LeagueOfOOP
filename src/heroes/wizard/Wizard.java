package heroes.wizard;

import heroes.Player;
import heroes.PlayerAbilities;
import heroes.knight.Knight;
import heroes.knight.KnightAbilities;
import heroes.rogue.Rogue;
import heroes.rogue.RogueAbilities;
import heroes.pyromancer.Pyromancer;
import heroes.pyromancer.PyromancerAbilities;
import main.Map;

public class Wizard extends Player {
    protected int startHp = 400;

    public Wizard(final int N, final int M, final Map map) {
        super("W", map, new WizardAbilities(), N, M);
    }

    public void isAttackedBy(Pyromancer attacker) {
        int damageFireblast = Math.round(this.getAbilities().ability1(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        int damageIgnite = Math.round(this.getAbilities().ability2(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        int totalDmg = damageFireblast + damageIgnite;
        this.takeDmg(totalDmg);
    }

    public void isAttackedBy(Knight attacker) {
        int damageExecute =Math.round(this.getAbilities().ability1(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        int damageSlam =Math.round(this.getAbilities().ability2(this)
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
        int damageBackstab =Math.round(this.getAbilities().ability1(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        int damageParalysis =Math.round(this.getAbilities().ability2(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        int totalDmg = damageBackstab + damageParalysis;
    }

    public void isAttackedBy(Wizard attacker) {
        int damageDrain = Math.round(this.getAbilities().ability1(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        int damageDeflect =Math.round(this.getAbilities().ability2(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        int totalDmg = damageDeflect + damageDrain;
    }

    public void attackPlayer(Player enemy) {
        enemy.isAttackedBy(this);
    }

    public final void lvUp() {
        if (this.getLvUp() > 0) {
            this.startHp = this.startHp + 30 * this.getLvUp();
            this.setHp(this.startHp);
            this.setLv(this.getLv() + this.getLvUp());
            this.getAbilities().dmgUp(this.getLvUp());
        }
    }

    public final boolean roundEffect() {
        return false;
    }

}
