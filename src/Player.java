
/*clasa Player contine metodele necesare pentru functionarea tuturor eroilor*/
public abstract class Player {
    protected String heroType;
    protected int NPosition;
    protected int MPosition;
    protected int startHp;
    protected int hp;
    protected int xp;
    protected int lv;

    public Player(final String heroType) {
        this.heroType = heroType;
    }

    /*getteri pentru eroii derivati din clasa Player*/
    public final int getNPosition() {
        return this.NPosition;
    }
    public final int getMPosition() {
        return this.MPosition;
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
    public abstract int getLvUp();
    public final boolean isDead() {
        return (this.hp <= 0);
    }

    /*setteri pentru eroii derivati din clasa Player*/
    /*creste Xp dupa o lupta castigata*/
    public abstract void setXpUp(Player Enemy);
    /*verifica daca poate face level up si daca da modifica damage-ul si
     hp-ul initial si hp-ul curent redevine maxim*/
    public abstract void lvUp();
    /*verifica daca e mort si daca e adevarat il scoate de pe harta*/
    public final void setDead() {
        if (this.getHp() <= 0) {
            this.hp = 0;
            this.NPosition = -1;
            this.MPosition = -1;
        }
    }
    /*scade viata curenta in functie de damage-ul primit*/
    public abstract void takeDmg(int dmg);
    /*pentru efectele pe mai multe runde, salvam rundele, damage-ul primit si
    vedem daca are stun sau nu*/
    public abstract boolean roundEffect();
    /*calculeaza damage-ul si ii scade eroului din viata*/
    public abstract void dmgTake(Player Enemy, Map map);
    /*damage nemodificat*/
    public abstract int dmgNotModTake(Player Enemy, Map map);

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
