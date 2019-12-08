package heroes.wizard;

import heroes.PlayerAbilities;
import heroes.knight.Knight;
import heroes.pyromancer.Pyromancer;
import heroes.rogue.Rogue;
import main.Map;
import main.Constants;

public class WizardAbilities extends PlayerAbilities {
    private float dmg1 = Constants.WIZARD_DMG1;
    private float dmg2 = Constants.WIZARD_DMG2;
    private int dmgPerRound = 0;

    public WizardAbilities() {
        super();
    }

    public final float getFirstAbilityClassModifier(final Pyromancer enemy) {
        return Constants.W_MOD1;
    }

    public final float getFirstAbilityClassModifier(final Knight enemy) {
        return Constants.W_MOD2;
    }

    public final float getFirstAbilityClassModifier(final Wizard enemy) {
        return Constants.W_MOD3;
    }

    public final float getFirstAbilityClassModifier(final Rogue enemy) {
        return Constants.W_MOD4;
    }

    public final float getSecondAbilityClassModifier(final Pyromancer enemy) {
        return Constants.W_MOD5;
    }

    public final float getSecondAbilityClassModifier(final Knight enemy) {
        return Constants.W_MOD6;
    }

    public final float getSecondAbilityClassModifier(final Wizard enemy) {
        return Constants.W_MOD7;
    }

    public final float getSecondAbilityClassModifier(final Rogue enemy) {
        return Constants.W_MOD8;
    }

    public final void dmgUp(final int nrLv) {
        this.dmg1 = this.dmg1 + Constants.LV_DMG1_W * nrLv;
        if (this.dmg2 < Constants.LV_DMG22_W) {
            this.dmg2 = this.dmg2 + Constants.LV_DMG2_W * nrLv;
        } else {
            this.dmg2 = Constants.LV_DMG22_W;
        }
    }

    public final float terrainModifier(final Map map, final int nPosition, final int mPosition) {
        char type = map.getType(nPosition, mPosition);
        if (type == 'D') {
            return Constants.LAND_MOD_W;
        }
        return 1f;
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

    public final float abilityOverTime(final Pyromancer enemy) {
        return dmgPerRound * this.getSecondAbilityClassModifier(enemy);
    }

    public final float abilityOverTime(final Knight enemy) {
        return dmgPerRound * this.getSecondAbilityClassModifier(enemy);
    }

    public final float abilityOverTime(final Rogue enemy) {
        return dmgPerRound * this.getSecondAbilityClassModifier(enemy);
    }

    public final float abilityOverTime(final Wizard enemy) {
        return dmgPerRound * this.getSecondAbilityClassModifier(enemy);
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

}
