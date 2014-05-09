package com.pokemon.planner.dataobjects;

/**
 * Created by Luka on 2/4/14.
 */
public class Pokemon {
    private int level;
    private Stats base;
    private Stats ev;
    private Stats iv;
    private Stats nature;

    public Pokemon(int level) {
        this.level = level;
    }

    public Pokemon(int level,
                   double hp,
                   double attack,
                   double defence,
                   double sp_attack,
                   double sp_defence,
                   double speed) {
        this.level = level;

        setBaseStats(hp, attack, defence, sp_attack, sp_defence, speed);
        setEvSpread(hp, attack, defence, sp_attack, sp_defence, speed);
        setIvSpread(hp, attack, defence, sp_attack, sp_defence, speed);
    }

    public void setBaseStats(double hp,
                             double attack,
                             double defence,
                             double sp_attack,
                             double sp_defence,
                             double speed) {
        base = new Stats(hp, attack, defence, sp_attack, sp_defence, speed);
    }

    public void setEvSpread(double hp,
                             double attack,
                             double defence,
                             double sp_attack,
                             double sp_defence,
                             double speed) {
        ev = new Stats(hp, attack, defence, sp_attack, sp_defence, speed);
    }

    public void setIvSpread(double hp,
                             double attack,
                             double defence,
                             double sp_attack,
                             double sp_defence,
                             double speed) {
        iv = new Stats(hp, attack, defence, sp_attack, sp_defence, speed);
    }

    public int getLevel() {
        return level;
    }

    public Stats getBase() {
        return base;
    }

    public Stats getEv() {
        return ev;
    }

    public Stats getIv() {
        return iv;
    }
}
