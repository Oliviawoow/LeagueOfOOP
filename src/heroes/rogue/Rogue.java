package heroes.rogue;

import heroes.Player;
import heroes.knight.Knight;
import heroes.pyromancer.Pyromancer;
import heroes.wizard.Wizard;
import main.Map;

public class Rogue extends Player {
    protected int startHp = 600;
    private int battles = 0;

    public Rogue(final int N, final int M, final Map map) {
        super("R", map, new RogueAbilities(), N, M);
        this.setHp(startHp);

    }

    public void isAttackedBy(Pyromancer attacker) {
        int damageFireblast = Math.round(attacker.getAbilities().ability1(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        int damageIgnite = Math.round(attacker.getAbilities().ability2(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        this.setRoundDmg(Math.round(attacker.getAbilities().abilityOverTime(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition())));
        this.setRoundStun(false);
        this.setDmgOverTime(2);
        int totalDmg = damageFireblast + damageIgnite;
        this.takeDmg(totalDmg);
    }

    public void isAttackedBy(Knight attacker) {
        if (this.getHp() <= this.startHp * Math.min(0.4f, 0.2f + 0.01f * attacker.getLvUp())){
            this.setHp(0);
        } else {
            int damageExecute =Math.round(attacker.getAbilities().ability1(this)
                    * attacker.getAbilities().terrainModifier(attacker.getMap(),
                    attacker.getNPosition(), attacker.getMPosition()));
            int damageSlam =Math.round(attacker.getAbilities().ability2(this)
                    * attacker.getAbilities().terrainModifier(attacker.getMap(),
                    attacker.getNPosition(), attacker.getMPosition()));
            this.setRoundStun(true);
            this.setRoundDmg(0);
            this.setDmgOverTime(1);
            int totalDmg = damageExecute + damageSlam;
            this.takeDmg(totalDmg);
        }
    }

    public void isAttackedBy(Rogue attacker) {
        int statusEffectsModifier = 1;
        float criticalModifier = 1f;

        if (attacker.getAbilities().terrainModifier(attacker.getMap(), attacker.getNPosition(), attacker.getMPosition()) > 1f) {
            statusEffectsModifier = 2;
            if (attacker.getBattles() % 3 == 0) {
                criticalModifier = 1.5f;
            }
        }
        attacker.incrementBattles();
        int damageBackstab = Math.round(attacker.getAbilities().ability1(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()) * criticalModifier);
        int damageParalysis = Math.round(attacker.getAbilities().ability2(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()));
        this.setRoundStun(true);
        this.setRoundDmg(damageParalysis);
        this.setDmgOverTime(3 * statusEffectsModifier);
        int totalDmg = damageBackstab + damageParalysis;
        this.takeDmg(totalDmg);
    }

    public void isAttackedBy(Wizard attacker) {
        float damageDrain = attacker.getAbilities().ability1(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition());
        damageDrain = damageDrain * Math.min(0.3f * this.startHp, this.getHp());
        float damageDeflect = attacker.getAbilities().ability2(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition());
        float critModifier = 1f;
        if (((this.getBattled() && (battles - 1) % 3 == 0) || (!this.getBattled() && battles % 3 == 0))
                && this.getAbilities().terrainModifier(attacker.getMap(), attacker.getNPosition(), attacker.getMPosition()) > 1f) {
            critModifier = 1.5f;
        }
        damageDeflect = damageDeflect
                * (Math.round(this.getAbilities().getDmg1()
                * this.getAbilities().terrainModifier(this.getMap(), this.getNPosition(), this.getMPosition()) * critModifier)
                + Math.round(this.getAbilities().getDmg2()
                * this.getAbilities().terrainModifier(this.getMap(), this.getNPosition(), this.getMPosition())));
        int totalDmg = Math.round(damageDeflect) + Math.round(damageDrain);
        this.takeDmg(totalDmg);
    }

    public void attackPlayer(Player enemy) {
        enemy.isAttackedBy(this);
    }

    public final void lvUp() {
        if (this.getLvUp() > 0  && this.getHp() > 0) {
            this.startHp = this.startHp + 40 * this.getLvUp();
            this.setHp(this.startHp);
            this.setLv(this.getLv() + this.getLvUp());
            this.getAbilities().dmgUp(this.getLvUp());
        }
    }

    public final int getBattles() {
        return battles;
    }

    public final void incrementBattles() {
        battles++;
    }



}
