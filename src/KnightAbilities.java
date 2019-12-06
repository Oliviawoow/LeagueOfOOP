public class KnightAbilities extends PlayerAbilities {
    protected int dmg1 = 200;
    protected int dmg2 = 100;
    protected float modLv = 0f;
    public static final PyromancerAbilities instance = new PyromancerAbilities();

    public KnightAbilities() {
        super();
    }

    public final float mod1(final Player Enemy) {
        float mod1 = 0f;
        if (Enemy.heroType.equals("R")) {
            mod1 = 0.15f;
        } else if (Enemy.heroType.equals("K")) {
            mod1 = 0f;
        } else if (Enemy.heroType.equals("P")) {
            mod1 = 0.1f;
        } else if (Enemy.heroType.equals("W")) {
            mod1 = -0.2f;
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
        this.dmg1 = this.dmg1 + 30 * nrLv;
        this.dmg2 =this.dmg2 + 40 * nrLv;




    }

    public final float execute(final Player Enemy) {
        if (modLv > 0.4f) {
            modLv = 0.4f;
        } else {
            modLv = 0.01f * Enemy.getLvUp();
        }
        if (Math.round(Enemy.getStartHp() * (0.2f + modLv)) < Enemy.getHp()) {
            return Math.round(dmg1 * mod1(Enemy));
        } else {
            return (Enemy.getHp() - Enemy.getHp());
        }
    }
    public final float slam(final Player Enemy) {
        return Math.round(dmg2 * mod2(Enemy));
        //set stun


    }

    public final int getDmgNotMod(final Player Enemy, final Map map) {
        return dmg1 + dmg2;
    }
    public final int getDmgMod(final Player Enemy, final Map map) {
        return Math.round(execute(Enemy) + slam(Enemy));
    }
    public final float getTotalDmg(final Player Enemy, final Map map) {
        return execute(Enemy) + slam(Enemy);
    }
}
