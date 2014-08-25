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
import android.widget.TextView;

import com.pokemon.planner.R;
import com.pokemon.planner.dataobjects.PokemonBase;
import com.pokemon.planner.filters.InputFilterMinMax;
import com.pokemon.planner.util.Calculator;
import com.pokemon.planner.util.DataStore;
import com.pokemon.planner.util.Nature;

/**
 * Created by Luka on 6/27/2014.
 */
public class PokemonCreationFragment extends Fragment {

    PokemonBase chosenPokemonBase;

    AutoCompleteTextView pokemonChooser;
    AutoCompleteTextView abilityChooser;
    AutoCompleteTextView natureChooser;
    EditText levelChooser;
    EditText hpEvValue;
    EditText atkEvValue;
    EditText defEvValue;
    EditText spaEvValue;
    EditText spdEvValue;
    EditText speEvValue;

    TextView hpTotalValue;
    TextView atkTotalValue;
    TextView defTotalValue;
    TextView spaTotalValue;
    TextView spdTotalValue;
    TextView speTotalValue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (DataStore.natures == null || DataStore.natures.size() == 0) {
            DataStore.initNatures();
        }

        if (DataStore.pokemon == null || DataStore.pokemon.size() == 0) {
            DataStore.initPokemon(getActivity());
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pokemon_edit_base, container, false);

        if (v == null) {
            return null;
        }

        abilityChooser = (AutoCompleteTextView)v.findViewById(R.id.pokemon_ability);

        pokemonChooser = (AutoCompleteTextView)v.findViewById(R.id.pokemon_choice);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, getPokemonNames());

        pokemonChooser.setAdapter(adapter);

        pokemonChooser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PokemonCreationFragment.this.chosenPokemonBase = DataStore.pokemon.get(i);
                ArrayAdapter<String> abilityAdapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1,
                        getPokemonAbilities(PokemonCreationFragment.this.chosenPokemonBase));

                abilityChooser.setAdapter(abilityAdapter);
            }
        });

        natureChooser = (AutoCompleteTextView)v.findViewById(R.id.pokemon_nature);
        natureChooser.setThreshold(1);
        adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, getNatures());

        natureChooser.setAdapter(adapter);

        hpTotalValue = (TextView)v.findViewById(R.id.lbl_total_hp);
        hpTotalValue.setText("" + Calculator.getHpForLevel(100,
                (int)chosenPokemonBase.getBaseStats().hp,
                0,
                31));
        atkTotalValue = (TextView)v.findViewById(R.id.lbl_total_atk);
        atkTotalValue.setText("" + Calculator.getStatForLevel(100,
                (int)chosenPokemonBase.getBaseStats().attack,
                0,
                31,
                getNatureModifier(getResources().getStringArray(R.array.stats)[1])));
        defTotalValue = (TextView)v.findViewById(R.id.lbl_total_def);
        defTotalValue.setText("" + Calculator.getStatForLevel(100,
                (int)chosenPokemonBase.getBaseStats().defence,
                0,
                31,
                getNatureModifier(getResources().getStringArray(R.array.stats)[2])));
        spaTotalValue = (TextView)v.findViewById(R.id.lbl_total_spa);
        spaTotalValue.setText("" + Calculator.getStatForLevel(100,
                (int)chosenPokemonBase.getBaseStats().sp_attack,
                0,
                31,
                getNatureModifier(getResources().getStringArray(R.array.stats)[3])));
        spdTotalValue = (TextView)v.findViewById(R.id.lbl_total_spd);
        spdTotalValue.setText("" + Calculator.getStatForLevel(100,
                (int)chosenPokemonBase.getBaseStats().sp_defence,
                0,
                31,
                getNatureModifier(getResources().getStringArray(R.array.stats)[4])));
        speTotalValue = (TextView)v.findViewById(R.id.lbl_total_spe);
        speTotalValue.setText("" + Calculator.getStatForLevel(100,
                (int)chosenPokemonBase.getBaseStats().speed,
                0,
                31,
                getNatureModifier(getResources().getStringArray(R.array.stats)[5])));

        levelChooser = (EditText)v.findViewById(R.id.pokemon_level);
        levelChooser.setFilters(new InputFilter[] {new InputFilterMinMax(1,100)});
        levelChooser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int level = Integer.parseInt(s.toString());
                double hp = Calculator.getHpForLevel(level, (int) chosenPokemonBase.getBaseStats().hp, Integer.parseInt(hpEvValue.getText().toString()), 31);
                hpTotalValue.setText("" + hp);
                double atk = Calculator.getStatForLevel(level, (int) chosenPokemonBase.getBaseStats().attack, Integer.parseInt(atkEvValue.getText().toString()), 31, getNatureModifier("Attack"));
                atkTotalValue.setText("" + atk);
                double def = Calculator.getStatForLevel(level, (int) chosenPokemonBase.getBaseStats().defence, Integer.parseInt(defEvValue.getText().toString()), 31, getNatureModifier("Attack"));
                defTotalValue.setText("" + def);
                double spa = Calculator.getStatForLevel(level, (int) chosenPokemonBase.getBaseStats().sp_attack, Integer.parseInt(spaEvValue.getText().toString()), 31, getNatureModifier("Attack"));
                spaTotalValue.setText("" + spa);
                double spd = Calculator.getStatForLevel(level, (int) chosenPokemonBase.getBaseStats().sp_defence, Integer.parseInt(spdEvValue.getText().toString()), 31, getNatureModifier("Attack"));
                spdTotalValue.setText("" + spd);
                double spe = Calculator.getStatForLevel(level,(int)chosenPokemonBase.getBaseStats().speed, Integer.parseInt(speEvValue.getText().toString()), 31, getNatureModifier("Attack"));
                speTotalValue.setText("" + spe);
            }
        });
        levelChooser.setText("1");

        hpEvValue = (EditText)v.findViewById(R.id.txt_hp_ev);
        hpEvValue.setFilters(new InputFilter[] {new InputFilterMinMax(0,252)});
        hpEvValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int level = Integer.parseInt(levelChooser.getText().toString());
                double hp = Calculator.getHpForLevel(level,(int)chosenPokemonBase.getBaseStats().hp, Integer.parseInt(s.toString()), 31);
                hpTotalValue.setText("" + hp);
            }
        });
        hpEvValue.setText("0");

        atkEvValue = (EditText)v.findViewById(R.id.txt_atk_ev);
        atkEvValue.setFilters(new InputFilter[] {new InputFilterMinMax(0,252)});
        atkEvValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int level = Integer.parseInt(levelChooser.getText().toString());
                double atk = Calculator.getStatForLevel(level,(int)chosenPokemonBase.getBaseStats().attack, Integer.parseInt(s.toString()), 31, 1);
                atkTotalValue.setText("" + atk);
            }
        });
        atkEvValue.setText("0");

        defEvValue = (EditText)v.findViewById(R.id.txt_def_ev);
        defEvValue.setFilters(new InputFilter[] {new InputFilterMinMax(0,252)});
        defEvValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int level = Integer.parseInt(levelChooser.getText().toString());
                double def = Calculator.getStatForLevel(level,(int)chosenPokemonBase.getBaseStats().defence, Integer.parseInt(s.toString()), 31, 1);
                defTotalValue.setText("" + def);
            }
        });
        defEvValue.setText("0");

        spaEvValue = (EditText)v.findViewById(R.id.txt_spa_ev);
        spaEvValue.setFilters(new InputFilter[] {new InputFilterMinMax(0,252)});
        spaEvValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int level = Integer.parseInt(levelChooser.getText().toString());
                double spAtk = Calculator.getStatForLevel(level,(int)chosenPokemonBase.getBaseStats().sp_attack, Integer.parseInt(s.toString()), 31, 1);
                spaTotalValue.setText("" + spAtk);
            }
        });
        spaEvValue.setText("0");

        spdEvValue = (EditText)v.findViewById(R.id.txt_spd_ev);
        spdEvValue.setFilters(new InputFilter[] {new InputFilterMinMax(0,252)});
        spdEvValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int level = Integer.parseInt(levelChooser.getText().toString());
                double spDef = Calculator.getStatForLevel(level,(int)chosenPokemonBase.getBaseStats().sp_defence, Integer.parseInt(s.toString()), 31, 1);
                spdTotalValue.setText("" + spDef);
            }
        });
        spdEvValue.setText("0");

        speEvValue = (EditText)v.findViewById(R.id.txt_spe_ev);
        speEvValue.setFilters(new InputFilter[] {new InputFilterMinMax(0,252)});
        speEvValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int level = Integer.parseInt(levelChooser.getText().toString());
                double speed = Calculator.getStatForLevel(level,(int)chosenPokemonBase.getBaseStats().speed, Integer.parseInt(s.toString()), 31, 1);
                speTotalValue.setText("" + speed);
            }
        });
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

    private String[] getPokemonAbilities(PokemonBase pokemon) {
        String[] abilities = new String[pokemon.getAbilities().length + 1];
        for (int i = 0; i < pokemon.getAbilities().length; i++) {
            abilities[i] = pokemon.getAbilities()[i];
        }

        if (pokemon.getHiddenAbility() != null && !pokemon.getHiddenAbility().equals("")) {
            abilities[pokemon.getAbilities().length] = pokemon.getHiddenAbility();
        }
        return abilities;
    }

    private double getNatureModifier(String stat) {
        for(Nature nature : DataStore.natures) {
            if (natureChooser.getText().toString().equalsIgnoreCase(nature.toString())) {
                if (nature.boosted().equalsIgnoreCase(stat)) {
                    return 1.1;
                }
                if (nature.hindered().equalsIgnoreCase(stat)) {
                    return 0.9;
                }
                return 1;
            }
        }
        return 1;
    }
}
