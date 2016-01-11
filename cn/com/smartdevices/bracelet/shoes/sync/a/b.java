package cn.com.smartdevices.bracelet.shoes.sync.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.xiaomi.e.a;

public class b {
    public String a = a.f;
    public String b = a.f;
    public String c = a.f;
    public String d = a.f;
    public String e = a.f;
    public String f = a.f;
    public String g = a.f;
    public String h = a.f;
    public String i = a.f;
    public String j = a.f;

    public static String a(Context context) {
        return a(context, "ro.build.version.incremental");
    }

    private static String a(Context context, String str) {
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

    public static String b(Context context) {
        return a(context, "ro.miui.ui.version.code");
    }

    public static String c(Context context) {
        return a(context, "ro.miui.ui.version.name");
    }

    public static b d(Context context) {
        b bVar = new b();
        bVar.d = b(context);
        bVar.c = c(context);
        bVar.e = Build.BRAND;
        bVar.f = Build.MODEL;
        bVar.g = a.f + VERSION.SDK_INT;
        try {
            bVar.i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
        }
        return bVar;
    }

    public String toString() {
        return "deviceId:" + this.a + "\n" + "macAddress:" + this.b + "\n" + "miuiVersionName:" + this.c + "\n" + "miuiVersionCode:" + this.d + "\n" + "phoneBrand:" + this.e + "\n" + "phoneModel:" + this.f + "\n" + "phoneSystem:" + this.g + "\n" + "fwVersion:" + this.h + "\n" + "softVersion:" + this.i;
    }
}
