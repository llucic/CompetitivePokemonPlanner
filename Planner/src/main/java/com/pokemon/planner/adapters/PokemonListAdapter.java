package com.pokemon.planner.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.pokemon.planner.dataobjects.Pokemon;

import java.util.List;
import java.util.Map;

/**
 * Created by Luka on 3/7/14.
 */
public class PokemonListAdapter extends BaseExpandableListAdapter {

    Map<Integer, List<Pokemon>> teamPokemon;
    List<Integer> teams;
    Context context;

    public PokemonListAdapter(Context context, List<Integer> teams,
                              Map<Integer, List<Pokemon>> teamPokemon) {
        this.context = context;
        this.teamPokemon = teamPokemon;
        this.teams = teams;
    }


    @Override
    public int getGroupCount() {
        return teams.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return teamPokemon.get(teams.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return teams.get(i);
    }

    @Override
    public Object getChild(int i, int i2) {
        return teamPokemon.get(teams.get(i)).get(i2);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public View getChildView(int i, int i2, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return false;
    }
}
