package heroes.pyromancer;

import heroes.Player;
import heroes.PlayerAbilities;
import heroes.knight.Knight;
import heroes.knight.KnightAbilities;
import heroes.rogue.Rogue;
import heroes.rogue.RogueAbilities;
import heroes.wizard.Wizard;
import heroes.wizard.WizardAbilities;
import heroes.pyromancer.PyromancerAbilities;
import main.Map;

public class Pyromancer extends Player {
    protected int startHp = 500;

    public Pyromancer(final int N, final int M, final Map map) {
        super("P", map, new PyromancerAbilities(), N, M);
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
        if (attacker.getAbilities().terrainModifier(attacker.getMap(), attacker.getNPosition(), attacker.getMPosition()) != 0) {
            int x = 2;
        }
        int damageBackstab =Math.round(attacker.getAbilities().ability1(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        int damageParalysis =Math.round(attacker.getAbilities().ability2(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));

        int totalDmg = damageBackstab + damageParalysis;
    }

    public void isAttackedBy(Wizard attacker) {
        float damageDrain = attacker.getAbilities().ability1(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition());
        damageDrain = damageDrain * Math.min(0.3f * this.startHp, this.getHp());
        float damageDeflect =Math.round(attacker.getAbilities().ability2(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        damageDeflect = damageDeflect * this.dmgNoModifier();
        int totalDmg = Math.round(damageDeflect) + Math.round(damageDrain);
        this.takeDmg(totalDmg);
    }

    public void attackPlayer(Player enemy) {
        enemy.isAttackedBy(this);
    }

    public final void lvUp() {
        if (this.getLvUp() > 0) {
            this.startHp = this.startHp + 50 * this.getLvUp();
            this.setHp(this.startHp);
            this.setLv(this.getLv() + this.getLvUp());
            this.getAbilities().dmgUp(this.getLvUp());
        }
    }

    public final boolean roundEffect() {
        return false;
    }



}
