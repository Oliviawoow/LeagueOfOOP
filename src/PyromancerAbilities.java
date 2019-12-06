public class PyromancerAbilities extends PlayerAbilities {
    protected int dmg1 = 350;
    protected int dmg2 = 150;
    protected int dmgPerRound = 50;
    public static final PyromancerAbilities instance = new PyromancerAbilities();

    public PyromancerAbilities() {
        super();
    }

    public final float mod1(final Player Enemy) {
        float mod1 = 0f;
        if (Enemy.heroType.equals("R")) {
            mod1 = -0.2f;
        } else if (Enemy.heroType.equals("K")) {
            mod1 = 0.2f;
        } else if (Enemy.heroType.equals("P")) {
            mod1 = -0.1f;
        } else if (Enemy.heroType.equals("W")) {
            mod1 = 0.05f;
        }
        return mod1;
    }
    public final float mod2(final Player Enemy) {
        float mod2 = 0f;
        if (Enemy.heroType.equals("R")) {
            mod2 = -0.2f;
        } else if (Enemy.heroType.equals("K")) {
            mod2 = 0.2f;
        } else if (Enemy.heroType.equals("P")) {
            mod2 = -0.1f;
        } else if (Enemy.heroType.equals("W")) {
            mod2 = 0.05f;
        }
        return mod2;
    }
    public final void dmgUp(int nrLv) {
        this.dmg1 = this.dmg1 + 50 * nrLv;
        this.dmg2 =this.dmg2 + 20 * nrLv;
        this.dmgPerRound = this.dmgPerRound + 30 * nrLv;

    }
    public final int getDmgNotMod(Player Enemy, Map map) {

    }
    public final int getDmgMod(Player Enemy, Map map) {

    }
    public final float getTotalDmg(Player Enemy, Map map) {

    }
}
