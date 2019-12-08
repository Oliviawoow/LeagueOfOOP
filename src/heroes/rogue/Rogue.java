package heroes.rogue;

import heroes.Player;
import heroes.knight.Knight;
import heroes.pyromancer.Pyromancer;
import heroes.wizard.Wizard;
import main.Map;
import main.Constants;

public final class Rogue extends Player {
    protected int startHp = Constants.START_HP_ROGUE;
    private int battles = 0;

    public Rogue(final int n, final int m, final Map map) {
        super("R", map, new RogueAbilities(), n, m);
        this.setHp(startHp);

    }

    public void isAttackedBy(final Pyromancer attacker) {
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

    public void isAttackedBy(final Knight attacker) {
        if (this.getHp() <= this.startHp * Math.min(Constants.HP_MAX_LIM_KNIGHT,
                Constants.HP_MIN_LIM_KNIGHT + Constants.HP_PER_LEVEL_KNIGHT * attacker.getLvUp())) {
            this.setHp(0);
        } else {
            int damageExecute = Math.round(attacker.getAbilities().ability1(this)
                    * attacker.getAbilities().terrainModifier(attacker.getMap(),
                    attacker.getNPosition(), attacker.getMPosition()));
            int damageSlam = Math.round(attacker.getAbilities().ability2(this)
                    * attacker.getAbilities().terrainModifier(attacker.getMap(),
                    attacker.getNPosition(), attacker.getMPosition()));
            this.setRoundStun(true);
            this.setRoundDmg(0);
            this.setDmgOverTime(1);
            int totalDmg = damageExecute + damageSlam;
            this.takeDmg(totalDmg);
        }
    }

    public void isAttackedBy(final Rogue attacker) {
        int statusEffectsModifier = 1;
        float criticalModifier = 1f;

        if (attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()) > 1f) {
            statusEffectsModifier = 2;
            if (attacker.getBattles() % Constants.DIV_ROGUE == 0) {
                criticalModifier = Constants.CRITICAL_MODIFIER;
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
        this.setDmgOverTime(Constants.DIV_ROGUE * statusEffectsModifier);
        int totalDmg = damageBackstab + damageParalysis;
        this.takeDmg(totalDmg);
    }

    public void isAttackedBy(final Wizard attacker) {
        float damageDrain = attacker.getAbilities().ability1(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition());
        damageDrain = damageDrain * Math.min(Constants.HP_BAZA_WIZARD * this.startHp, this.getHp());
        float damageDeflect = attacker.getAbilities().ability2(this)
                * attacker.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition());
        float critModifier = 1f;
        if (((this.getBattled() && (battles - 1) % Constants.DIV_ROGUE == 0)
                || (!this.getBattled() && battles % Constants.DIV_ROGUE == 0))
                && this.getAbilities().terrainModifier(attacker.getMap(),
                attacker.getNPosition(), attacker.getMPosition()) > 1f) {
            critModifier = Constants.CRITICAL_MODIFIER;
        }
        damageDeflect = damageDeflect
                * (Math.round(this.getAbilities().getDmg1()
                * this.getAbilities().terrainModifier(this.getMap(), this.getNPosition(),
                this.getMPosition()) * critModifier)
                + Math.round(this.getAbilities().getDmg2()
                * this.getAbilities().terrainModifier(this.getMap(), this.getNPosition(),
                this.getMPosition())));
        int totalDmg = Math.round(damageDeflect) + Math.round(damageDrain);
        this.takeDmg(totalDmg);
    }

    public void attackPlayer(final Player enemy) {
        enemy.isAttackedBy(this);
    }

    public void lvUp() {
        if (this.getLvUp() > 0  && this.getHp() > 0) {
            this.startHp = this.startHp + Constants.LEVEL_UP_ROGUE * this.getLvUp();
            this.setHp(this.startHp);
            this.setLv(this.getLv() + this.getLvUp());
            this.getAbilities().dmgUp(this.getLvUp());
        }
    }

    public int getBattles() {
        return battles;
    }

    public void incrementBattles() {
        battles++;
    }



}
