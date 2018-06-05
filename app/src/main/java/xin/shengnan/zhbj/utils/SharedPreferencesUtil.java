package xin.shengnan.zhbj.utils;

import android.content.Context;

import xin.shengnan.zhbj.config.Keys;

/**
 * Created by ${Li} on 2018/6/5.
 */

public class SharedPreferencesUtil {

    /**
     * 获取boolean值
     * */
    public static boolean getBoolean(Context context, String key, boolean def) {
        return context.getSharedPreferences(Keys.CONFIG, Context.MODE_PRIVATE).getBoolean(key, def);
    }

    /**
     * 放置boolean值
     * */
    public static void putBoolean(Context context, String key, boolean value) {
        context.getSharedPreferences(Keys.CONFIG, Context.MODE_PRIVATE).edit().putBoolean(key, value).apply();
    }

    /**
     * 获取String值
     * */
    public static String getString(Context context, String key, String def) {
        return context.getSharedPreferences(Keys.CONFIG, Context.MODE_PRIVATE).getString(key, def);
    }

    /**
     * 放置String值
     * */
    public static void putString(Context context, String key, String value) {
        context.getSharedPreferences(Keys.CONFIG, Context.MODE_PRIVATE).edit().putString(key, value).apply();
    }
}
