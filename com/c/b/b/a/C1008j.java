package com.c.b.b.a;

import com.c.b.s;
import java.util.regex.Pattern;

public final class C1008j extends C0999a {
    private static final Pattern a = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    static boolean a(String str) {
        return str != null && a.matcher(str).matches() && str.indexOf(64) >= 0;
    }

    public C1006h a(s sVar) {
        String c = u.c(sVar);
        if (!c.startsWith("MATMSG:")) {
            return null;
        }
        String[] a = C0999a.a("TO:", c, true);
        if (a == null) {
            return null;
        }
        for (String a2 : a) {
            if (!C1008j.a(a2)) {
                return null;
            }
        }
        return new C1006h(a, null, null, C0999a.b("SUB:", c, false), C0999a.b("BODY:", c, false));
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}
