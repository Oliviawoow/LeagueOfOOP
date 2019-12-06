
/*clasa Player contine metodele necesare pentru functionarea tuturor eroilor*/
public abstract class Player {
    protected String heroType;
    protected int NPosition;
    protected int MPosition;
    protected int startHp;
    protected int hp;
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
    public abstract int getStartHp();
    public abstract int getHp();
    public abstract int getXp();
    public abstract int getLv();
    public abstract int getLvUp();
    public abstract boolean getDead();

    /*setteri pentru eroii derivati din clasa Player*/
    /*creste Xp dupa o lupta castigata*/
    public abstract void setXpUp(Player Enemy);
    /*verifica daca poate face level up si daca da modifica damage-ul si
     hp-ul initial si hp-ul curent redevine maxim*/
    public abstract void lvUp();
    /*verifica daca e mort si daca e adevarat il scoate de pe harta*/
    public abstract void setDead();
    /*scade viata curenta in functie de damage-ul primit*/
    public abstract void takeDmg(int dmg);
    /*pentru efectele pe mai multe runde, salvam rundele, damage-ul primit si
    vedem daca are stun sau nu*/
    public abstract boolean roundEffect();
    /*calculeaza damage-ul si ii scade eroului din viata*/
    public abstract void dmgTake(Player Enemy, Map map);
    /*damage nemodificat*/
    public abstract int dmgNoModTake(Player Enemy, Map map);

}
