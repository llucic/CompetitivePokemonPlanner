package com.pokemon.planner.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.pokemon.planner.R;

/**
 * Created by Luka on 2/27/14.
 */
public class PokemonListFragment extends Fragment {

    private ExpandableListView expandableListView;
    private TextView textView;
    private Button addButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pokemon_list, container, false);

        return v;
    }
}
