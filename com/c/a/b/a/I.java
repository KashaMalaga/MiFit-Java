package com.c.a.b.a;

import com.c.a.N;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import java.net.URL;

final class I extends N<URL> {
    I() {
    }

    public URL a(a aVar) {
        if (aVar.f() == d.NULL) {
            aVar.j();
            return null;
        }
        String h = aVar.h();
        return !"null".equals(h) ? new URL(h) : null;
    }

    public void a(e eVar, URL url) {
        eVar.b(url == null ? null : url.toExternalForm());
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
