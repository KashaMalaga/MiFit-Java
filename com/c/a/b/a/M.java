package com.c.a.b.a;

import com.c.a.N;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import java.util.UUID;

final class M extends N<UUID> {
    M() {
    }

    public UUID a(a aVar) {
        if (aVar.f() != d.NULL) {
            return UUID.fromString(aVar.h());
        }
        aVar.j();
        return null;
    }

    public void a(e eVar, UUID uuid) {
        eVar.b(uuid == null ? null : uuid.toString());
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
