package teerayut.dev.vlife.utils;

import android.content.Context;
import android.content.SharedPreferences;



/**
 * Created by teera-s on 5/19/2016 AD.
 */
public class MyPreferenceManager {
    private String TAG = MyPreferenceManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    private static final int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "APP";

    private static final String KEY_USERNAME = "USERNAME";
    private static final String KEY_PASSWORD = "PASSWORD";

    // Constructor
    public MyPreferenceManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setPreferrence(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public String getPreferrence(String key) {
        return pref.getString(key, null);
    }

    public void setPreferrenceBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getPreferrenceBoolean(String key) {
        return pref.getBoolean(key, false);
    }

    /*public void setAuthen(AuthenModel authen) {
        editor.putString(KEY_USERNAME, authen.getUsername());
        editor.putString(KEY_PASSWORD, authen.getPassword());
        editor.commit();
    }

    public AuthenModel getAuthen() {
        if (pref.getString(KEY_USERNAME, null) != null) {
            return new AuthenModel()
                    .setUsername(pref.getString(KEY_USERNAME, null))
                    .setPassword(pref.getString(KEY_PASSWORD, null));
        }
        return null;
    }

    public void addNotificationToken(String token) {
        editor.putString(KEY_TOKEN, token);
        editor.commit();
    }

    public String getNotificationsToken() {
        return pref.getString(KEY_TOKEN, null);
    }*/

    public void clear() {
        editor.clear();
        editor.commit();
    }
}
