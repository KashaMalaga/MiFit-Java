package com.xiaomi.f.c;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class k {
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private List<a> f = null;

    public k(int i, String str, String str2, String str3, String str4, List<a> list) {
        this.a = i;
        this.b = str;
        this.d = str2;
        this.c = str3;
        this.e = str4;
        this.f = list;
    }

    public k(Bundle bundle) {
        this.a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.b = bundle.getString("ext_err_type");
        }
        this.c = bundle.getString("ext_err_cond");
        this.d = bundle.getString("ext_err_reason");
        this.e = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                a a = a.a((Bundle) parcelable);
                if (a != null) {
                    this.f.add(a);
                }
            }
        }
    }

    public k(l lVar) {
        a(lVar);
        this.e = null;
    }

    public k(l lVar, String str) {
        a(lVar);
        this.e = str;
    }

    private void a(l lVar) {
        this.c = lVar.y;
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.b;
    }

    public Bundle c() {
        Bundle bundle = new Bundle();
        if (this.b != null) {
            bundle.putString("ext_err_type", this.b);
        }
        bundle.putInt("ext_err_code", this.a);
        if (this.d != null) {
            bundle.putString("ext_err_reason", this.d);
        }
        if (this.c != null) {
            bundle.putString("ext_err_cond", this.c);
        }
        if (this.e != null) {
            bundle.putString("ext_err_msg", this.e);
        }
        if (this.f != null) {
            Parcelable[] parcelableArr = new Bundle[this.f.size()];
            int i = 0;
            for (a e : this.f) {
                int i2;
                Bundle e2 = e.e();
                if (e2 != null) {
                    i2 = i + 1;
                    parcelableArr[i] = e2;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            bundle.putParcelableArray("ext_exts", parcelableArr);
        }
        return bundle;
    }

    public String d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<error code=\"").append(this.a).append("\"");
        if (this.b != null) {
            stringBuilder.append(" type=\"");
            stringBuilder.append(this.b);
            stringBuilder.append("\"");
        }
        if (this.d != null) {
            stringBuilder.append(" reason=\"");
            stringBuilder.append(this.d);
            stringBuilder.append("\"");
        }
        stringBuilder.append(">");
        if (this.c != null) {
            stringBuilder.append("<").append(this.c);
            stringBuilder.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.e != null) {
            stringBuilder.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            stringBuilder.append(this.e);
            stringBuilder.append("</text>");
        }
        for (a d : e()) {
            stringBuilder.append(d.d());
        }
        stringBuilder.append("</error>");
        return stringBuilder.toString();
    }

    public synchronized List<a> e() {
        return this.f == null ? Collections.emptyList() : Collections.unmodifiableList(this.f);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.c != null) {
            stringBuilder.append(this.c);
        }
        stringBuilder.append("(").append(this.a).append(")");
        if (this.e != null) {
            stringBuilder.append(" ").append(this.e);
        }
        return stringBuilder.toString();
    }
}
