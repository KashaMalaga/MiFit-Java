package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.hm.health.bt.bleservice.a;

public final class C0667t {
    private C0667t() {
    }

    public static boolean a(Context context) {
        return !TextUtils.isEmpty(Utils.g(context));
    }

    public static boolean b(Context context) {
        return !C0667t.a(context);
    }

    public static boolean c(Context context) {
        if (!a.a(context)) {
            return false;
        }
        String a = Utils.a(context, "ro.miui.ui.version.name");
        String a2 = Utils.a(context, "ro.miui.ui.version.code");
        C0596r.e("DeviceCompatibility", "isSupportUnlockScreenByBracelet:miui version name=" + a + ",miui version code=" + a2);
        return (a2 == null || a2.length() == 0 || a == null || a.length() == 0 || Integer.valueOf(a2).intValue() < 3) ? false : true;
    }
}
