package com.c.b.b.a;

import com.c.b.s;

public final class y extends u {
    public C1006h a(s sVar) {
        String c = u.c(sVar);
        if (!c.startsWith("smtp:") && !c.startsWith("SMTP:")) {
            return null;
        }
        String substring;
        String substring2;
        String str;
        c = c.substring(5);
        int indexOf = c.indexOf(58);
        if (indexOf >= 0) {
            substring = c.substring(indexOf + 1);
            c = c.substring(0, indexOf);
            indexOf = substring.indexOf(58);
            if (indexOf >= 0) {
                substring2 = substring.substring(indexOf + 1);
                substring = substring.substring(0, indexOf);
                str = c;
            } else {
                substring2 = null;
                str = c;
            }
        } else {
            substring2 = null;
            substring = null;
            str = c;
        }
        return new C1006h(new String[]{str}, null, null, substring, substring2);
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}
