package com.xiaomi.d.a;

import com.xiaomi.channel.a.b.c;
import com.xiaomi.f.c.e;
import com.xiaomi.f.r;
import java.util.Date;

class d implements r {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public void a(e eVar) {
        if (a.a) {
            c.b("SMACK " + this.a.b.format(new Date()) + " RCV PKT (" + this.a.c.hashCode() + "): " + eVar.c());
        }
    }
}
