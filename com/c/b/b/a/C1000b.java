package com.c.b.b.a;

import com.c.b.s;
import java.util.ArrayList;
import java.util.List;

public final class C1000b extends u {
    private static String[] a(String str, int i, String str2, boolean z) {
        List list = null;
        for (int i2 = 1; i2 <= i; i2++) {
            String b = u.b(str + i2 + ':', str2, '\r', z);
            if (b == null) {
                break;
            }
            if (list == null) {
                list = new ArrayList(i);
            }
            list.add(b);
        }
        return list == null ? null : (String[]) list.toArray(new String[list.size()]);
    }

    public C1002d a(s sVar) {
        String c = u.c(sVar);
        if (!c.contains("MEMORY") || !c.contains("\r\n")) {
            return null;
        }
        return new C1002d(u.b(u.b("NAME1:", c, '\r', true)), null, u.b("NAME2:", c, '\r', true), C1000b.a("TEL", 3, c, true), null, C1000b.a("MAIL", 3, c, true), null, null, u.b("MEMORY:", c, '\r', false), u.b("ADD:", c, '\r', true) == null ? null : new String[]{u.b("ADD:", c, '\r', true)}, null, null, null, null, null, null);
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}
