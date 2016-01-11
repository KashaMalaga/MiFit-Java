package com.c.b.b.a;

import com.c.b.a;
import com.c.b.g.z;
import com.c.b.s;

public final class t extends u {
    public s a(s sVar) {
        a d = sVar.d();
        if (d != a.UPC_A && d != a.UPC_E && d != a.EAN_8 && d != a.EAN_13) {
            return null;
        }
        String c = u.c(sVar);
        if (!u.a((CharSequence) c, c.length())) {
            return null;
        }
        String b = (d == a.UPC_E && c.length() == 8) ? z.b(c) : c;
        return new s(c, b);
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}
