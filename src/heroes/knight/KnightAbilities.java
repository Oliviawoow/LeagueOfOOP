package heroes.knight;

import heroes.PlayerAbilities;
import heroes.pyromancer.Pyromancer;
import heroes.wizard.Wizard;
import heroes.rogue.Rogue;
import main.Map;

public class KnightAbilities extends PlayerAbilities {
    private int dmg1 = 200;
    private int dmg2 = 100;

    public KnightAbilities() {
        super();
    }

    public final float getFirstAbilityClassModifier (final Pyromancer enemy) {
        return 1.1f;
    }

    public final float getFirstAbilityClassModifier (final Knight enemy) {
        return 0f;
    }

    public final float getFirstAbilityClassModifier (final Wizard enemy) {
        return 0.8f;
    }

    public final float getFirstAbilityClassModifier (final Rogue enemy) {
        return 1.15f;
    }

    public final float getSecondAbilityClassModifier (final Pyromancer enemy) {
        return 0.9f;
    }

    public final float getSecondAbilityClassModifier (final Knight enemy) {
        return 1.2f;
    }

    public final float getSecondAbilityClassModifier (final Wizard enemy) {
        return 1.05f;
    }

    public final float getSecondAbilityClassModifier (final Rogue enemy) {
        return 0.8f;
    }

    public final void dmgUp(int nrLv) {
        this.dmg1 = this.dmg1 + 30 * nrLv;
        this.dmg2 =this.dmg2 + 40 * nrLv;
    }

    public final float terrainModifier(final Map map, final int NPosition, final int MPosition) {
        char type = map.getType(NPosition, MPosition);
        if (type == 'L') {
            return 1.15f;
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
}
