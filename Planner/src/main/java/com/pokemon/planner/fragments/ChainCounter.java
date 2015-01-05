package com.pokemon.planner.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pokemon.planner.R;

/**
 * Created by Luka on 7/26/2014.
 */
public class ChainCounter extends Fragment {

    Button mIncrement;
    Button mReset;

    public static int counter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chain_counter, container, false);

        mIncrement = (Button)v.findViewById(R.id.counter_increment);
        mIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter ++;
                mIncrement.setText("" + counter);
            }
        });

        mReset = (Button)v.findViewById(R.id.counter_reset);
        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = 0;
                mIncrement.setText("0");
            }
        });

        return v;
    }
}
