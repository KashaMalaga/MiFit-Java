package com.a.a.a;

import java.util.HashMap;
import java.util.Map;

class T {
    private static final int[] d;
    private final int a;
    private final Map<Short, S> b = new HashMap();
    private int c = 0;

    static {
        int[] iArr = new int[5];
        iArr[1] = 1;
        iArr[2] = 2;
        iArr[3] = 3;
        iArr[4] = 4;
        d = iArr;
    }

    T(int i) {
        this.a = i;
    }

    protected static int[] a() {
        return d;
    }

    protected S a(S s) {
        s.b(this.a);
        return (S) this.b.put(Short.valueOf(s.b()), s);
    }

    protected S a(short s) {
        return (S) this.b.get(Short.valueOf(s));
    }

    protected void a(int i) {
        this.c = i;
    }

    protected boolean b(short s) {
        return this.b.get(Short.valueOf(s)) != null;
    }

    protected S[] b() {
        return (S[]) this.b.values().toArray(new S[this.b.size()]);
    }

    protected int c() {
        return this.a;
    }

    protected void c(short s) {
        this.b.remove(Short.valueOf(s));
    }

    protected int d() {
        return this.b.size();
    }

    protected int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof T) {
            T t = (T) obj;
            if (t.c() == this.a && t.d() == d()) {
                for (S s : t.b()) {
                    if (!C0895d.b(s.b()) && !s.equals((S) this.b.get(Short.valueOf(s.b())))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
