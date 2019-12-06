public class Pyromancer extends Player {
    protected String heroType;
    protected int NPosition;
    protected int MPosition;
    protected int startHp = 500;
    protected int Hp;
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
}
