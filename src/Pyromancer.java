public class Pyromancer extends Player {
    protected int startHp = 500;

    public Pyromancer(final int N, final int M) {
        super("P");
        this.NPosition = N;
        this.MPosition = M;
    }



    public final float mod(final Map map) {
        float mod;
        char x = map.getType(this.NPosition, this.MPosition);
        if (x == 'V') {
            mod = 0.25f;
            return mod;
        }
        return 0f;
    }

    public final int getLvUp() {
        int nrLvUp;
        nrLvUp = ((this.xp - 250) / 50 + 1) - this.lv;
        return nrLvUp;
    }

    public final void setXpUp(final Player Enemy) {
        this.xp = this.xp + Math.max(0, 200 - (this.lv - Enemy.getLv()) * 40);
    }

    public final void lvUp() {
        if (this.getLvUp() > 0) {
            this.startHp = this.startHp + 50 * this.getLvUp();
            this.hp = this.startHp;
            this.lv = this.lv + this.getLvUp();
            PyromancerAbilities.instance.dmgUp(this.getLvUp());
        }
    }

    public final void takeDmg(int dmg) {
        this.hp = this.hp - dmg;
    }

    public final boolean roundEffect() {

    }

    public final void dmgTake(final Player Enemy, final Map map) {
        Enemy.takeDmg(Math.round(PyromancerAbilities.instance.getTotalDmg(Enemy, map)
        * this.mod(map)));
    }

    public final int dmgNotModTake(final Player Enemy, final Map map) {
        return Math.round(PyromancerAbilities.instance.getDmgNotMod(Enemy, map)
        * this.mod(map));
    }
}
