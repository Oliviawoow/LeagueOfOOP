package heroes;

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

    public abstract float fireblast(final Pyromancer enemy);
    public abstract float fireblast(final Knight enemy);
    public abstract float fireblast(final Rogue enemy);
    public abstract float fireblast(final Wizard enemy);

    public abstract float ignite(final Pyromancer enemy);
    public abstract float ignite(final Knight enemy);
    public abstract float ignite(final Rogue enemy);
    public abstract float ignite(final Wizard enemy);
    
    /*creste damage-ul in functie de level*/
    public abstract void dmgUp(int nrLv);
    /*damage dat fara si cu modificator*/
    public abstract int getDmgNotMod(Player Enemy, Map map);
    public abstract int getDmgMod(Player Enemy, Map map);
    public abstract float getTotalDmg(Player Enemy, Map map);
}
