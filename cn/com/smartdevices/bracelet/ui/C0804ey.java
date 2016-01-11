package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.mipush.sdk.f;
import java.util.Map;
import java.util.Set;

public class C0804ey {
    private static final String a = "SettingPreferences";
    private static final String b = "SettingPreferences";
    private static SharedPreferences c;

    private C0804ey() {
    }

    public static Object a(Context context, String str) {
        Object obj;
        if (c == null) {
            c = context.getSharedPreferences(b, 0);
        }
        Map all = c.getAll();
        for (String str2 : all.keySet()) {
            if (str2.equals(str)) {
                obj = all.get(str2);
                break;
            }
        }
        obj = null;
        if (obj == null) {
            C0596r.g(b, "Not Found Value For : " + str);
        }
        C0596r.e(b, "Read : " + str + f.i + obj);
        return obj;
    }

    public static void a(Context context, String str, Object obj) {
        if (c == null) {
            c = context.getSharedPreferences(b, 0);
        }
        C0596r.e(b, "Save : " + str + f.i + obj);
        Editor edit = c.edit();
        if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Set) {
            try {
                edit.putStringSet(str, (Set) obj);
            } catch (Exception e) {
                e.printStackTrace();
                C0596r.g(b, "Not Support Value Type : " + obj);
            }
        } else {
            C0596r.g(b, "Not Support Value Type : " + obj);
        }
        edit.commit();
    }

    public static Object b(Context context, String str, Object obj) {
        Object a = C0804ey.a(context, str);
        return a == null ? obj : a;
    }
}
