package heroes.pyromancer;

import heroes.Player;
import heroes.PlayerAbilities;
import heroes.knight.Knight;
import heroes.knight.KnightAbilities;
import heroes.rogue.Rogue;
import heroes.rogue.RogueAbilities;
import heroes.wizard.Wizard;
import heroes.wizard.WizardAbilities;
import main.Map;

public class Pyromancer extends Player {
    protected int startHp = 500;

    public Pyromancer(final int N, final int M, final Map map) {
        super("P", map, new PyromancerAbilities(), N, M);
    }

    public void isAttackedBy(Pyromancer attacker) {
        int damageFireblast = Math.round(this.getAbilities().ability1(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(), attacker.getNPosition(), attacker.getMPosition()));
        int damageIgnite = Math.round(this.getAbilities().ability2(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(), attacker.getNPosition(), attacker.getMPosition()));
        int totalDmg = damageFireblast + damageIgnite;
    }

    public void isAttackedBy(Knight attacker) {
        int damageExecute = Math.round(this.getAbilities().ability1(this)
                * attacker.terrainModifier(this.map));
        int damageSlam = Math.round(this.getAbilities().ability2(this)
                * attacker.terrainModifier(this.map));
        int totalDmg = damageExecute + damageSlam;
    }

    public void isAttackedBy(Rogue attacker) {
        int damageBackstab = Math.round(this.getAbilities().ability1(this)
                * attacker.terrainModifier(this.map));
        int damageParalysis = Math.round(this.getAbilities().ability2(this)
                * attacker.terrainModifier(this.map));
        int totalDmg = damageBackstab + damageParalysis;
    }

    public void isAttackedBy(Wizard attacker) {
        int damageDrain = Math.round(this.getAbilities().ability1(this)
                * attacker.terrainModifier(this.map));
        int damageDeflect = Math.round(this.getAbilities().ability2(this)
                * attacker.terrainModifier(this.map));
        int totalDmg = damageDeflect + damageDrain;
    }

    public void attackPlayer(Player enemy) {
        enemy.isAttackedBy(this);
    }

    public final void lvUp() {
        if (this.getLvUp() > 0) {
            this.startHp = this.startHp + 50 * this.getLvUp();
            this.hp = this.startHp;
            this.lv = this.lv + this.getLvUp();
            this.getAbilities().dmgUp(this.getLvUp());
        }
    }

    public final boolean roundEffect() {
        return false;
    }

/*    public final void dmgTake(final Player Enemy, final Map map) {
        Enemy.takeDmg(Math.round(this.getAbilities().getTotalDmg(Enemy, map)
        * this.getAbilities().terrainModifier(map, NPosition, MPosition)));
    }*/

   /* public final int dmgNotModTake(final Player Enemy, final Map map) {
        return Math.round(this.getAbilities().getDmgNotMod(Enemy, map)
        * this.terrainModifier(map));
    }*/
}
