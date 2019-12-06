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
    private static final PyromancerAbilities instance = new PyromancerAbilities();

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

    public final float fireblast(final Pyromancer enemy) {
        return dmg1 * this.getFirstAbilityClassModifier(enemy);
    }
    public final float fireblast(final Knight enemy) {
        return Math.round(dmg1 * this.getFirstAbilityClassModifier(enemy));
    }
    public final float fireblast(final Rogue enemy) {
        return Math.round(dmg1 * this.getFirstAbilityClassModifier(enemy));
    }
    public final float fireblast(final Wizard enemy) {
        return Math.round(dmg1 * this.getFirstAbilityClassModifier(enemy));
    }

    public final float ignite(final Pyromancer enemy) {
        return dmg2 * this.getSecondAbilityClassModifier(enemy);
    }
    public final float ignite(final Knight enemy) {
        return Math.round(dmg2 * this.getSecondAbilityClassModifier(enemy));
    }
    public final float ignite(final Rogue enemy) {
        return Math.round(dmg2 * this.getSecondAbilityClassModifier(enemy));
    }
    public final float ignite(final Wizard enemy) {
        return Math.round(dmg2 * this.getSecondAbilityClassModifier(enemy));
    }

    public final int getDmgMod(final Player Enemy, final Map map) {
        return Math.round(fireblast(Enemy) + ignite(Enemy, map));
    }
    public final float getTotalDmg(final Player Enemy, final Map map) {
        return fireblast(Enemy) + ignite(Enemy, map);
    }

    public static PyromancerAbilities getInstance() {
        return instance;
    }
}
