package com.c.a.b.a;

import com.c.a.N;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import com.c.a.x;
import java.net.URI;

final class J extends N<URI> {
    J() {
    }

    public URI a(a aVar) {
        URI uri = null;
        if (aVar.f() == d.NULL) {
            aVar.j();
        } else {
            try {
                String h = aVar.h();
                if (!"null".equals(h)) {
                    uri = new URI(h);
                }
            } catch (Throwable e) {
                throw new x(e);
            }
        }
        return uri;
    }

    public void a(e eVar, URI uri) {
        eVar.b(uri == null ? null : uri.toASCIIString());
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
