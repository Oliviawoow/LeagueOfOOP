package heroes.wizard;

import heroes.Player;
import heroes.PlayerAbilities;
import heroes.knight.Knight;
import heroes.pyromancer.Pyromancer;
import heroes.rogue.Rogue;
import main.Map;

public class WizardAbilities extends PlayerAbilities {
    private float dmg1 = 0.2f;
    private float dmg2 = 0.35f;

    public WizardAbilities() {
        super();
    }

    public final float getFirstAbilityClassModifier (final Pyromancer enemy) {
        return -0.1f;
    }
    public final float getFirstAbilityClassModifier (final Knight enemy) {
        return 0.2f;
    }
    public final float getFirstAbilityClassModifier (final Wizard enemy) {
        return 0.05f;
    }
    public final float getFirstAbilityClassModifier (final Rogue enemy) {
        return -0.2f;
    }

    public final float getSecondAbilityClassModifier (final Pyromancer enemy) {
        return 0.3f;
    }
    public final float getSecondAbilityClassModifier (final Knight enemy) {
        return 0.4f;
    }
    public final float getSecondAbilityClassModifier (final Wizard enemy) {
        return 0f;
    }
    public final float getSecondAbilityClassModifier (final Rogue enemy) {
        return 0.2f;
    }

    public final void dmgUp(int nrLv) {
        this.dmg1 = this.dmg1 + 0.05f * nrLv;
        this.dmg2 =this.dmg2 + 0.02f * nrLv;

    }

    public final float terrainModifier(final Map map, final int NPosition, final int MPosition) {
        char type = map.getType(NPosition, MPosition);
        if (type == 'D') {
            return 0.1f;
        }
        return 0f;
    }

    public final float ability1(final Pyromancer enemy) {
        return dmg1 * this.getFirstAbilityClassModifier(enemy);
    }
    public final float ability1(final Knight enemy) {
        return Math.round(dmg1 * this.getFirstAbilityClassModifier(enemy));
    }
    public final float ability1(final Rogue enemy) {
        return Math.round(dmg1 * this.getFirstAbilityClassModifier(enemy));
    }
    public final float ability1(final Wizard enemy) {
        return Math.round(dmg1 * this.getFirstAbilityClassModifier(enemy));
    }

    public final float ability2(final Pyromancer enemy) {
        return dmg2 * this.getSecondAbilityClassModifier(enemy);
    }
    public final float ability2(final Knight enemy) {
        return Math.round(dmg2 * this.getSecondAbilityClassModifier(enemy));
    }
    public final float ability2(final Rogue enemy) {
        return Math.round(dmg2 * this.getSecondAbilityClassModifier(enemy));
    }
    public final float ability2(final Wizard enemy) {
        return Math.round(dmg2 * this.getSecondAbilityClassModifier(enemy));
    }

   /* public final int getDmgMod(final Player Enemy, final Map map) {
        return Math.round(fireblast(Enemy) + ignite(Enemy, map));
    }
    public final float getTotalDmg(final Player Enemy, final Map map) {
        return fireblast(Enemy) + ignite(Enemy, map);
    }*/

}
