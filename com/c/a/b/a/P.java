package com.c.a.b.a;

import com.c.a.N;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class P extends N<Calendar> {
    private static final String a = "year";
    private static final String b = "month";
    private static final String c = "dayOfMonth";
    private static final String d = "hourOfDay";
    private static final String e = "minute";
    private static final String f = "second";

    P() {
    }

    public Calendar a(a aVar) {
        int i = 0;
        if (aVar.f() == d.NULL) {
            aVar.j();
            return null;
        }
        aVar.c();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (aVar.f() != d.END_OBJECT) {
            String g = aVar.g();
            int m = aVar.m();
            if (a.equals(g)) {
                i6 = m;
            } else if (b.equals(g)) {
                i5 = m;
            } else if (c.equals(g)) {
                i4 = m;
            } else if (d.equals(g)) {
                i3 = m;
            } else if (e.equals(g)) {
                i2 = m;
            } else if (f.equals(g)) {
                i = m;
            }
        }
        aVar.d();
        return new GregorianCalendar(i6, i5, i4, i3, i2, i);
    }

    public void a(e eVar, Calendar calendar) {
        if (calendar == null) {
            eVar.f();
            return;
        }
        eVar.d();
        eVar.a(a);
        eVar.a((long) calendar.get(1));
        eVar.a(b);
        eVar.a((long) calendar.get(2));
        eVar.a(c);
        eVar.a((long) calendar.get(5));
        eVar.a(d);
        eVar.a((long) calendar.get(11));
        eVar.a(e);
        eVar.a((long) calendar.get(12));
        eVar.a(f);
        eVar.a((long) calendar.get(13));
        eVar.e();
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
