public class Pyromancer extends Player {
    protected int startHp = 500;

    public Pyromancer(final int N, final int M) {
        super("P");
        this.NPosition = N;
        this.MPosition = M;
    }

    public void isAttackedBy(Pyromancer attacker) {

    }

    public void isAttackedBy(Knight attacker) {

    }

    public void isAttackedBy(Rogue attacker) {

    }

    public void isAttackedBy(Wizard attacker) {

    }

    public void attackPlayer(Player enemy) {
        enemy.isAttackedBy(this);
    }

    public final float terrainModifier(final Map map) {
        char type = map.getType(this.NPosition, this.MPosition);
        if (type == 'V') {
            return 0.25f;
        }
        return 0f;
    }

    public final void lvUp() {
        if (this.getLvUp() > 0) {
            this.startHp = this.startHp + 50 * this.getLvUp();
            this.hp = this.startHp;
            this.lv = this.lv + this.getLvUp();
            PyromancerAbilities.instance.dmgUp(this.getLvUp());
        }
    }

    public final boolean roundEffect() {
        return false;
    }

    public final void dmgTake(final Player Enemy, final Map map) {
        Enemy.takeDmg(Math.round(PyromancerAbilities.instance.getTotalDmg(Enemy, map)
        * this.terrainModifier(map)));
    }

    public final int dmgNotModTake(final Player Enemy, final Map map) {
        return Math.round(PyromancerAbilities.instance.getDmgNotMod(Enemy, map)
        * this.terrainModifier(map));
    }
}
