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
    public abstract float getFirstAbilityClassModifier (final Rogue enemy);
    public abstract float getFirstAbilityClassModifier (final Knight enemy);
    public abstract float getFirstAbilityClassModifier (final Pyromancer enemy);
    public abstract float getFirstAbilityClassModifier (final Wizard enemy);

    public abstract float getSecondAbilityClassModifier (final Rogue enemy);
    public abstract float getSecondAbilityClassModifier (final Knight enemy);
    public abstract float getSecondAbilityClassModifier (final Pyromancer enemy);
    public abstract float getSecondAbilityClassModifier (final Wizard enemy);

    public abstract float ability1(final Pyromancer enemy);
    public abstract float ability1(final Knight enemy);
    public abstract float ability1(final Rogue enemy);
    public abstract float ability1(final Wizard enemy);

    public abstract float ability2(final Pyromancer enemy);
    public abstract float ability2(final Knight enemy);
    public abstract float ability2(final Rogue enemy);
    public abstract float ability2(final Wizard enemy);
    
    /*creste damage-ul in functie de level*/
    public abstract void dmgUp(int nrLv);
    /*damage dat fara si cu modificator*/
    public abstract int getDmgNotMod(Player Enemy, Map map);
    public abstract int getDmgMod(Player Enemy, Map map);
    public abstract float getTotalDmg(Player Enemy, Map map);
}
