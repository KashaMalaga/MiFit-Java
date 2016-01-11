package com.c.b.f.a;

import com.c.b.s;
import com.c.b.t;
import java.io.Serializable;
import java.util.Comparator;

final class c implements Serializable, Comparator<s> {
    private c() {
    }

    public int a(s sVar, s sVar2) {
        int intValue = ((Integer) sVar.e().get(t.STRUCTURED_APPEND_SEQUENCE)).intValue();
        int intValue2 = ((Integer) sVar2.e().get(t.STRUCTURED_APPEND_SEQUENCE)).intValue();
        return intValue < intValue2 ? -1 : intValue > intValue2 ? 1 : 0;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((s) obj, (s) obj2);
    }
}
