package com.activeandroid.b;

import android.text.TextUtils;
import com.activeandroid.b;
import com.activeandroid.g;

public final class c implements h {
    private b a;
    private Class<? extends g> b;
    private String c;
    private d d;
    private String e;
    private String[] f;

    c(b bVar, Class<? extends g> cls, d dVar) {
        this.a = bVar;
        this.b = cls;
        this.d = dVar;
    }

    public b a(String str, Object... objArr) {
        this.e = str;
        this.a.a(objArr);
        return this.a;
    }

    public b a(String... strArr) {
        this.f = strArr;
        return this.a;
    }

    public c a(String str) {
        this.c = str;
        return this;
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.d != null) {
            stringBuilder.append(this.d.toString()).append(" ");
        }
        stringBuilder.append("JOIN ");
        stringBuilder.append(b.c(this.b));
        stringBuilder.append(" ");
        if (this.c != null) {
            stringBuilder.append("AS ");
            stringBuilder.append(this.c);
            stringBuilder.append(" ");
        }
        if (this.e != null) {
            stringBuilder.append("ON ");
            stringBuilder.append(this.e);
            stringBuilder.append(" ");
        } else if (this.f != null) {
            stringBuilder.append("USING (");
            stringBuilder.append(TextUtils.join(", ", this.f));
            stringBuilder.append(") ");
        }
        return stringBuilder.toString();
    }

    public b b(String str) {
        this.e = str;
        return this.a;
    }
}
