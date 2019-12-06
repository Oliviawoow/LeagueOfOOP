public class Knight extends Player {
    protected String heroType;
    protected int NPosition;
    protected int MPosition;
    protected int startHp = 900;
    protected int hp;
    protected int xp;
    protected int lv;
    protected boolean Dead;

    public Knight(final int N, final int M) {
        super("K");
        this.heroType = "K";
        this.NPosition = N;
        this.MPosition = M;
        this.Dead = false;
    }
}
