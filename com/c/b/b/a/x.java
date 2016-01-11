package com.c.b.b.a;

import com.c.b.s;

public final class x extends u {
    public w a(s sVar) {
        String c = u.c(sVar);
        if (!c.startsWith("smsto:") && !c.startsWith("SMSTO:") && !c.startsWith("mmsto:") && !c.startsWith("MMSTO:")) {
            return null;
        }
        String substring = c.substring(6);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            c = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
        } else {
            c = null;
        }
        return new w(substring, null, null, c);
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}
