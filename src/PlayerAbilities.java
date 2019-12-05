
/*definire metode pentru abilitatile eroilor*/
public abstract class PlayerAbilities {
    public PlayerAbilities() {

    }
    /*modificator pentru prima si a 2a abilitate in functie de eroul inamic*/
    public abstract int mod1(Player Enemy);
    public abstract int mod2(Player Enemy);

}
