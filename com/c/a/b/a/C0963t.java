package com.c.a.b.a;

import com.c.a.G;
import com.c.a.N;
import com.c.a.P;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class C0963t extends N<Date> {
    public static final P a = new C0964u();
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    public synchronized Date a(a aVar) {
        Date date;
        if (aVar.f() == d.NULL) {
            aVar.j();
            date = null;
        } else {
            try {
                date = new Date(this.b.parse(aVar.h()).getTime());
            } catch (Throwable e) {
                throw new G(e);
            }
        }
        return date;
    }

    public synchronized void a(e eVar, Date date) {
        eVar.b(date == null ? null : this.b.format(date));
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
