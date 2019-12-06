public class Pyromancer extends Player {
    protected String heroType;
    protected int NPosition;
    protected int MPosition;
    protected int startHp = 500;
    protected int hp;
    protected int xp;
    protected int lv;
    protected boolean Dead;

    public Pyromancer(final int N, final int M) {
        super("P");
        this.heroType = "P";
        this.NPosition = N;
        this.MPosition = M;
        this.Dead = false;
    }

    public final int getStartHp() {
        return this.startHp;
    }
    public final int getHp() {
        return this.hp;
    }
    public final int getXp() {
        return this.xp;
    }
    public final int getLv() {
        return this.lv;
    }
    public final boolean getDead() {
        return this.Dead;
    }
    public final int getNPosition() {
        return this.NPosition;
    }
    public final int getMPosition() {
        return this.MPosition;
    }

    public final void direction(final char dir) {
        boolean ok = true;
        if (dir == 'U' && ok) {
            this.NPosition = this.NPosition --;
            ok = false;
        }
        if (dir == 'D' && ok) {
            this.NPosition = this.NPosition ++;
            ok = false;
        }
        if (dir == 'L' && ok) {
            this.MPosition = this.MPosition --;
            ok = false;
        }
        if (dir == 'R' && ok) {
            this.MPosition = this.MPosition ++;
            ok = false;
        }
        if (dir == '_' && ok) {
            ok = false;
        }
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

    }

    public final void setDead() {
        if (this.getHp() <= 0) {
            this.Dead = true;
            this.hp = 0;
            this.NPosition = -1;
            this.MPosition = -1;
        }
    }

    public final void takeDmg(int dmg) {

    }
}
