
/*definire metode pentru abilitatile eroilor*/
public abstract class PlayerAbilities {
    public PlayerAbilities() {

    }
    /*modificator pentru prima si a 2a abilitate in functie de eroul inamic*/
    public abstract float mod1(Player Enemy);
    public abstract float mod2(Player Enemy);
    /*creste damage-ul in functie de level*/
    public abstract void dmgUp(int lv);
    /*damage dat fara si cu modificator*/
    public abstract int getDmgNotMod(Player Enemy, Map map);
    public abstract int getDmgMod(Player Enemy, Map map);
    public abstract float getTotalDmg(Player Enemy, Map map);
}
