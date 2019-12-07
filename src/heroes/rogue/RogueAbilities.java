package heroes.rogue;

import heroes.Player;
import heroes.PlayerAbilities;
import heroes.knight.Knight;
import heroes.wizard.Wizard;
import heroes.pyromancer.Pyromancer;
import main.Map;

public class RogueAbilities extends PlayerAbilities {
    private int dmg1 = 200;
    private int dmg2 = 40;
    private int dmgPerRound = 40;

    public RogueAbilities() {
        super();
    }

    public final float getFirstAbilityClassModifier (final Pyromancer enemy) {
        return 1.25f;
    }
    public final float getFirstAbilityClassModifier (final Knight enemy) {
        return 0.9f;
    }
    public final float getFirstAbilityClassModifier (final Wizard enemy) {
        return 1.25f;
    }
    public final float getFirstAbilityClassModifier (final Rogue enemy) {
        return 1.2f;
    }

    public final float getSecondAbilityClassModifier (final Pyromancer enemy) {
        return 1.2f;
    }
    public final float getSecondAbilityClassModifier (final Knight enemy) {
        return 0.8f;
    }
    public final float getSecondAbilityClassModifier (final Wizard enemy) {
        return 1.25f;
    }
    public final float getSecondAbilityClassModifier (final Rogue enemy) {
        return 0.9f;
    }

    public final void dmgUp(int nrLv) {
        this.dmg1 = this.dmg1 + 20 * nrLv;
        this.dmg2 = this.dmg2 + 10 * nrLv;
        this.dmgPerRound = this.dmgPerRound + 10 * nrLv;
    }

    public final float terrainModifier(final Map map, final int NPosition, final int MPosition) {
        char type = map.getType(NPosition, MPosition);
        if (type == 'W') {
            return 1.15f;
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
        return 3;
    }
}
