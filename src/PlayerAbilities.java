
/*definire metode pentru abilitatile eroilor*/
public abstract class PlayerAbilities {
    public PlayerAbilities() {

    }
    /*modificator pentru prima si a 2a abilitate in functie de eroul inamic*/
    public abstract float getFirstAbilityTerrainModifier (final Rogue enemy);
    public abstract float getFirstAbilityTerrainModifier (final Knight enemy);
    public abstract float getFirstAbilityTerrainModifier (final Pyromancer enemy);
    public abstract float getFirstAbilityTerrainModifier (final Wizard enemy);

    public abstract float getSecondAbilityTerrainModifier (final Rogue enemy);
    public abstract float getSecondAbilityTerrainModifier (final Knight enemy);
    public abstract float getSecondAbilityTerrainModifier (final Pyromancer enemy);
    public abstract float getSecondAbilityTerrainModifier (final Wizard enemy);
    
//    public abstract float mod1(Player Enemy);
//    public abstract float mod2(Player Enemy);
    /*creste damage-ul in functie de level*/
    public abstract void dmgUp(int nrLv);
    /*damage dat fara si cu modificator*/
    public abstract int getDmgNotMod(Player Enemy, Map map);
    public abstract int getDmgMod(Player Enemy, Map map);
    public abstract float getTotalDmg(Player Enemy, Map map);
}
