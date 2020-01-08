package br.com.philippesis.androidjunit.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class PrefsUtils {

    private final String MAIN_PREFS = "main-prefs";
    private final String MAIN_PREFS_KEY = "any-str-value";

    public String getMainPrefs(Context context) {

        SharedPreferences preferences = context.getSharedPreferences(MAIN_PREFS, 0);
        return preferences.getString(MAIN_PREFS_KEY, "empty");
    }

    public boolean setMainPrefs(Context context, String value) {

        boolean status = false;

        try {
            SharedPreferences preferences = context.getSharedPreferences(MAIN_PREFS, 0);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(MAIN_PREFS_KEY, value);
            editor.apply();
            status = true;
        } catch (Exception ex) {
            Log.e("Err:", "Erro ao tentar salvar no prefs.", ex);
        }

        return status;
    }

    public String getMainPrefsName() { return MAIN_PREFS; }

    public String getMainPrefsKey() { return MAIN_PREFS_KEY; }

}
