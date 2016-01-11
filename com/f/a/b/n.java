package com.f.a.b;

import com.f.a.b.d.c;
import com.f.a.b.d.d;
import java.io.InputStream;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class n implements c {
    private final c a;

    public n(c cVar) {
        this.a = cVar;
    }

    public InputStream a(String str, Object obj) {
        InputStream a = this.a.a(str, obj);
        switch (k.a[d.a(str).ordinal()]) {
            case l.a /*1*/:
            case a.k /*2*/:
                return new com.f.a.b.a.d(a);
            default:
                return a;
        }
    }
}
