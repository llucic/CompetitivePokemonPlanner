package com.pokemon.planner.util.settings;

import android.content.SharedPreferences;

import com.pokemon.planner.R;

/**
 * Created by llucic on 30/12/2014.
 */
public class ThemesUtil {

    public static int getThemeFromSettings(String settings) {

        if (settings.equalsIgnoreCase("Omega Ruby")) {
            return R.style.OmegaRubyTheme;
        }

        if (settings.equalsIgnoreCase("Alpha Sapphire")) {
            return R.style.AlphaSapphireTheme;
        }

        if (settings.equalsIgnoreCase("X")) {
            return R.style.XTheme;
        }

        if (settings.equalsIgnoreCase("Y")) {
            return R.style.YTheme;
        }

        return R.style.AppTheme;
    }

}
