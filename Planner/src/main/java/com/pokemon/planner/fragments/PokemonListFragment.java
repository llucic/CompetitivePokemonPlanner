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
import com.pokemon.planner.util.DataStore;


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

        if (v == null) {
            return null;
        }
        expandableListView = (ExpandableListView)v.findViewById(R.id.exp_PokemonList);
        textView = (TextView)v.findViewById(R.id.txt_emptyList);
        addButton = (Button)v.findViewById(R.id.btn_createNew);

        if (DataStore.customPokemon == null || DataStore.customPokemon.size() == 0) {
            expandableListView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
            textView.setText(getActivity().getString(R.string.no_pokemon));
            addButton.setVisibility(View.VISIBLE);
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    launchPokemonCreator();
                }
            });
        }

        return v;
    }

    private void launchPokemonCreator() {
        
    }
}
