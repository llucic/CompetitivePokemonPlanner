package com.pokemon.planner.dataobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Luka on 3/7/14.
 */
public class Team {
    private int id;
    private String name;
    private List<Pokemon> pokemonList;

    public Team(int id, String name) {
        this.id = id;
        this.name = name;
        pokemonList = new ArrayList<Pokemon>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public boolean addPokemon(Pokemon pokemon) {
        if (pokemonList.size() < 6) {
            pokemonList.add(pokemon);
            return true;
        }
        return false;
    }

    public boolean removePokemon(int position) {
        if (pokemonList.size() > (position + 1)) {
            return false;
        }

        pokemonList.remove(position);
        return true;
    }

    public boolean moveUp(int startPosition) {

        try {
            Collections.swap(pokemonList, startPosition, startPosition - 1);
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }

        return true;
    }

    public boolean moveDown(int startPosition) {

        try {
            Collections.swap(pokemonList, startPosition, startPosition + 1);
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }

        return true;
    }
}
