package com.xiaomi.c.a;

import com.xiaomi.e.a;
import java.util.HashMap;
import java.util.Map;

public final class C1081l {
    private Map<C1076h, String> a;
    private boolean b;
    private String c;

    private C1081l() {
    }

    private static C1081l b(C1079j c1079j) {
        C1081l c1081l = new C1081l();
        c1081l.a = c1079j.c();
        c1081l.b = true;
        c1081l.c = c1079j.c;
        return c1081l;
    }

    public C1079j a() {
        if (this.a == null) {
            this.a = new HashMap();
        }
        if (this.c == null) {
            this.c = a.f;
        }
        return new C1079j(this.a, this.c);
    }

    public C1081l a(C1076h c1076h, String str) {
        if (this.a == null) {
            this.a = new HashMap();
        } else if (this.b) {
            this.a = new HashMap(this.a);
            this.b = false;
        }
        if (str == null) {
            this.a.remove(c1076h);
        } else {
            this.a.put(c1076h, str);
        }
        return this;
    }

    public C1081l a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("payload XML argument cannot be null");
        }
        this.c = str;
        return this;
    }

    public C1081l a(String str, String str2) {
        return a(C1076h.a("http://www.w3.org/XML/1998/namespace", str, "xmlns"), str2);
    }
}
