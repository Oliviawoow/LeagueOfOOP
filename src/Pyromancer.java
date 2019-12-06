public class Pyromancer extends Player {
    protected String heroType;
    protected int NPosition;
    protected int MPosition;
    protected int startHP = 500;
    protected int HP;
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
}
