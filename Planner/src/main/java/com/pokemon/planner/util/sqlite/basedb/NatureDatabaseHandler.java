package com.pokemon.planner.util.sqlite.basedb;

import android.content.Context;

import com.pokemon.planner.util.sqlite.DatabaseHandler;

/**
 * Created by Luka on 2/27/14.
 */
public class NatureDatabaseHandler extends DatabaseHandler {

    private static final String TABLE_BANKS = "natures";

    public static final String NATURE_ID = "ID";
    public static final String NATURE_NAME = "Name";
    public static final String NATURE_PLUS = "Positive_Boost";
    public static final String NATURE_MINUS = "Negative_Boost";

    public NatureDatabaseHandler(Context context) {
        super(context);
    }
}
