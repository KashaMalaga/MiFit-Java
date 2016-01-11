package com.c.a.b.a;

import com.c.a.N;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import java.net.InetAddress;

final class L extends N<InetAddress> {
    L() {
    }

    public InetAddress a(a aVar) {
        if (aVar.f() != d.NULL) {
            return InetAddress.getByName(aVar.h());
        }
        aVar.j();
        return null;
    }

    public void a(e eVar, InetAddress inetAddress) {
        eVar.b(inetAddress == null ? null : inetAddress.getHostAddress());
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
