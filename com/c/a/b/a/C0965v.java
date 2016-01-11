package com.c.a.b.a;

import com.c.a.G;
import com.c.a.N;
import com.c.a.P;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class C0965v extends N<Time> {
    public static final P a = new C0966w();
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    public synchronized Time a(a aVar) {
        Time time;
        if (aVar.f() == d.NULL) {
            aVar.j();
            time = null;
        } else {
            try {
                time = new Time(this.b.parse(aVar.h()).getTime());
            } catch (Throwable e) {
                throw new G(e);
            }
        }
        return time;
    }

    public synchronized void a(e eVar, Time time) {
        eVar.b(time == null ? null : this.b.format(time));
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
