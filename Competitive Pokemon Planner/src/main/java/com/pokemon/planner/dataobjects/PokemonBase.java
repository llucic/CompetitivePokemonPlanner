package com.pokemon.planner.dataobjects;

import java.util.List;

/**
 * Created by Luka on 2/27/14.
 */
public class PokemonBase {

    private String dexNumber;
    private String name;
    private String[] abilities;
    private String hiddenAbility;
    private Stats baseStats;
    private List<String> moves;

    public PokemonBase(String dexNumber, String name, String[] abilities, String hiddenAbility, Stats stats) {
        this.dexNumber = dexNumber;
        this.name = name;
        this.abilities = abilities;
        this.hiddenAbility = hiddenAbility;
        this.baseStats = stats;
    }

    public String getDexNumber() {
        return dexNumber;
    }

    public void setDexNumber(String dexNumber) {
        this.dexNumber = dexNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAbilities() {
        return abilities;
    }

    public void setAbilities(String[] abilities) {
        this.abilities = abilities;
    }

    public String getHiddenAbility() {
        return hiddenAbility;
    }

    public void setHiddenAbility(String hiddenAbility) {
        this.hiddenAbility = hiddenAbility;
    }

    public Stats getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(Stats baseStats) {
        this.baseStats = baseStats;
    }

}
