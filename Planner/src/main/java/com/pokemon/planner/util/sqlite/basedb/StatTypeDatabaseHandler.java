package com.pokemon.planner.util.sqlite.basedb;

import android.content.Context;

import com.pokemon.planner.util.sqlite.DatabaseHandler;

/**
 * Created by Luka on 2/27/14.
 */
public class StatTypeDatabaseHandler extends DatabaseHandler {

    public static final String STAT_TYPE_ID = "ID";
    public static final String STAT_TYPE = "Stat Type";

    public StatTypeDatabaseHandler(Context context) {
        super(context);
    }
}
