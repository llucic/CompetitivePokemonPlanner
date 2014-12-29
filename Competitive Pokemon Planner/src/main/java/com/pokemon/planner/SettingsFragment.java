package com.pokemon.planner;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

/**
 * Created by llucic on 23/12/2014.
 */
public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_main);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
        Preference levelPreference = findPreference("pref_level");
        levelPreference.setSummary("Level " + getPreferenceManager().getSharedPreferences().getString("pref_level", "50") + " selected");
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("pref_level")) {
            Preference levelPreference = findPreference(key);
            levelPreference.setSummary("Level " + sharedPreferences.getString(key, "50") + " selected");
        }

        if (key.equals("pref_theme")) {
            Preference themePreference = findPreference(key);
            themePreference.setSummary("Pokemon " + sharedPreferences.getString(key, "") + "Theme selected");

            String theme = sharedPreferences.getString(key, "");
        }
    }
}
