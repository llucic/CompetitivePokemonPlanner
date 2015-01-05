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
}
