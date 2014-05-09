package com.pokemon.planner.util.sqlite.userdb;

import android.content.Context;

import com.pokemon.planner.util.sqlite.DatabaseHandler;

/**
 * Created by Luka on 2/27/14.
 */
public class PokemonDatabaseHandler extends DatabaseHandler {

    public static final String POKEMON_ID = "ID";
    public static final String POKEMON_NUMBER = "Dex Number";
    public static final String POKEMON_LEVEL = "Level";
    public static final String POKEMON_GENDER = "Gender";
    public static final String POKEMON_ITEM = "Item";
    public static final String POKEMON_ABILITY = "Ability";
    public static final String POKEMON_NATURE = "Nature";

    public PokemonDatabaseHandler(Context context) {
        super(context);
    }
}
