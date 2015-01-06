package com.pokemon.planner.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.pokemon.planner.R;
import com.pokemon.planner.adapters.PokemonListAdapter;
import com.pokemon.planner.dataobjects.Pokemon;
import com.pokemon.planner.util.DataStore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


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
        } else {
            Map<Pokemon, List<Pokemon>> pokemonDetails = new HashMap<>();
            for (int i = 0; i < DataStore.customPokemon.size(); i++) {
                List<Pokemon> detail = new ArrayList<>();
                detail.add(DataStore.customPokemon.get(i));

                pokemonDetails.put(DataStore.customPokemon.get(i), detail);
            }

            PokemonListAdapter adapter = new PokemonListAdapter(getActivity(), DataStore.customPokemon, pokemonDetails);

            expandableListView.setAdapter(adapter);
            expandableListView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
            addButton.setVisibility(View.GONE);
        }

        return v;
    }

    private void launchPokemonCreator() {
        
    }
}
