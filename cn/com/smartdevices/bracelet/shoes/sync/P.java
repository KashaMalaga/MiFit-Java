package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.a.a;
import cn.com.smartdevices.bracelet.j.d;
import cn.com.smartdevices.bracelet.j.h;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.e;
import java.io.File;
import java.util.List;

public class P {
    private static final String a = "shoesIcon";

    private P() {
    }

    private static R a(Context context, String str, e eVar, File file) {
        R r = new R();
        d.b.b(context, h.b(str, String.valueOf(System.currentTimeMillis())), new Q(file, r, eVar));
        return r;
    }

    private static String a(String str, int i) {
        return str + i + "_big" + ".png";
    }

    static boolean a(Context context) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            String g = a.g(a);
            if (g == null) {
                C0596r.d(B.a, "fail to make dir under thumb");
                return false;
            }
            List<e> d = t.d(context);
            if (d == null || d.size() == 0) {
                return true;
            }
            boolean z = true;
            for (e eVar : d) {
                if (eVar != null) {
                    if (a(eVar.m)) {
                        new File(eVar.m).delete();
                    }
                    if (a(eVar.n)) {
                        new File(eVar.n).delete();
                    }
                    z = a(context, eVar, g) & z;
                }
            }
            return z;
        }
        C0596r.d(B.a, "media not mounted");
        return false;
    }

    static boolean a(Context context, e eVar) {
        if (eVar == null) {
            return false;
        }
        if (Environment.getExternalStorageState().equals("mounted")) {
            String g = a.g(a);
            if (g != null) {
                return a(context, eVar, g);
            }
            C0596r.e(B.a, "fail to make dir under thumb");
            return false;
        }
        C0596r.e(B.a, "media not mounted");
        return false;
    }

    private static boolean a(Context context, e eVar, String str) {
        R a;
        boolean z = true;
        Object obj = eVar.c;
        if (!(a(eVar.m) || TextUtils.isEmpty(obj))) {
            a = a(context, obj, eVar, new File(str, b(eVar.e, eVar.f)));
            if (TextUtils.isEmpty(a.a)) {
                z = false;
            } else {
                eVar.e(a.a);
                z = true & t.a(context, eVar);
            }
        }
        obj = eVar.k;
        if (a(eVar.n) || TextUtils.isEmpty(obj)) {
            return z;
        }
        a = a(context, obj, eVar, new File(str, a(eVar.e, eVar.f)));
        if (TextUtils.isEmpty(a.a)) {
            return z & 0;
        }
        eVar.a(a.a);
        return z & t.a(context, eVar);
    }

    public static boolean a(String str) {
        return TextUtils.isEmpty(str) ? false : new File(str).exists();
    }

    private static String b(String str, int i) {
        return str + i + "_small" + ".png";
    }
}
