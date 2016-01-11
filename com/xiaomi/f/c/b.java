package com.xiaomi.f.c;

import android.os.Bundle;
import com.xiaomi.f.e.g;

public class b extends e {
    private c c = c.a;

    public b(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_iq_type")) {
            this.c = c.a(bundle.getString("ext_iq_type"));
        }
    }

    public c a() {
        return this.c;
    }

    public void a(c cVar) {
        if (cVar == null) {
            this.c = c.a;
        } else {
            this.c = cVar;
        }
    }

    public Bundle b() {
        Bundle b = super.b();
        if (this.c != null) {
            b.putString("ext_iq_type", this.c.toString());
        }
        return b;
    }

    public String c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<iq ");
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
            stringBuilder.append("chid=\"").append(g.a(l())).append("\" ");
        }
        if (this.c == null) {
            stringBuilder.append("type=\"get\">");
        } else {
            stringBuilder.append("type=\"").append(a()).append("\">");
        }
        String d = d();
        if (d != null) {
            stringBuilder.append(d);
        }
        stringBuilder.append(s());
        k p = p();
        if (p != null) {
            stringBuilder.append(p.d());
        }
        stringBuilder.append("</iq>");
        return stringBuilder.toString();
    }

    public String d() {
        return null;
    }
}
