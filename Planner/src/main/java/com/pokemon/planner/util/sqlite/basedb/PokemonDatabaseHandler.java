package com.pokemon.planner.util.sqlite.basedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.pokemon.planner.dataobjects.PokemonBase;
import com.pokemon.planner.util.sqlite.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luka on 2/27/14.
 */
public class PokemonDatabaseHandler extends DatabaseHandler {

    private static final String TABLE_POKEMON = "pokemon";

    public static final String POKEMON_NUMBER = "Number";
    public static final String POKEMON_NAME = "Name";
    public static final String POKEMON_ABILITY_1 = "Ability_1";
    public static final String POKEMON_ABILITY_2 = "Ability_2";
    public static final String POKEMON_ABILITY_H = "Hidden_Ability";

    public PokemonDatabaseHandler(Context context) {
        super(context);
    }

    public void createPokemonTable(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_POKEMON
                + "(" +
                POKEMON_NUMBER + " TEXT, " +
                POKEMON_NAME + " TEXT, " +
                POKEMON_ABILITY_1 + " TEXT, " +
                POKEMON_ABILITY_2 + " TEXT, " +
                POKEMON_ABILITY_H + " TEXT)";

        db.execSQL(CREATE_TABLE);
    }

    public void dropPokemonTable(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POKEMON);
    }

    public void addPokemon(PokemonBase pokemon) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(POKEMON_NUMBER, pokemon.getDexNumber());
        values.put(POKEMON_NAME, pokemon.getName());
        values.put(POKEMON_ABILITY_1, pokemon.getAbilities()[0]);
        values.put(POKEMON_ABILITY_2, pokemon.getAbilities()[1]);
        values.put(POKEMON_ABILITY_H, pokemon.getHiddenAbility());

        db.insert(TABLE_POKEMON, null, values);
        db.close();
    }

    public PokemonBase getPokemon(String number) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_POKEMON,
                new String[] {POKEMON_NUMBER, POKEMON_NAME, POKEMON_ABILITY_1, POKEMON_ABILITY_2,
                        POKEMON_ABILITY_H}, POKEMON_NUMBER + "=?",
                new String[] { String.valueOf(number) }, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        /*PokemonBase pokemon = new PokemonBase(cursor.getString(0), cursor.getString(1),
                new String[] {cursor.getString(2), cursor.getString(3)},
                cursor.getString(4));*/

        //return pokemon;

        return null;
    }

    public List<PokemonBase> getAllPokemon() {
        List<PokemonBase> pokemonList = new ArrayList<PokemonBase>();

        String selectQuery = "SELECT * FROM " + TABLE_POKEMON;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                /*PokemonBase pokemon = new PokemonBase(cursor.getString(0), cursor.getString(1),
                        new String[] {cursor.getString(2), cursor.getString(3)},
                        cursor.getString(4));

                pokemonList.add(pokemon);*/
            } while (cursor.moveToNext());
        }

        return pokemonList;
    }

    public void addAllPokemon(List<PokemonBase> pokemonList) {
        if (pokemonList == null) return;
        for (int i = 0; i < pokemonList.size(); i++) {
            addPokemon(pokemonList.get(i));
        }
    }
}
