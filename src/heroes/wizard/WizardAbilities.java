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
        return 0.9f;
    }
    public final float getFirstAbilityClassModifier (final Knight enemy) {
        return 1.2f;
    }
    public final float getFirstAbilityClassModifier (final Wizard enemy) {
        return 1.05f;
    }
    public final float getFirstAbilityClassModifier (final Rogue enemy) {
        return 0.8f;
    }

    public final float getSecondAbilityClassModifier (final Pyromancer enemy) {
        return 1.3f;
    }
    public final float getSecondAbilityClassModifier (final Knight enemy) {
        return 1.4f;
    }
    public final float getSecondAbilityClassModifier (final Wizard enemy) {
        return 0f;
    }
    public final float getSecondAbilityClassModifier (final Rogue enemy) {
        return 1.2f;
    }

    public final void dmgUp(int nrLv) {
        this.dmg1 = this.dmg1 + 0.05f * nrLv;
        if (this.dmg2 < 0.7f) {
            this.dmg2 = this.dmg2 + 0.02f * nrLv;
        } else {
            this.dmg2 = 0.7f;
        }
    }

    public final float terrainModifier(final Map map, final int NPosition, final int MPosition) {
        char type = map.getType(NPosition, MPosition);
        if (type == 'D') {
            return 1.1f;
        }
        return 0f;
    }

    public final float ability1(final Pyromancer enemy) {
        return dmg1 * this.getFirstAbilityClassModifier(enemy);
    }
    public final float ability1(final Knight enemy) {
        return dmg1 * this.getFirstAbilityClassModifier(enemy);
    }
    public final float ability1(final Rogue enemy) {
        return dmg1 * this.getFirstAbilityClassModifier(enemy);
    }
    public final float ability1(final Wizard enemy) {
        return dmg1 * this.getFirstAbilityClassModifier(enemy);
    }

    public final float ability2(final Pyromancer enemy) {
        return dmg2 * this.getSecondAbilityClassModifier(enemy);
    }
    public final float ability2(final Knight enemy) {
        return dmg2 * this.getSecondAbilityClassModifier(enemy);
    }
    public final float ability2(final Rogue enemy) {
        return dmg2 * this.getSecondAbilityClassModifier(enemy);
    }
    public final float ability2(final Wizard enemy) {
        return dmg2 * this.getSecondAbilityClassModifier(enemy);
    }

    public final float getDmg1() {
        return dmg1;
    }

    public final float getDmg2() {
        return dmg2;
    }

    public final int getDmgPerRound() {
        return 0;
    }

    public final int affectedRounds() {
        return 0;
    }
}
