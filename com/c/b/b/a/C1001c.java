package com.c.b.b.a;

import com.c.b.s;

public final class C1001c extends C0999a {
    private static String a(String str) {
        int indexOf = str.indexOf(44);
        return indexOf >= 0 ? str.substring(indexOf + 1) + ' ' + str.substring(0, indexOf) : str;
    }

    public C1002d a(s sVar) {
        String c = u.c(sVar);
        if (!c.startsWith("MECARD:")) {
            return null;
        }
        String[] a = C0999a.a("N:", c, true);
        if (a == null) {
            return null;
        }
        String a2 = C1001c.a(a[0]);
        String b = C0999a.b("SOUND:", c, true);
        String[] a3 = C0999a.a("TEL:", c, true);
        String[] a4 = C0999a.a("EMAIL:", c, true);
        String b2 = C0999a.b("NOTE:", c, false);
        String[] a5 = C0999a.a("ADR:", c, true);
        String b3 = C0999a.b("BDAY:", c, true);
        if (!u.a((CharSequence) b3, 8)) {
            b3 = null;
        }
        String[] a6 = C0999a.a("URL:", c, true);
        return new C1002d(u.b(a2), null, b, a3, null, a4, null, null, b2, a5, null, C0999a.b("ORG:", c, true), b3, null, a6, null);
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}
