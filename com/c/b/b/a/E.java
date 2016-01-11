package com.c.b.b.a;

import com.c.b.s;

public final class E extends u {
    public C a(s sVar) {
        String str = null;
        String c = u.c(sVar);
        if (!c.startsWith("urlto:") && !c.startsWith("URLTO:")) {
            return null;
        }
        int indexOf = c.indexOf(58, 6);
        if (indexOf < 0) {
            return null;
        }
        if (indexOf > 6) {
            str = c.substring(6, indexOf);
        }
        return new C(c.substring(indexOf + 1), str);
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}
