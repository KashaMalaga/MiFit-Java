package com.xiaomi.f;

import com.xiaomi.f.c.a;
import com.xiaomi.f.c.e;
import com.xiaomi.f.c.k;
import com.xiaomi.f.e.g;

public class y extends e {
    private z c;

    public z a() {
        return this.c;
    }

    public void a(z zVar) {
        if (zVar == null) {
            this.c = z.a;
        } else {
            this.c = zVar;
        }
    }

    public String c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<bind ");
        if (k() != null) {
            stringBuilder.append("id=\"" + k() + "\" ");
        }
        if (m() != null) {
            stringBuilder.append("to=\"").append(g.a(m())).append("\" ");
        }
        if (n() != null) {
            stringBuilder.append("from=\"").append(g.a(n())).append("\" ");
        }
        if (l() != null) {
            stringBuilder.append(" chid=\"").append(g.a(l())).append("\" ");
        }
        if (this.c == null) {
            stringBuilder.append("type=\"result\">");
        } else {
            stringBuilder.append("type=\"").append(a()).append("\">");
        }
        if (q() != null) {
            for (a d : q()) {
                stringBuilder.append(d.d());
            }
        }
        k p = p();
        if (p != null) {
            stringBuilder.append(p.d());
        }
        stringBuilder.append("</bind>");
        return stringBuilder.toString();
    }
}
