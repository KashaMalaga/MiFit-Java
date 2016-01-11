package com.c.b.b.a;

import com.c.b.s;

public final class K extends u {
    public J a(s sVar) {
        String c = u.c(sVar);
        if (!c.startsWith("WIFI:")) {
            return null;
        }
        String b = u.b("S:", c, ';', false);
        if (b == null || b.isEmpty()) {
            return null;
        }
        String b2 = u.b("P:", c, ';', false);
        String b3 = u.b("T:", c, ';', false);
        if (b3 == null) {
            b3 = "nopass";
        }
        return new J(b3, b, b2, Boolean.parseBoolean(u.b("H:", c, ';', false)));
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}
