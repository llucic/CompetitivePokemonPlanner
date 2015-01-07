package com.pokemon.planner.dataobjects;

/**
 * Created by Luka on 2/4/14.
 */
public class Pokemon {
    private int level;
    private PokemonBase base;
    private Stats ev;
    private Stats iv;
    private Stats nature;
    private boolean hasHiddenAbility;
    private int abilitySlot;

    public Pokemon (PokemonBase base, int level) {
        this.base = base;
        this.level = level;
    }

    public void setEvSpread(double hp,
                             double attack,
                             double defence,
                             double sp_attack,
                             double sp_defence,
                             double speed) {
        ev = new Stats(hp, attack, defence, sp_attack, sp_defence, speed);
    }

    public void setDefaultIvSpread() {
        iv = new Stats(31,31,31,31,31,31);
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

    public Stats getEvSpread() {
        return ev;
    }

    public Stats getIvSpread() {
        return iv;
    }

    public PokemonBase getBase() {
        return base;
    }

    public void setBase(PokemonBase base) {
        this.base = base;
    }

    public String getAbility() {
        if (hasHiddenAbility) {
            return base.getHiddenAbility();
        }

        return base.getAbilities()[abilitySlot];
    }
}
