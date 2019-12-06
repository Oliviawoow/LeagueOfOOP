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
        super("P", map, new PyromancerAbilities());
        this.NPosition = N;
        this.MPosition = M;
    }

    public void isAttackedBy(Pyromancer attacker) {
        int damageFireblast = Math.round(this.getAbilities().ability1(this)
                * attacker.terrainModifier(this.map));
        int damageIgnite = Math.round(PyromancerAbilities.getInstance().ignite(this)
                * attacker.terrainModifier(this.map));
        int totalDmg = damageFireblast + damageIgnite;
    }

    public void isAttackedBy(Knight attacker) {
        int damageExecute = Math.round(KnightAbilities.getInstance().execute(this)
                * attacker.terrainModifier(this.map));
        int damageSlam = Math.round(KnightAbilities.getInstance().slam(this)
                * attacker.terrainModifier(this.map));
        int totalDmg = damageExecute + damageSlam;
    }

    public void isAttackedBy(Rogue attacker) {
        int damageBackstab = Math.round(RogueAbilities.getInstance().backstab(this)
                * attacker.terrainModifier(this.map));
        int damageParalysis = Math.round(RogueAbilities.getInstance().paralysis(this)
                * attacker.terrainModifier(this.map));
        int totalDmg = damageBackstab + damageParalysis;
    }

    public void isAttackedBy(Wizard attacker) {
        int damageDrain = Math.round(WizardAbilities.getInstance().drain(this)
                * attacker.terrainModifier(this.map));
        int damageDeflect = Math.round(WizardAbilities.getInstance().deflect(this)
                * attacker.terrainModifier(this.map));
        int totalDmg = damageDeflect + damageDrain;
    }

    public void attackPlayer(Player enemy) {
        enemy.isAttackedBy(this);
    }

    public final float terrainModifier(final Map map) {
        char type = map.getType(this.NPosition, this.MPosition);
        if (type == 'V') {
            return 0.25f;
        }
        return 0f;
    }

    public final void lvUp() {
        if (this.getLvUp() > 0) {
            this.startHp = this.startHp + 50 * this.getLvUp();
            this.hp = this.startHp;
            this.lv = this.lv + this.getLvUp();
            PyromancerAbilities.getInstance().dmgUp(this.getLvUp());
        }
    }

    public final boolean roundEffect() {
        return false;
    }

    public final void dmgTake(final Player Enemy, final Map map) {
        Enemy.takeDmg(Math.round(PyromancerAbilities.getInstance().getTotalDmg(Enemy, map)
        * this.terrainModifier(map)));
    }

    public final int dmgNotModTake(final Player Enemy, final Map map) {
        return Math.round(PyromancerAbilities.getInstance().getDmgNotMod(Enemy, map)
        * this.terrainModifier(map));
    }
}
