package com.pokemon.planner.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.pokemon.planner.R;
import com.pokemon.planner.dataobjects.PokemonBase;
import com.pokemon.planner.filters.InputFilterMinMax;
import com.pokemon.planner.util.DataStore;
import com.pokemon.planner.util.Nature;
import com.pokemon.planner.util.QuickAutoCompleteTextView;

import java.util.ArrayList;

/**
 * Created by Luka on 6/27/2014.
 */
public class PokemonCreationFragment extends Fragment {

    PokemonBase chosenPokemonBase;

    AutoCompleteTextView pokemonChooser;
    AutoCompleteTextView natureChooser;
    EditText levelChooser;
    EditText hpEvValue;
    EditText atkEvValue;
    EditText defEvValue;
    EditText spaEvValue;
    EditText spdEvValue;
    EditText speEvValue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (DataStore.natures == null || DataStore.natures.size() == 0) {
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
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pokemon_edit_base, container, false);

        if (v == null) {
            return null;
        }

        /*pokemonChooser = (AutoCompleteTextView)v.findViewById(R.id.pokemon_choice);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, getPokemonNames());

        pokemonChooser.setAdapter(adapter);

        pokemonChooser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PokemonCreationFragment.this.chosenPokemonBase = DataStore.pokemon.get(i);
            }
        });*/

        natureChooser = (AutoCompleteTextView)v.findViewById(R.id.pokemon_nature);
        natureChooser.setThreshold(1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, getNatures());

        natureChooser.setAdapter(adapter);

        levelChooser = (EditText)v.findViewById(R.id.pokemon_level);
        levelChooser.setFilters(new InputFilter[] {new InputFilterMinMax(1,100)});
        levelChooser.setText("1");

        hpEvValue = (EditText)v.findViewById(R.id.txt_hp_ev);
        hpEvValue.setFilters(new InputFilter[] {new InputFilterMinMax(0,252)});
        hpEvValue.setText("0");

        atkEvValue = (EditText)v.findViewById(R.id.txt_atk_ev);
        atkEvValue.setFilters(new InputFilter[] {new InputFilterMinMax(0,252)});
        atkEvValue.setText("0");

        defEvValue = (EditText)v.findViewById(R.id.txt_def_ev);
        defEvValue.setFilters(new InputFilter[] {new InputFilterMinMax(0,252)});
        defEvValue.setText("0");

        spaEvValue = (EditText)v.findViewById(R.id.txt_spa_ev);
        spaEvValue.setFilters(new InputFilter[] {new InputFilterMinMax(0,252)});
        spaEvValue.setText("0");

        spdEvValue = (EditText)v.findViewById(R.id.txt_spd_ev);
        spdEvValue.setFilters(new InputFilter[] {new InputFilterMinMax(0,252)});
        spdEvValue.setText("0");

        speEvValue = (EditText)v.findViewById(R.id.txt_spe_ev);
        speEvValue.setFilters(new InputFilter[] {new InputFilterMinMax(0,252)});
        speEvValue.setText("0");

        return v;
    }

    private String[] getPokemonNames() {

        String[] pokemonNames = new String[DataStore.pokemon.size()];
        for(PokemonBase pokemonBase : DataStore.pokemon) {
            pokemonNames[DataStore.pokemon.indexOf(pokemonBase)] = pokemonBase.getName();
        }
        return pokemonNames;
    }

    private String[] getNatures() {

        String[] natures = new String[DataStore.natures.size()];
        for(Nature nature : DataStore.natures) {
            natures[DataStore.natures.indexOf(nature)] = nature.toString();
        }
        return natures;
    }
}
