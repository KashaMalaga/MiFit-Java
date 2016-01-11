package com.c.a.b.a;

import com.c.a.N;
import com.c.a.d.a;
import com.c.a.d.e;
import java.sql.Timestamp;
import java.util.Date;

class O extends N<Timestamp> {
    final /* synthetic */ N a;
    final /* synthetic */ N b;

    O(N n, N n2) {
        this.b = n;
        this.a = n2;
    }

    public Timestamp a(a aVar) {
        Date date = (Date) this.a.b(aVar);
        return date != null ? new Timestamp(date.getTime()) : null;
    }

    public void a(e eVar, Timestamp timestamp) {
        this.a.a(eVar, (Object) timestamp);
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
