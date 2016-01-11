package com.c.a.b.a;

import com.c.a.N;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import java.util.Locale;
import java.util.StringTokenizer;

final class Q extends N<Locale> {
    Q() {
    }

    public Locale a(a aVar) {
        if (aVar.f() == d.NULL) {
            aVar.j();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(aVar.h(), "_");
        String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
    }

    public void a(e eVar, Locale locale) {
        eVar.b(locale == null ? null : locale.toString());
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
