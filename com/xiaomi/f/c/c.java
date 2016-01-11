package com.xiaomi.f.c;

import cn.com.smartdevices.bracelet.gps.sync.C0483q;
import com.xiaomi.account.openauth.h;

public class c {
    public static final c a = new c("get");
    public static final c b = new c("set");
    public static final c c = new c(C0483q.g);
    public static final c d = new c(h.P);
    private String e;

    private c(String str) {
        this.e = str;
    }

    public static c a(String str) {
        if (str == null) {
            return null;
        }
        String toLowerCase = str.toLowerCase();
        return a.toString().equals(toLowerCase) ? a : b.toString().equals(toLowerCase) ? b : d.toString().equals(toLowerCase) ? d : c.toString().equals(toLowerCase) ? c : null;
    }

    public String toString() {
        return this.e;
    }
}
