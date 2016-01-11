package android.support.v4.k;

import android.util.Log;
import java.lang.reflect.Method;

class i {
    private static final String a = "ICUCompatIcs";
    private static Method b;
    private static Method c;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                b = cls.getMethod("getScript", new Class[]{String.class});
                c = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e) {
            Log.w(a, e);
        }
    }

    i() {
    }

    public static String a(String str) {
        try {
            if (b != null) {
                return (String) b.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w(a, e);
        } catch (Throwable e2) {
            Log.w(a, e2);
        }
        return null;
    }

    public static String b(String str) {
        try {
            if (c != null) {
                return (String) c.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w(a, e);
        } catch (Throwable e2) {
            Log.w(a, e2);
        }
        return str;
    }
}
