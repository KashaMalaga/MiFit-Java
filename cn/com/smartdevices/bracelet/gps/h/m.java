package cn.com.smartdevices.bracelet.gps.h;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.xiaomi.e.a;

public class m {
    public static final String a = "watermark_guide_key";

    private m() {
    }

    public static boolean a(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, true);
    }

    public static boolean a(Context context, String str, String str2) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(str, str2);
        return edit.commit();
    }

    public static boolean a(Context context, String str, boolean z) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(str, z);
        return edit.commit();
    }

    public static String b(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, a.f);
    }

    public static boolean c(Context context, String str) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.remove(str);
        return edit.commit();
    }
}
