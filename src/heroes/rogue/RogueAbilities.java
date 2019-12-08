package heroes.rogue;

import heroes.PlayerAbilities;
import heroes.knight.Knight;
import heroes.wizard.Wizard;
import heroes.pyromancer.Pyromancer;
import main.Map;
import main.Constants;

public class RogueAbilities extends PlayerAbilities {
    private int dmg1 = Constants.ROGUE_DMG1;
    private int dmg2 = Constants.ROGUE_DMG2;
    private int dmgPerRound = Constants.ROGUE_DMG2;

    public RogueAbilities() {
        super();
    }

    public final float getFirstAbilityClassModifier(final Pyromancer enemy) {
        return Constants.R_MOD1;
    }

    public final float getFirstAbilityClassModifier(final Knight enemy) {
        return Constants.R_MOD2;
    }

    public final float getFirstAbilityClassModifier(final Wizard enemy) {
        return Constants.R_MOD3;
    }

    public final float getFirstAbilityClassModifier(final Rogue enemy) {
        return Constants.R_MOD4;
    }

    public final float getSecondAbilityClassModifier(final Pyromancer enemy) {
        return Constants.R_MOD5;
    }

    public final float getSecondAbilityClassModifier(final Knight enemy) {
        return Constants.R_MOD6;
    }

    public final float getSecondAbilityClassModifier(final Wizard enemy) {
        return Constants.R_MOD7;
    }

    public final float getSecondAbilityClassModifier(final Rogue enemy) {
        return Constants.R_MOD8;
    }

    public final void dmgUp(final int nrLv) {
        this.dmg1 = this.dmg1 + Constants.LV_DMG1_R * nrLv;
        this.dmg2 = this.dmg2 + Constants.LV_DMG2_R * nrLv;
        this.dmgPerRound = this.dmgPerRound + Constants.LV_DMG2_R * nrLv;
    }

    public final float terrainModifier(final Map map, final int nPosition, final int mPosition) {
        char type = map.getType(nPosition, mPosition);
        if (type == 'W') {
            return Constants.LAND_MOD_R;
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
        return dmgPerRound;
    }
}
