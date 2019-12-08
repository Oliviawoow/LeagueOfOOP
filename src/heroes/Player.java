package heroes;

import heroes.knight.Knight;
import heroes.pyromancer.Pyromancer;
import heroes.rogue.Rogue;
import heroes.wizard.Wizard;
import main.Map;
import main.Constants;

/*clasa heroes.Player contine metodele necesare pentru functionarea tuturor eroilor*/
public abstract class Player {
    private String heroType;
    private int nPosition;
    private int mPosition;
    private int startHp;
    private int hp;
    private int xp;
    private int lv;
    private Map map;
    private PlayerAbilities abilities;
    private int roundDmg;
    private boolean roundStun;
    private int dmgOverTime;
    private boolean battled = false;

    public Player(final String heroType, final Map map, final PlayerAbilities abilities,
                  final int nPosition, final int mPosition) {
        this.mPosition = mPosition;
        this.nPosition = nPosition;
        this.heroType = heroType;
        this.map = map;
        this.abilities = abilities;
    }
    /*getteri si setteri pentru eroii derivati din clasa Player*/
    public final int getNPosition() {
        return this.nPosition;
    }

    public final int getMPosition() {
        return this.mPosition;
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
        if (this.xp >= Constants.XP_MIN) {
            nrLvUp = ((this.xp - Constants.XP_MIN) / Constants.XP_IMPART + 1) - this.lv;
        }
        return nrLvUp;
    }
    public final boolean isDead() {
        return (this.hp <= 0);
    }

    public final Map getMap() {
        return map;
    }

    public final String getHeroType() {
        return heroType;
    }

    public final void setHp(final int hp) {
        this.hp = hp;
    }

    public final void setLv(final int lv) {
        this.lv = lv;
    }

    public final void setXp(final int xp) {
        this.xp = xp;
    }

    public final int getRoundDmg() {
        return roundDmg;
    }

    public final void setRoundDmg(final int roundDmg) {
        this.roundDmg = roundDmg;
    }

    public final int getDmgOverTime() {
        return dmgOverTime;
    }

    public final void setDmgOverTime(final int dmgOverTime) {
        this.dmgOverTime = dmgOverTime;
    }

    public final boolean getRoundStun() {
        return roundStun;
    }

    public final void setRoundStun(final boolean value) {
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
    public final void setXpUp(final Player enemy) {
        this.xp = this.xp + Math.max(0, Constants.XP_LV1 - (this.lv - enemy.getLv())
                * Constants.XP_LV2);
    }
    /*verifica daca poate face level up si daca da modifica damage-ul si
     hp-ul initial si hp-ul curent redevine maxim*/
    public abstract void lvUp();

    public final boolean getBattled() {
        return this.battled;
    }

    public final void setBattled(final boolean battled) {
        this.battled = battled;
    }
    /*verifica daca e mort si daca e adevarat il scoate de pe harta*/
    public final void setDead() {
        if (this.hp <= 0) {
            this.hp = 0;
            this.nPosition = -1;
            this.mPosition = -1;
            this.dmgOverTime = 0;
            this.roundDmg = 0;
            this.roundStun = false;
        }
    }
    /*scade viata curenta in functie de damage-ul primit si il seteaza mort in
     caz de viata lui ajunge sub 0*/
    public final void takeDmg(final int dmg) {
        this.hp = this.hp - dmg;
    }

    public final void takeDmgOverTime() {
        if (this.dmgOverTime > 0) {
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
                * this.getAbilities().terrainModifier(this.getMap(), this.getNPosition(),
                this.getMPosition()))
                + Math.round(this.getAbilities().getDmg2()
                * this.getAbilities().terrainModifier(this.getMap(), this.getNPosition(),
                this.getMPosition()));
    }
    /*miscarea eroului*/
    public final void direction(final char dir) {
        if (dir == 'U') {
            this.nPosition--;
            return;
        }
        if (dir == 'D') {
            this.nPosition++;
            return;
        }
        if (dir == 'L') {
            this.mPosition--;
            return;
        }
        if (dir == 'R') {
            this.mPosition++;
            return;
        }
        if (dir == '_') {
            return;
        }
    }

}
