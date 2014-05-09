package com.pokemon.planner.util.sqlite.userdb;

import android.content.Context;

import com.pokemon.planner.util.sqlite.DatabaseHandler;

/**
 * Created by Luka on 2/27/14.
 */
public class TeamDatabaseHandler extends DatabaseHandler {

    public static final String TEAM_ID = "ID";
    public static final String TEAM_NAME = "Name";
    public static final String TEAM_SLOT_1 = "Slot 1";
    public static final String TEAM_SLOT_2 = "Slot 2";
    public static final String TEAM_SLOT_3 = "Slot 3";
    public static final String TEAM_SLOT_4 = "Slot 4";
    public static final String TEAM_SLOT_5 = "Slot 5";
    public static final String TEAM_SLOT_6 = "Slot 6";

    public TeamDatabaseHandler(Context context) {
        super(context);
    }
}
