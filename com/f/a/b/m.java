package com.f.a.b;

import com.f.a.b.d.c;
import com.f.a.b.d.d;
import java.io.InputStream;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class m implements c {
    private final c a;

    public m(c cVar) {
        this.a = cVar;
    }

    public InputStream a(String str, Object obj) {
        switch (k.a[d.a(str).ordinal()]) {
            case l.a /*1*/:
            case a.k /*2*/:
                throw new IllegalStateException();
            default:
                return this.a.a(str, obj);
        }
    }
}
