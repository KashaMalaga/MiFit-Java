package com.xiaomi.f;

import cn.com.smartdevices.bracelet.gps.sync.C0483q;
import com.xiaomi.account.openauth.h;

public class z {
    public static final z a = new z(C0483q.g);
    public static final z b = new z(h.P);
    private String c;

    private z(String str) {
        this.c = str;
    }

    public static z a(String str) {
        if (str == null) {
            return null;
        }
        String toLowerCase = str.toLowerCase();
        return b.toString().equals(toLowerCase) ? b : a.toString().equals(toLowerCase) ? a : null;
    }

    public String toString() {
        return this.c;
    }
}
