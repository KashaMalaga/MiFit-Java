package com.xiaomi.account.openauth;

import android.os.Bundle;
import android.text.TextUtils;

public class l {
    private final n a;
    private final m b;
    private final Bundle c;

    private l(Bundle bundle, m mVar) {
        this.c = bundle;
        this.a = null;
        this.b = mVar;
    }

    private l(Bundle bundle, n nVar) {
        this.c = bundle;
        this.a = nVar;
        this.b = null;
    }

    public static l a(Bundle bundle) {
        return bundle == null ? null : e(bundle, h.ag, h.P) != 0 ? new l(bundle, m.b(bundle)) : new l(bundle, n.b(bundle));
    }

    private static String d(Bundle bundle, String str, String str2) {
        return bundle.containsKey(str) ? bundle.getString(str) : bundle.getString(str2);
    }

    private static int e(Bundle bundle, String str, String str2) {
        return bundle.containsKey(str) ? bundle.getInt(str) : bundle.getInt(str2);
    }

    private static String f(Bundle bundle, String str, String str2) {
        for (String str3 : new String[]{str, str2}) {
            if (!TextUtils.isEmpty(str3) && bundle.containsKey(str3)) {
                Object obj = bundle.get(str3);
                if (obj != null) {
                    return obj instanceof Integer ? ((Integer) obj).toString() : obj.toString();
                }
            }
        }
        return null;
    }

    public Bundle a() {
        return this.c;
    }

    public String b() {
        return this.a != null ? this.a.a : null;
    }

    public String c() {
        return this.a != null ? this.a.b : null;
    }

    public String d() {
        return this.a != null ? this.a.c : null;
    }

    public String e() {
        return this.a != null ? this.a.d : null;
    }

    public String f() {
        return this.a != null ? this.a.e : null;
    }

    public String g() {
        return this.a != null ? this.a.f : null;
    }

    public String h() {
        return this.a != null ? this.a.g : null;
    }

    public String i() {
        return this.a != null ? this.a.h : null;
    }

    public int j() {
        return this.b != null ? this.b.a : 0;
    }

    public String k() {
        return this.b != null ? this.b.b : null;
    }

    public boolean l() {
        return this.b != null;
    }

    public String toString() {
        if (this.a != null) {
            return this.a.toString();
        }
        if (this.b != null) {
            return this.b.toString();
        }
        throw new IllegalStateException("should not be here.");
    }
}
