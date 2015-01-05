package com.pokemon.planner.util.sqlite.basedb;

import android.content.Context;

import com.pokemon.planner.util.sqlite.DatabaseHandler;

/**
 * Created by Luka on 2/27/14.
 */
public class ItemDatabaseHandler extends DatabaseHandler {

    public static final String ITEM_ID = "ID";
    public static final String ITEM_NAME = "Name";

    public ItemDatabaseHandler(Context context) {
        super(context);
    }
}
