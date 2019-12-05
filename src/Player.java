
/*clasa Player contine metodele necesare pentru functionarea tuturor eroilor*/
public abstract class Player {
    protected String heroType;
    protected int NPosition;
    protected int MPosition;
    protected int startHP;
    protected int HP;
    protected int xp;
    protected int lv;
    protected boolean Dead;

    public Player(final String heroType) {
        this.heroType = heroType;
        this.xp = 0;
        this.lv = 0;
        this.Dead = false;
    }

    /*getteri pentru eroii derivati din clasa Player*/
    public abstract int getNPosition();
    public abstract int getMPosition();
    public abstract int getStartHP();
    public abstract int getHP();
    public abstract int getXp();
    public abstract int getLv();
    public abstract int getLvUp();
    public abstract boolean isDead();

    /*setteri pentru eroii derivati din clasa Player*/
    /*creste Xp dupa o lupta castigata*/
    public abstract void setXpUP(Player Enemy);
    /*verifica daca poate face level up si daca da modifica damage-ul si
     hp-ul initial si hp-ul curent redevine maxim*/
    public abstract void lvUp();
    /*verifica daca e mort si daca e adevarat il scoate de pe harta*/
    public abstract void setDead();
    /*scade viata curenta in functie de damage-ul primit*/
    public abstract void takeDmg(int dmg);


}
