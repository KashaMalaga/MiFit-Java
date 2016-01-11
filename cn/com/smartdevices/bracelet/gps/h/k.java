package cn.com.smartdevices.bracelet.gps.h;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xiaomi.e.a;

public class k {
    public static String a(Context context) {
        return a(context, "ro.miui.ui.version.name");
    }

    public static String a(Context context, String str) {
        String str2 = a.f;
        try {
            Class loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) loadClass.getMethod("get", new Class[]{String.class}).invoke(loadClass, new Object[]{str});
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e2) {
            return a.f;
        }
    }

    public static boolean b(Context context) {
        return (!TextUtils.isEmpty(a(context)) && VERSION.SDK_INT >= 19) || VERSION.SDK_INT >= 21;
    }
}
