package com.c.b.b.a;

import com.c.b.s;

public final class A extends u {
    public z a(s sVar) {
        String c = u.c(sVar);
        if (!c.startsWith("tel:") && !c.startsWith("TEL:")) {
            return null;
        }
        String str = c.startsWith("TEL:") ? "tel:" + c.substring(4) : c;
        int indexOf = c.indexOf(63, 4);
        return new z(indexOf < 0 ? c.substring(4) : c.substring(4, indexOf), str, null);
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}
