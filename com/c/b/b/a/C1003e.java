package com.c.b.b.a;

import com.c.b.s;
import java.util.ArrayList;
import java.util.List;

public final class C1003e extends C0999a {
    private static String a(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 != null) {
            str = str + ' ' + str2;
        }
        return str;
    }

    private static String[] a(String str, String str2, String str3) {
        List arrayList = new ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        return size == 0 ? null : (String[]) arrayList.toArray(new String[size]);
    }

    public C1002d a(s sVar) {
        String c = u.c(sVar);
        if (!c.startsWith("BIZCARD:")) {
            return null;
        }
        String a = C1003e.a(C0999a.b("N:", c, true), C0999a.b("X:", c, true));
        String b = C0999a.b("T:", c, true);
        String b2 = C0999a.b("C:", c, true);
        return new C1002d(u.b(a), null, null, C1003e.a(C0999a.b("B:", c, true), C0999a.b("M:", c, true), C0999a.b("F:", c, true)), null, u.b(C0999a.b("E:", c, true)), null, null, null, C0999a.a("A:", c, true), null, b2, null, b, null, null);
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}
