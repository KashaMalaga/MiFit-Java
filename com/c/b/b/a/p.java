package com.c.b.b.a;

import com.c.b.a;
import com.c.b.s;

public final class p extends u {
    public o a(s sVar) {
        if (sVar.d() != a.EAN_13) {
            return null;
        }
        String c = u.c(sVar);
        return c.length() == 13 ? (c.startsWith("978") || c.startsWith("979")) ? new o(c) : null : null;
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}
