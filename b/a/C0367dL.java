package b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.g.a.C1059a;
import com.g.a.p;
import com.xiaomi.e.a;
import com.xiaomi.mistatistic.sdk.d;
import java.util.Arrays;
import java.util.List;

public class C0367dL {
    private static final String a = "session_start_time";
    private static final String b = "session_end_time";
    private static final String c = "session_id";
    private static final String f = "activities";
    private final String d = "a_start_time";
    private final String e = "a_end_time";

    private String a(Context context, SharedPreferences sharedPreferences) {
        dx a = dx.a(context);
        String b = b(context);
        dF a2 = a(context);
        Editor edit = sharedPreferences.edit();
        edit.putString(c, b);
        edit.putLong(a, System.currentTimeMillis());
        edit.putLong(b, 0);
        edit.commit();
        if (a2 != null) {
            a.a(a2);
        } else {
            a.a(null);
        }
        return b;
    }

    private void a(SharedPreferences sharedPreferences) {
        Editor edit = sharedPreferences.edit();
        edit.remove(a);
        edit.remove(b);
        edit.remove(c);
        edit.remove("a_start_time");
        edit.remove("a_end_time");
        edit.putString(f, a.f);
        edit.commit();
    }

    private boolean b(SharedPreferences sharedPreferences) {
        long j = sharedPreferences.getLong("a_start_time", 0);
        long j2 = sharedPreferences.getLong("a_end_time", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (j == 0 || currentTimeMillis - j >= C1059a.n) {
            return currentTimeMillis - j2 > C1059a.n;
        } else {
            bX.b(p.e, "onResume called before onPause");
            return false;
        }
    }

    public C0381g a(Context context) {
        SharedPreferences a = C0366dK.a(context);
        String string = a.getString(c, null);
        if (string == null) {
            return null;
        }
        long j = a.getLong(a, 0);
        long j2 = a.getLong(b, 0);
        long j3 = 0;
        if (j2 != 0) {
            j3 = j2 - j;
            if (Math.abs(j3) > d.h) {
                j3 = 0;
            }
        }
        C0381g c0381g = new C0381g();
        c0381g.a(string);
        c0381g.a(j);
        c0381g.b(j2);
        c0381g.c(j3);
        double[] a2 = C1059a.a();
        if (a2 != null) {
            aK aKVar = new aK(a2[0], a2[1], System.currentTimeMillis());
            if (c0381g.y()) {
                c0381g.a(aKVar);
            } else {
                c0381g.b(Arrays.asList(new aK[]{aKVar}));
            }
        }
        C0333by a3 = dO.a(context);
        if (a3 != null) {
            c0381g.a(a3);
        }
        List a4 = dP.a(a);
        if (a4 != null && a4.size() > 0) {
            c0381g.a(a4);
        }
        a(a);
        return c0381g;
    }

    public String b(Context context) {
        String f = bW.f(context);
        String a = C1059a.a(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (a == null) {
            throw new RuntimeException("Appkey is null or empty, Please check AndroidManifest.xml");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(currentTimeMillis).append(a).append(f);
        return C0352cm.a(stringBuilder.toString());
    }

    public void c(Context context) {
        SharedPreferences a = C0366dK.a(context);
        if (a != null) {
            if (b(a)) {
                bX.a(p.e, "Start new session: " + a(context, a));
            } else {
                bX.a(p.e, "Extend current session: " + a.getString(c, null));
            }
            Editor edit = a.edit();
            edit.putLong("a_start_time", System.currentTimeMillis());
            edit.putLong("a_end_time", 0);
            edit.commit();
        }
    }

    public void d(Context context) {
        SharedPreferences a = C0366dK.a(context);
        if (a != null) {
            if (a.getLong("a_start_time", 0) == 0 && C1059a.j) {
                bX.b(p.e, "onPause called before onResume");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Editor edit = a.edit();
            edit.putLong("a_start_time", 0);
            edit.putLong("a_end_time", currentTimeMillis);
            edit.putLong(b, currentTimeMillis);
            edit.commit();
        }
    }
}
