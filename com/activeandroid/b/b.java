package com.activeandroid.b;

import android.text.TextUtils;
import com.activeandroid.content.ContentProvider;
import com.activeandroid.g;
import com.xiaomi.mipush.sdk.f;
import java.util.ArrayList;
import java.util.List;

public final class b implements h {
    private h a;
    private Class<? extends g> b;
    private String c;
    private List<c> d;
    private final StringBuilder e = new StringBuilder();
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private List<Object> k;

    public b(Class<? extends g> cls, h hVar) {
        this.b = cls;
        this.d = new ArrayList();
        this.a = hVar;
        this.d = new ArrayList();
        this.k = new ArrayList();
    }

    private void a(StringBuilder stringBuilder) {
        stringBuilder.append("FROM ");
        stringBuilder.append(com.activeandroid.b.c(this.b)).append(" ");
        if (this.c != null) {
            stringBuilder.append("AS ");
            stringBuilder.append(this.c);
            stringBuilder.append(" ");
        }
    }

    private void b(StringBuilder stringBuilder) {
        for (c a : this.d) {
            stringBuilder.append(a.a());
        }
    }

    private void c(StringBuilder stringBuilder) {
        if (this.e.length() > 0) {
            stringBuilder.append("WHERE ");
            stringBuilder.append(this.e);
            stringBuilder.append(" ");
        }
    }

    private void d(StringBuilder stringBuilder) {
        if (this.f != null) {
            stringBuilder.append("GROUP BY ");
            stringBuilder.append(this.f);
            stringBuilder.append(" ");
        }
    }

    private void e(StringBuilder stringBuilder) {
        if (this.g != null) {
            stringBuilder.append("HAVING ");
            stringBuilder.append(this.g);
            stringBuilder.append(" ");
        }
    }

    private void f(StringBuilder stringBuilder) {
        if (this.h != null) {
            stringBuilder.append("ORDER BY ");
            stringBuilder.append(this.h);
            stringBuilder.append(" ");
        }
    }

    private void g(StringBuilder stringBuilder) {
        if (this.i != null) {
            stringBuilder.append("LIMIT ");
            stringBuilder.append(this.i);
            stringBuilder.append(" ");
        }
    }

    private void h(StringBuilder stringBuilder) {
        if (this.j != null) {
            stringBuilder.append("OFFSET ");
            stringBuilder.append(this.j);
            stringBuilder.append(" ");
        }
    }

    private String i(StringBuilder stringBuilder) {
        String trim = stringBuilder.toString().trim();
        if (com.activeandroid.d.b.a()) {
            com.activeandroid.d.b.a(trim + " " + TextUtils.join(f.i, h()));
        }
        return trim;
    }

    public b a(int i) {
        return h(String.valueOf(i));
    }

    public b a(String str) {
        this.c = str;
        return this;
    }

    public b a(String str, Object... objArr) {
        b(str).a(objArr);
        return this;
    }

    public c a(Class<? extends g> cls) {
        c cVar = new c(this, cls, null);
        this.d.add(cVar);
        return cVar;
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.a());
        a(stringBuilder);
        b(stringBuilder);
        c(stringBuilder);
        d(stringBuilder);
        e(stringBuilder);
        f(stringBuilder);
        g(stringBuilder);
        h(stringBuilder);
        return i(stringBuilder);
    }

    void a(Object[] objArr) {
        for (Object obj : objArr) {
            Object obj2;
            if (obj2.getClass() == Boolean.TYPE || obj2.getClass() == Boolean.class) {
                obj2 = Integer.valueOf(obj2.equals(Boolean.valueOf(true)) ? 1 : 0);
            }
            this.k.add(obj2);
        }
    }

    public b b(int i) {
        return i(String.valueOf(i));
    }

    public b b(String str) {
        if (this.e.length() > 0) {
            this.e.append(" AND ");
        }
        this.e.append(str);
        return this;
    }

    public b b(String str, Object... objArr) {
        return a(str, objArr);
    }

    public c b(Class<? extends g> cls) {
        c cVar = new c(this, cls, d.LEFT);
        this.d.add(cVar);
        return cVar;
    }

    public String b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT EXISTS(SELECT 1 ");
        a(stringBuilder);
        b(stringBuilder);
        c(stringBuilder);
        d(stringBuilder);
        e(stringBuilder);
        g(stringBuilder);
        h(stringBuilder);
        stringBuilder.append(")");
        return i(stringBuilder);
    }

    public b c(String str) {
        return b(str);
    }

    public b c(String str, Object... objArr) {
        d(str).a(objArr);
        return this;
    }

    public c c(Class<? extends g> cls) {
        c cVar = new c(this, cls, d.OUTER);
        this.d.add(cVar);
        return cVar;
    }

    public String c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT(*) ");
        a(stringBuilder);
        b(stringBuilder);
        c(stringBuilder);
        d(stringBuilder);
        e(stringBuilder);
        g(stringBuilder);
        h(stringBuilder);
        return i(stringBuilder);
    }

    public b d(String str) {
        if (this.e.length() > 0) {
            this.e.append(" OR ");
        }
        this.e.append(str);
        return this;
    }

    public c d(Class<? extends g> cls) {
        c cVar = new c(this, cls, d.INNER);
        this.d.add(cVar);
        return cVar;
    }

    public <T extends g> List<T> d() {
        if (this.a instanceof e) {
            return com.activeandroid.d.f.a(this.b, a(), h());
        }
        com.activeandroid.d.f.a(a(), h());
        com.activeandroid.b.f().getContentResolver().notifyChange(ContentProvider.a(this.b, null), null);
        return null;
    }

    public b e(String str) {
        this.f = str;
        return this;
    }

    public c e(Class<? extends g> cls) {
        c cVar = new c(this, cls, d.CROSS);
        this.d.add(cVar);
        return cVar;
    }

    public <T extends g> T e() {
        if (this.a instanceof e) {
            a(1);
            return com.activeandroid.d.f.b(this.b, a(), h());
        }
        a(1);
        com.activeandroid.d.f.b(this.b, a(), h()).delete();
        return null;
    }

    public b f(String str) {
        this.g = str;
        return this;
    }

    public boolean f() {
        return com.activeandroid.d.f.a(b(), h()) != 0;
    }

    public int g() {
        return com.activeandroid.d.f.a(c(), h());
    }

    public b g(String str) {
        this.h = str;
        return this;
    }

    public b h(String str) {
        this.i = str;
        return this;
    }

    public String[] h() {
        int size = this.k.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = this.k.get(i).toString();
        }
        return strArr;
    }

    public b i(String str) {
        this.j = str;
        return this;
    }
}
