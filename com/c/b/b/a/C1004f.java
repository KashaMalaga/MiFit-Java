package com.c.b.b.a;

import com.c.b.s;

public final class C1004f extends C0999a {
    public C a(s sVar) {
        String a = sVar.a();
        if (!a.startsWith("MEBKM:")) {
            return null;
        }
        String b = C0999a.b("TITLE:", a, true);
        String[] a2 = C0999a.a("URL:", a, true);
        if (a2 == null) {
            return null;
        }
        a = a2[0];
        return D.a(a) ? new C(a, b) : null;
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}
