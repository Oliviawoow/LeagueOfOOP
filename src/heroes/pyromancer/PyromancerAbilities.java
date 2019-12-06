package heroes.pyromancer;

import heroes.Player;
import heroes.PlayerAbilities;
import heroes.knight.Knight;
import heroes.wizard.Wizard;
import heroes.rogue.Rogue;
import main.Map;

public class PyromancerAbilities extends PlayerAbilities {
    private int dmg1 = 350;
    private int dmg2 = 150;
    private int dmgPerRound = 50;
    private int affectedRounds = 0;

    public PyromancerAbilities() {
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
        return -0.1f;
    }
    public final float getSecondAbilityClassModifier (final Knight enemy) {
        return 0.2f;
    }
    public final float getSecondAbilityClassModifier (final Wizard enemy) {
        return 0.05f;
    }
    public final float getSecondAbilityClassModifier (final Rogue enemy) {
        return -0.2f;
    }

    public final void dmgUp(int nrLv) {
        this.dmg1 = this.dmg1 + 50 * nrLv;
        this.dmg2 =this.dmg2 + 20 * nrLv;
        this.dmgPerRound = this.dmgPerRound + 30 * nrLv;

    }

    public final float terrainModifier(final Map map, final int NPosition, final int MPosition) {
        char type = map.getType(NPosition, MPosition);
        if (type == 'V') {
            return 0.25f;
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

    public final float getDmg1() {
        return dmg1;
    }

    public final float getDmg2() {
        return dmg2;
    }

    public final int getDmgPerRound() {
        return dmgPerRound;
    }

    public final int affectedRounds() {
        return affectedRounds;
    }

    /* public final int getDmgMod(final Player Enemy, final Map map) {
        return Math.round(fireblast(Enemy) + ignite(Enemy, map));
    }
    public final float getTotalDmg(final Player Enemy, final Map map) {
        return fireblast(Enemy) + ignite(Enemy, map);
    }*/

}
