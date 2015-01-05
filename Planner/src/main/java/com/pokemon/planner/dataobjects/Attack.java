package com.pokemon.planner.dataobjects;

import com.pokemon.planner.util.AttackClass;
import com.pokemon.planner.util.Type;

/**
 * Created by Luka on 3/6/14.
 */
public class Attack {

    private String name;
    private int power;
    private int accuracy;
    private String description;
    private Type type;
    private AttackClass category;

    public Attack(String name, int power, int accuracy, String description, Type type, AttackClass category) {
        this.name = name;
        this.power = power;
        this.accuracy = accuracy;
        this.description = description;
        this.type = type;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public AttackClass getCategory() {
        return category;
    }

    public void setCategory(AttackClass category) {
        this.category = category;
    }
}
