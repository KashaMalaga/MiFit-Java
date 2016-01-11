package com.c.b.g.a.a;

import com.c.b.g.a.c;

final class b {
    private final boolean a;
    private final com.c.b.g.a.b b;
    private final com.c.b.g.a.b c;
    private final c d;

    b(com.c.b.g.a.b bVar, com.c.b.g.a.b bVar2, c cVar, boolean z) {
        this.b = bVar;
        this.c = bVar2;
        this.d = cVar;
        this.a = z;
    }

    private static int a(Object obj) {
        return obj == null ? 0 : obj.hashCode();
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    boolean a() {
        return this.a;
    }

    com.c.b.g.a.b b() {
        return this.b;
    }

    com.c.b.g.a.b c() {
        return this.c;
    }

    c d() {
        return this.d;
    }

    public boolean e() {
        return this.c == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return a(this.b, bVar.b) && a(this.c, bVar.c) && a(this.d, bVar.d);
    }

    public int hashCode() {
        return (a(this.b) ^ a(this.c)) ^ a(this.d);
    }

    public String toString() {
        return "[ " + this.b + " , " + this.c + " : " + (this.d == null ? "null" : Integer.valueOf(this.d.a())) + " ]";
    }
}
