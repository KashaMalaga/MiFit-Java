package com.xiaomi.mipush.sdk;

import android.content.Context;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import com.xiaomi.channel.a.b.a;
import com.xiaomi.push.a.b;

public class c {
    private static boolean a = false;
    private static a b = null;

    public static void a(Context context) {
        a = true;
        c(context);
    }

    public static void a(Context context, a aVar) {
        b = aVar;
        c(context);
    }

    public static void b(Context context) {
        a = false;
        c(context);
    }

    private static void c(Context context) {
        Object obj = b != null ? 1 : null;
        a bVar = new b(context);
        if (!a && d(context) && obj != null) {
            com.xiaomi.channel.a.b.c.a(new com.xiaomi.push.a.a(b, bVar));
        } else if (!a && d(context)) {
            com.xiaomi.channel.a.b.c.a(bVar);
        } else if (obj != null) {
            com.xiaomi.channel.a.b.c.a(b);
        } else {
            com.xiaomi.channel.a.b.c.a(new com.xiaomi.push.a.a(null, null));
        }
    }

    private static boolean d(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), ChartData.d).requestedPermissions;
            if (strArr == null) {
                return false;
            }
            for (Object equals : strArr) {
                if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(equals)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
