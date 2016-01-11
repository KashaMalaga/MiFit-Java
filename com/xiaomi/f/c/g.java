package com.xiaomi.f.c;

import android.os.Bundle;
import android.support.v4.view.a.C0113o;
import android.support.v7.widget.af;

public class g extends e {
    private i c = i.available;
    private String d = null;
    private int e = af.a;
    private h f = null;

    public g(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_pres_type")) {
            this.c = i.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.d = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.e = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f = h.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public g(i iVar) {
        a(iVar);
    }

    public void a(int i) {
        if (i < -128 || i > C0113o.h) {
            throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
        }
        this.e = i;
    }

    public void a(h hVar) {
        this.f = hVar;
    }

    public void a(i iVar) {
        if (iVar == null) {
            throw new NullPointerException("Type cannot be null");
        }
        this.c = iVar;
    }

    public void a(String str) {
        this.d = str;
    }

    public Bundle b() {
        Bundle b = super.b();
        if (this.c != null) {
            b.putString("ext_pres_type", this.c.toString());
        }
        if (this.d != null) {
            b.putString("ext_pres_status", this.d);
        }
        if (this.e != af.a) {
            b.putInt("ext_pres_prio", this.e);
        }
        if (!(this.f == null || this.f == h.available)) {
            b.putString("ext_pres_mode", this.f.toString());
        }
        return b;
    }

    public String c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<presence");
        if (t() != null) {
            stringBuilder.append(" xmlns=\"").append(t()).append("\"");
        }
        if (k() != null) {
            stringBuilder.append(" id=\"").append(k()).append("\"");
        }
        if (m() != null) {
            stringBuilder.append(" to=\"").append(com.xiaomi.f.e.g.a(m())).append("\"");
        }
        if (n() != null) {
            stringBuilder.append(" from=\"").append(com.xiaomi.f.e.g.a(n())).append("\"");
        }
        if (l() != null) {
            stringBuilder.append(" chid=\"").append(com.xiaomi.f.e.g.a(l())).append("\"");
        }
        if (this.c != null) {
            stringBuilder.append(" type=\"").append(this.c).append("\"");
        }
        stringBuilder.append(">");
        if (this.d != null) {
            stringBuilder.append("<status>").append(com.xiaomi.f.e.g.a(this.d)).append("</status>");
        }
        if (this.e != af.a) {
            stringBuilder.append("<priority>").append(this.e).append("</priority>");
        }
        if (!(this.f == null || this.f == h.available)) {
            stringBuilder.append("<show>").append(this.f).append("</show>");
        }
        stringBuilder.append(s());
        k p = p();
        if (p != null) {
            stringBuilder.append(p.d());
        }
        stringBuilder.append("</presence>");
        return stringBuilder.toString();
    }
}
