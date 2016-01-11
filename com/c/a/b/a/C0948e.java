package com.c.a.b.a;

import com.c.a.G;
import com.c.a.N;
import com.c.a.P;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class C0948e extends N<Date> {
    public static final P a = new C0949f();
    private final DateFormat b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat c = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat d = C0948e.b();

    private static DateFormat b() {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    private synchronized Date b(String str) {
        Date parse;
        try {
            parse = this.c.parse(str);
        } catch (ParseException e) {
            try {
                parse = this.b.parse(str);
            } catch (ParseException e2) {
                try {
                    parse = this.d.parse(str);
                } catch (Throwable e3) {
                    throw new G(str, e3);
                }
            }
        }
        return parse;
    }

    public Date a(a aVar) {
        if (aVar.f() != d.NULL) {
            return b(aVar.h());
        }
        aVar.j();
        return null;
    }

    public synchronized void a(e eVar, Date date) {
        if (date == null) {
            eVar.f();
        } else {
            eVar.b(this.b.format(date));
        }
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
