package com.pokemon.planner.adapters;

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

    List<Pokemon> pokemon;
    Map<Pokemon, List<Pokemon>> details;
    Context context;

    public PokemonListAdapter(Context context, List<Pokemon> pokemon,
                              Map<Pokemon, List<Pokemon>> details) {
        this.context = context;
        this.pokemon = pokemon;
        this.details = details;
    }

    @Override
    public int getGroupCount() {
        return pokemon.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return details.get(pokemon.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return details.get(i);
    }

    @Override
    public Object getChild(int i, int i2) {
        return details.get(pokemon.get(i)).get(i2);
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
