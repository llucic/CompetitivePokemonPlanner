package com.pokemon.planner.dataobjects;

/**
 * Created by Luka on 2/4/14.
 */
public class Stats {
    public double hp;
    public double attack;
    public double defence;
    public double sp_attack;
    public double sp_defence;
    public double speed;

    public Stats(double hp, double attack, double defence, double sp_attack, double sp_defence, double speed) {
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.sp_attack = sp_attack;
        this.sp_defence = sp_defence;
        this.speed = speed;
    }

    @Override
    public String toString() {
        String s = "";

        if (hp > 0) s += hp + " HP ";
        if (attack > 0) s += attack + " Atk ";
        if (defence > 0) s += defence + " Def ";
        if (sp_attack > 0) s += sp_attack + " Sp. Atk ";
        if (sp_defence > 0) s += sp_defence + " Sp. Def ";
        if (speed > 0) s += speed + " Spe ";
        return s;
    }
}
