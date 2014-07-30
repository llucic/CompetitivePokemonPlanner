package com.pokemon.planner.util;

/**
 * Created by Luka on 7/12/2014.
 */
public enum Nature {
    HARDY ("Hardy", "", ""),
    LONELY ("Lonely", "Attack", "Defense"),
    BRAVE("Brave", "Attack", "Speed"),
    ADAMANT("Adamant", "Attack", "Sp. Attack"),
    NAUGHTY("Naughty", "Attack", "Sp. Defense"),
    BOLD("Bold", "Defense", "Attack"),
    DOCILE("Docile", "", ""),
    RELAXED("Relaxed", "Defense", "Speed"),
    IMPISH("Impish", "Defense", "Sp. Attack"),
    LAX("Lax", "Defense", "Sp. Defense"),
    TIMID("Timid", "Speed", "Attack"),
    HASTY("Hasty", "Speed", "Defense"),
    SERIOUS("Serious", "", ""),
    JOLLY("Jolly", "Speed", "Sp. Attack"),
    NAIVE("Naive", "Speed", "Sp. Defense"),
    MODEST("Modest", "Sp. Attack", "Attack"),
    MILD("Mild", "Sp. Attack", "Defense"),
    QUIET("Quiet", "Sp. Attack", "Speed"),
    BASHFUL("Bashful", "", ""),
    RASH("Rash", "Sp. Attack", "Sp. Defense"),
    CALM("Calm", "Sp. Defense", "Attack"),
    GENTLE("Gentle", "Sp. Defense", "Defense"),
    SASSY("Sassy", "Sp. Defense", "Speed"),
    CAREFUL("Careful", "Sp. Defense", "Sp. Attack"),
    QUIRKY("Quirky", "", "");

    private final String[] values;

    Nature (String... vals) {
        values = vals;
    }

    public String toString() {
        return values[0];
    }

    public String boosted() {
        return values[1];
    }

    public String hindered() {
        return values[2];
    }
}
