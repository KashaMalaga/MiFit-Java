package com.c.a;

import com.c.a.b.C0970a;
import com.c.a.b.a.C0968y;
import com.c.a.b.s;
import com.xiaomi.e.a;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class r {
    private s a = s.a;
    private H b = H.DEFAULT;
    private C0986j c = C0987d.IDENTITY;
    private final Map<Type, s<?>> d = new HashMap();
    private final List<P> e = new ArrayList();
    private final List<P> f = new ArrayList();
    private boolean g;
    private String h;
    private int i = 2;
    private int j = 2;
    private boolean k;
    private boolean l;
    private boolean m = true;
    private boolean n;
    private boolean o;

    private void a(String str, int i, int i2, List<P> list) {
        Object c0943a;
        if (str != null && !a.f.equals(str.trim())) {
            c0943a = new C0943a(str);
        } else if (i != 2 && i2 != 2) {
            c0943a = new C0943a(i, i2);
        } else {
            return;
        }
        list.add(K.a(com.c.a.c.a.get(Date.class), c0943a));
        list.add(K.a(com.c.a.c.a.get(Timestamp.class), c0943a));
        list.add(K.a(com.c.a.c.a.get(java.sql.Date.class), c0943a));
    }

    public r a() {
        this.o = true;
        return this;
    }

    public r a(double d) {
        this.a = this.a.a(d);
        return this;
    }

    public r a(int i) {
        this.i = i;
        this.h = null;
        return this;
    }

    public r a(int i, int i2) {
        this.i = i;
        this.j = i2;
        this.h = null;
        return this;
    }

    public r a(H h) {
        this.b = h;
        return this;
    }

    public r a(P p) {
        this.e.add(p);
        return this;
    }

    public r a(b bVar) {
        this.a = this.a.a(bVar, true, false);
        return this;
    }

    public r a(C0987d c0987d) {
        this.c = c0987d;
        return this;
    }

    public r a(C0986j c0986j) {
        this.c = c0986j;
        return this;
    }

    public r a(Class<?> cls, Object obj) {
        boolean z = (obj instanceof E) || (obj instanceof v) || (obj instanceof N);
        C0970a.a(z);
        if ((obj instanceof v) || (obj instanceof E)) {
            this.f.add(0, K.a((Class) cls, obj));
        }
        if (obj instanceof N) {
            this.e.add(C0968y.b(cls, (N) obj));
        }
        return this;
    }

    public r a(String str) {
        this.h = str;
        return this;
    }

    public r a(Type type, Object obj) {
        boolean z = (obj instanceof E) || (obj instanceof v) || (obj instanceof s) || (obj instanceof N);
        C0970a.a(z);
        if (obj instanceof s) {
            this.d.put(type, (s) obj);
        }
        if ((obj instanceof E) || (obj instanceof v)) {
            this.e.add(K.b(com.c.a.c.a.get(type), obj));
        }
        if (obj instanceof N) {
            this.e.add(C0968y.a(com.c.a.c.a.get(type), (N) obj));
        }
        return this;
    }

    public r a(int... iArr) {
        this.a = this.a.a(iArr);
        return this;
    }

    public r a(b... bVarArr) {
        for (b a : bVarArr) {
            this.a = this.a.a(a, true, true);
        }
        return this;
    }

    public r b() {
        this.a = this.a.c();
        return this;
    }

    public r b(b bVar) {
        this.a = this.a.a(bVar, false, true);
        return this;
    }

    public r c() {
        this.g = true;
        return this;
    }

    public r d() {
        this.k = true;
        return this;
    }

    public r e() {
        this.a = this.a.b();
        return this;
    }

    public r f() {
        this.n = true;
        return this;
    }

    public r g() {
        this.m = false;
        return this;
    }

    public r h() {
        this.l = true;
        return this;
    }

    public C0993k i() {
        List arrayList = new ArrayList();
        arrayList.addAll(this.e);
        Collections.reverse(arrayList);
        arrayList.addAll(this.f);
        a(this.h, this.i, this.j, arrayList);
        return new C0993k(this.a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.l, this.b, arrayList);
    }
}
