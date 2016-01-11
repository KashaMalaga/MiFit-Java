package b.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.g.a.p;
import java.lang.reflect.Method;

public class dO {
    private static final String a = "uptr";
    private static final String b = "dntr";

    public static C0333by a(Context context) {
        try {
            C0333by c0333by = new C0333by();
            long[] b = b(context);
            if (b[0] <= 0 || b[1] <= 0) {
                return null;
            }
            SharedPreferences a = C0366dK.a(context);
            long j = a.getLong(a, -1);
            long j2 = a.getLong(b, -1);
            a.edit().putLong(a, b[1]).putLong(b, b[0]).commit();
            if (j <= 0 || j2 <= 0) {
                return null;
            }
            b[0] = b[0] - j2;
            b[1] = b[1] - j;
            if (b[0] <= 0 || b[1] <= 0) {
                return null;
            }
            c0333by.c((int) b[0]);
            c0333by.a((int) b[1]);
            return c0333by;
        } catch (Exception e) {
            bX.e(p.e, "sdk less than 2.2 has get no traffic");
            return null;
        }
    }

    private static long[] b(Context context) {
        Class cls = Class.forName("android.net.TrafficStats");
        Method method = cls.getMethod("getUidRxBytes", new Class[]{Integer.TYPE});
        Method method2 = cls.getMethod("getUidTxBytes", new Class[]{Integer.TYPE});
        if (context.getApplicationInfo().uid == -1) {
            return null;
        }
        r2 = new long[2];
        r2[0] = ((Long) method.invoke(null, new Object[]{Integer.valueOf(context.getApplicationInfo().uid)})).longValue();
        r2[1] = ((Long) method2.invoke(null, new Object[]{Integer.valueOf(r5)})).longValue();
        return r2;
    }
}
