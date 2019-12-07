package heroes;

import heroes.knight.Knight;
import heroes.pyromancer.Pyromancer;
import heroes.rogue.Rogue;
import heroes.wizard.Wizard;
import main.Map;

/*clasa heroes.Player contine metodele necesare pentru functionarea tuturor eroilor*/
public abstract class Player {
    private String heroType;
    private int NPosition;
    private int MPosition;
    private int startHp;
    private int hp;
    private int xp;
    private int lv;
    private Map map;
    private PlayerAbilities abilities;
    private int roundDmg;
    private boolean roundStun;
    private int dmgOverTime;


    public Player(final String heroType, final Map map, final PlayerAbilities abilities, final int NPosition, final int MPosition) {
        this.MPosition = MPosition;
        this.NPosition = NPosition;
        this.heroType = heroType;
        this.map = map;
        this.abilities = abilities;
    }

    /*getteri si setteri pentru eroii derivati din clasa Player*/
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

    public final int getLvUp() {
        int nrLvUp = 0;
        if (this.xp >= 250) {
            nrLvUp = ((this.xp - 250) / 50 + 1) - this.lv;
        }
        return nrLvUp;
    }
    public final boolean isDead() {
        return (this.hp <= 0);
    }

    public Map getMap() {
        return map;
    }

    public String getHeroType() {
        return heroType;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public final int getRoundDmg() {
        return roundDmg;
    }

    public void setRoundDmg(int roundDmg) {
        this.roundDmg = roundDmg;
    }

    public final int getDmgOverTime() {
        return dmgOverTime;
    }

    public void setDmgOverTime(int dmgOverTime) {
        this.dmgOverTime = dmgOverTime;
    }

    public final boolean getRoundStun() {
        return roundStun;
    }

    public final void setRoundStun(boolean value) {
        roundStun = value;
    }

    public abstract void isAttackedBy(Pyromancer attacker);
    public abstract void isAttackedBy(Knight attacker);
    public abstract void isAttackedBy(Rogue attacker);
    public abstract void isAttackedBy(Wizard attacker);

    public abstract void attackPlayer(Player enemy);

    public final PlayerAbilities getAbilities() {
        return this.abilities;
    }

    /*creste Xp dupa o lupta castigata*/
    public final void setXpUp(Player Enemy) {
        this.xp = this.xp + Math.max(0, 200 - (this.lv - Enemy.getLv()) * 40);
    }

    /*verifica daca poate face level up si daca da modifica damage-ul si
     hp-ul initial si hp-ul curent redevine maxim*/
    public abstract void lvUp();

    /*verifica daca e mort si daca e adevarat il scoate de pe harta*/
    public final void setDead() {
        if (this.hp <= 0) {
            this.hp = 0;
            this.NPosition = -1;
            this.MPosition = -1;
            this.dmgOverTime = 0;
            this.roundDmg = 0;
            this.roundStun = false;
        }
    }

    /*scade viata curenta in functie de damage-ul primit si il seteaza mort in
     caz de viata lui ajunge sub 0*/
    public final void takeDmg(int dmg) {
        this.hp = this.hp - dmg;
        if (this.hp <= 0) {
            this.setDead();
        }
    }

    public final void takeDmgOverTime() {
        if (dmgOverTime > 0) {
            this.hp = this.hp - roundDmg;
            --this.dmgOverTime;
            if (this.dmgOverTime == 0) {
                this.roundStun = false;
                this.roundDmg = 0;
            }
        }
    }

    /*damage nemodificat*/
    public final int dmgNoModifier() {
        return Math.round(this.getAbilities().getDmg1()
                * this.getAbilities().terrainModifier(this.getMap(), this.getNPosition(), this.getMPosition()))
                + Math.round(this.getAbilities().getDmg2()
                * this.getAbilities().terrainModifier(this.getMap(), this.getNPosition(), this.getMPosition()))
                + Math.round(this.getAbilities().getDmgPerRound()
                * this.getAbilities().terrainModifier(this.getMap(), this.getNPosition(), this.getMPosition()));
    }

    /*miscarea eroului*/
    public final void direction(final char dir) {
        if (dir == 'U') {
            this.NPosition = this.NPosition --;
            return;
        }
        if (dir == 'D') {
            this.NPosition = this.NPosition ++;
            return;
        }
        if (dir == 'L') {
            this.MPosition = this.MPosition --;
            return;
        }
        if (dir == 'R') {
            this.MPosition = this.MPosition ++;
            return;
        }
        if (dir == '_') {
            return;
        }
    }

}
