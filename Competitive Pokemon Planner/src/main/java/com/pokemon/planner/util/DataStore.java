package com.pokemon.planner.util;

import android.content.Context;

import com.pokemon.planner.dataobjects.Pokemon;
import com.pokemon.planner.dataobjects.PokemonBase;
import com.pokemon.planner.util.jsonparser.JsonParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Luka on 3/7/14.
 */
public class DataStore {
    public static List<String> pokemonNames;
    public static List<PokemonBase> pokemon;
    public static List<Pokemon> customPokemon;

    public static List<Nature> natures;

    public static void initNatures() {
        DataStore.natures = new ArrayList<Nature>();
        DataStore.natures.add(Nature.HARDY);
        DataStore.natures.add(Nature.LONELY);
        DataStore.natures.add(Nature.BRAVE);
        DataStore.natures.add(Nature.ADAMANT);
        DataStore.natures.add(Nature.NAUGHTY);
        DataStore.natures.add(Nature.BOLD);
        DataStore.natures.add(Nature.DOCILE);
        DataStore.natures.add(Nature.RELAXED);
        DataStore.natures.add(Nature.IMPISH);
        DataStore.natures.add(Nature.LAX);
        DataStore.natures.add(Nature.TIMID);
        DataStore.natures.add(Nature.HASTY);
        DataStore.natures.add(Nature.SERIOUS);
        DataStore.natures.add(Nature.JOLLY);
        DataStore.natures.add(Nature.NAIVE);
        DataStore.natures.add(Nature.MODEST);
        DataStore.natures.add(Nature.MILD);
        DataStore.natures.add(Nature.QUIET);
        DataStore.natures.add(Nature.BASHFUL);
        DataStore.natures.add(Nature.RASH);
        DataStore.natures.add(Nature.CALM);
        DataStore.natures.add(Nature.GENTLE);
        DataStore.natures.add(Nature.SASSY);
        DataStore.natures.add(Nature.CAREFUL);
        DataStore.natures.add(Nature.QUIRKY);
    }

    public static void initPokemon(Context c) {
        JsonParser parser = new JsonParser();
        pokemon = new ArrayList<PokemonBase>();
        List<Integer> megas = new ArrayList<Integer>(Arrays.asList(3, 9, 65, 94, 115, 127, 130, 142));
        parser.initContext(c);
        for (int i = 0; i < 151; i++) {
            pokemon.add(parser.parsePokemonData(i + ""));
            if (megas.contains(i)) {
                pokemon.add(parser.parsePokemonData(i + " - Mega"));
            }

            if (i == 6 || i == 150) {
                pokemon.add(parser.parsePokemonData(i + " - Mega X"));
                pokemon.add(parser.parsePokemonData(i + " - Mega Y"));
            }
        }
    }
}
