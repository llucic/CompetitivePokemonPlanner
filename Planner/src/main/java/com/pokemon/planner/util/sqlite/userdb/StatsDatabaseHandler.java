package com.pokemon.planner.util.sqlite.userdb;

import android.content.Context;

import com.pokemon.planner.util.sqlite.DatabaseHandler;

/**
 * Created by Luka on 2/27/14.
 */
public class StatsDatabaseHandler extends DatabaseHandler {

    public static final String POKEMON_ID = "Pokemon ID";
    public static final String STAT_TYPE = "Stat Type";
    public static final String STAT_HP = "HP";
    public static final String STAT_ATTACK = "Attack";
    public static final String STAT_DEFENSE = "Defense";
    public static final String STAT_SPATTACK = "Sp. Attack";
    public static final String STAT_SPDEFENSE = "Sp. Defense";
    public static final String STAT_SPEED = "Speed";

    public StatsDatabaseHandler(Context context) {
        super(context);
    }
}
