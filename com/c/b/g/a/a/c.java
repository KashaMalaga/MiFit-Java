package com.c.b.g.a.a;

import java.util.ArrayList;
import java.util.List;

final class c {
    private final List<b> a;
    private final int b;
    private final boolean c;

    c(List<b> list, int i, boolean z) {
        this.a = new ArrayList(list);
        this.b = i;
        this.c = z;
    }

    List<b> a() {
        return this.a;
    }

    boolean a(List<b> list) {
        return this.a.equals(list);
    }

    int b() {
        return this.b;
    }

    boolean c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a.equals(cVar.a()) && this.c == cVar.c;
    }

    public int hashCode() {
        return this.a.hashCode() ^ Boolean.valueOf(this.c).hashCode();
    }

    public String toString() {
        return "{ " + this.a + " }";
    }
}
