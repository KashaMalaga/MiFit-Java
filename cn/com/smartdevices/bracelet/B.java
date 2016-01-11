package cn.com.smartdevices.bracelet;

import a.a.a.t;
import a.a.a.x;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xiaomi.account.openauth.h;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class B implements x {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final String d = "support_steps_provider";
    private static final String e = "MiuiAPI";
    private static B f = null;
    private static final String h = "\\d+.\\d+.\\d+(-internal)?";
    private static final boolean i;
    private static final boolean j;
    private t g = null;

    static {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(VERSION.INCREMENTAL) && VERSION.INCREMENTAL.matches(h);
        i = z2;
        if (!"user".equals(Build.TYPE) || i) {
            z = false;
        }
        j = z;
    }

    private B() {
    }

    public static B a() {
        if (f == null) {
            f = new B();
        }
        return f;
    }

    public static boolean a(Context context, String str) {
        try {
            Class cls = Class.forName("miui.util.FeatureParser");
            Class[] clsArr = new Class[c];
            clsArr[a] = String.class;
            clsArr[b] = Boolean.TYPE;
            Method method = cls.getMethod("getBoolean", clsArr);
            Object[] objArr = new Object[c];
            objArr[a] = str;
            objArr[b] = Boolean.valueOf(false);
            return ((Boolean) method.invoke(cls, objArr)).booleanValue();
        } catch (IllegalArgumentException e) {
            C0596r.d(e, "iAE:" + e.getMessage());
            return false;
        } catch (Exception e2) {
            C0596r.d(e, "exception:" + e2.getMessage());
            return false;
        }
    }

    public static boolean b(Context context) {
        return Utils.a(context, "ro.product.mod_device").endsWith("_alpha");
    }

    public static boolean c(Context context) {
        if (TextUtils.isEmpty(Utils.g(context))) {
            return false;
        }
        try {
            String[] split;
            if (e()) {
                split = VERSION.INCREMENTAL.split("\\.");
                return Integer.valueOf(split[a].substring(b)).intValue() >= 6 && Integer.valueOf(split[b]).intValue() >= 5;
            } else if (d()) {
                split = VERSION.INCREMENTAL.split("\\.");
                r3 = Integer.valueOf(split[a]).intValue();
                r4 = Integer.valueOf(split[b]).intValue();
                return r3 > 5 ? true : r3 >= 5 ? r4 > 3 ? true : r4 >= 3 && Integer.valueOf(split[c]).intValue() >= 13 : false;
            } else if (!b(context)) {
                return false;
            } else {
                split = VERSION.INCREMENTAL.split("\\.");
                r3 = Integer.valueOf(split[a]).intValue();
                r4 = Integer.valueOf(split[b]).intValue();
                return r3 > 5 ? true : r3 >= 5 ? r4 > 3 ? true : r4 >= 3 && Integer.valueOf(split[c]).intValue() >= 6 : false;
            }
        } catch (Exception e) {
            C0596r.d(e, "isSupportNotify has Exception.. ");
            return false;
        }
    }

    public static boolean d() {
        return i;
    }

    public static boolean e() {
        return j;
    }

    public void a(t tVar) {
        C0596r.d(e, "MiBleDeviceManager onInit!");
        this.g = tVar;
    }

    public void a(Context context) {
        C0596r.d(e, "init");
        this.g = t.a(context, (x) this);
    }

    public boolean a(String str) {
        C0596r.d(e, "unbindDevice:" + str);
        try {
            return this.g.b(str);
        } catch (Exception e) {
            C0596r.d(e, e.getMessage());
            return false;
        }
    }

    public boolean a(String str, int i) {
        C0596r.d(e, "setAlertIncallDelay:" + i);
        try {
            return this.g.a(str, t.d, i * h.E);
        } catch (Exception e) {
            C0596r.d(e, e.getMessage());
            return false;
        }
    }

    public boolean a(String str, boolean z) {
        C0596r.d(e, "setAlertAlarm:" + z);
        try {
            return this.g.a(str, t.b, z);
        } catch (Exception e) {
            C0596r.d(e, e.getMessage());
            return false;
        }
    }

    public void b() {
        C0596r.d(e, "MiBleDeviceManager onDestroy!");
        this.g = null;
    }

    public boolean b(String str) {
        try {
            boolean a = this.g.a(str, t.b);
            C0596r.d(e, "isSetAlertAlarm:" + a);
            return a;
        } catch (Exception e) {
            C0596r.d(e, e.getMessage());
            return false;
        }
    }

    public boolean b(String str, boolean z) {
        C0596r.d(e, "setAlertIncall:" + z);
        try {
            return ((b & this.g.a(str, t.c, z)) & this.g.a(str, t.e, z)) & this.g.a(str, t.f, z);
        } catch (Exception e) {
            C0596r.d(e, e.getMessage());
            return false;
        }
    }

    public List<String> c() {
        try {
            List<String> c = this.g.c();
            if (c == null) {
                return null;
            }
            List<String> arrayList = new ArrayList();
            for (String str : c) {
                int c2 = this.g.c(str);
                C0596r.d(e, "bound device type:" + c2);
                if (c2 == b) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            C0596r.d(e, "e:" + th.getMessage());
            return null;
        }
    }

    public boolean c(String str) {
        try {
            boolean a = this.g.a(str, t.c);
            C0596r.d(e, "isSetAlertIncall:" + a);
            return a;
        } catch (Exception e) {
            C0596r.d(e, e.getMessage());
            return false;
        }
    }

    public boolean c(String str, boolean z) {
        C0596r.d(e, "setAlertSms:" + z);
        try {
            return ((b & this.g.a(str, t.g, z)) & this.g.a(str, t.h, z)) & this.g.a(str, t.i, z);
        } catch (Exception e) {
            C0596r.d(e, e.getMessage());
            return false;
        }
    }

    public boolean d(String str) {
        try {
            boolean a = this.g.a(str, t.g);
            C0596r.d(e, "isSetAlertSms:" + a);
            return a;
        } catch (Exception e) {
            C0596r.d(e, e.getMessage());
            return false;
        }
    }

    public boolean d(String str, boolean z) {
        C0596r.d(e, "setSupportMiuiAlertIncall:" + z);
        try {
            int a = (b & this.g.a(str, t.c, z)) & this.g.a(str, t.e, z);
            if (!c(str)) {
                return a & this.g.a(str, t.f, z);
            }
            if (!z) {
                return a & this.g.a(str, t.f, z);
            }
            return a & this.g.a(str, t.f, this.g.a(str, t.f));
        } catch (Exception e) {
            C0596r.d(e, e.getMessage());
            return false;
        }
    }

    public int e(String str) {
        try {
            int b = this.g.b(str, t.d);
            C0596r.d(e, "getIncallDelay:" + b);
            return b / h.E;
        } catch (Exception e) {
            C0596r.d(e, e.getMessage());
            return c;
        }
    }

    public boolean e(String str, boolean z) {
        C0596r.d(e, "setAlertSms:" + z);
        try {
            int a = (b & this.g.a(str, t.g, z)) & this.g.a(str, t.h, z);
            if (!d(str)) {
                return a & this.g.a(str, t.i, z);
            }
            if (!z) {
                return a & this.g.a(str, t.i, z);
            }
            return a & this.g.a(str, t.i, this.g.a(str, t.i));
        } catch (Exception e) {
            C0596r.d(e, e.getMessage());
            return false;
        }
    }

    public boolean f() {
        try {
            int b = this.g.b();
            C0596r.d(e, "isSupportMiuiNotify version:" + b);
            return b >= c;
        } catch (Throwable th) {
            C0596r.d(e, th.getMessage());
            return false;
        }
    }

    public boolean f(String str) {
        C0596r.d(e, "isNoContactsAlertIncall--");
        try {
            boolean a = this.g.a(str, t.e);
            boolean a2 = this.g.a(str, t.f);
            C0596r.d(e, "isInContactsInCall = " + a + " , isOutContactsInCall = " + a2);
            return !a2 && a;
        } catch (Exception e) {
            C0596r.d(e, e.getMessage());
            return false;
        }
    }

    public boolean f(String str, boolean z) {
        boolean z2 = true;
        C0596r.d(e, "setAlertIncallNoContact:" + z);
        try {
            if (c(str)) {
                int a = (this.g.a(str, t.c, true) & b) & this.g.a(str, t.e, true);
                t tVar = this.g;
                String str2 = t.f;
                if (z) {
                    z2 = false;
                }
                return tVar.a(str, str2, z2) & a;
            }
            b(str, z);
            return true;
        } catch (Exception e) {
            C0596r.d(e, e.getMessage());
            return false;
        }
    }

    public boolean g(String str) {
        C0596r.d(e, "isSetAlertNoContactsSms----------");
        try {
            boolean a = this.g.a(str, t.h);
            boolean a2 = this.g.a(str, t.i);
            C0596r.d(e, "isInContacts = " + a + " , isOutContacts = " + a2);
            return a && !a2;
        } catch (Exception e) {
            C0596r.d(e, e.getMessage());
            return false;
        }
    }

    public boolean g(String str, boolean z) {
        boolean z2 = true;
        C0596r.d(e, "setAlertNoContactsSms:" + z);
        try {
            if (d(str)) {
                int a = (this.g.a(str, t.g, true) & b) & this.g.a(str, t.h, true);
                t tVar = this.g;
                String str2 = t.i;
                if (z) {
                    z2 = false;
                }
                return tVar.a(str, str2, z2) & a;
            }
            c(str, z);
            return true;
        } catch (Exception e) {
            C0596r.d(e, e.getMessage());
            return false;
        }
    }
}
