package heroes;

import heroes.knight.Knight;
import heroes.pyromancer.Pyromancer;
import heroes.rogue.Rogue;
import heroes.wizard.Wizard;
import main.Map;

/*definire metode pentru abilitatile eroilor*/
public abstract class PlayerAbilities {
    public PlayerAbilities() {

    }
    /*modificator pentru prima si a 2a abilitate in functie de eroul inamic*/
    public abstract float getFirstAbilityClassModifier(Rogue enemy);
    public abstract float getFirstAbilityClassModifier(Knight enemy);
    public abstract float getFirstAbilityClassModifier(Pyromancer enemy);
    public abstract float getFirstAbilityClassModifier(Wizard enemy);

    public abstract float getSecondAbilityClassModifier(Rogue enemy);
    public abstract float getSecondAbilityClassModifier(Knight enemy);
    public abstract float getSecondAbilityClassModifier(Pyromancer enemy);
    public abstract float getSecondAbilityClassModifier(Wizard enemy);

    public abstract float terrainModifier(Map map, int nPosition, int mPosition);

    public abstract float abilityOverTime(Pyromancer enemy);
    public abstract float abilityOverTime(Knight enemy);
    public abstract float abilityOverTime(Rogue enemy);
    public abstract float abilityOverTime(Wizard enemy);


    public abstract float ability1(Pyromancer enemy);
    public abstract float ability1(Knight enemy);
    public abstract float ability1(Rogue enemy);
    public abstract float ability1(Wizard enemy);

    public abstract float ability2(Pyromancer enemy);
    public abstract float ability2(Knight enemy);
    public abstract float ability2(Rogue enemy);
    public abstract float ability2(Wizard enemy);
    /*creste damage-ul in functie de level*/
    public abstract void dmgUp(int nrLv);

    public abstract float getDmg1();
    public abstract float getDmg2();
}
