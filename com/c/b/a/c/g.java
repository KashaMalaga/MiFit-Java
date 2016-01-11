package com.c.b.a.c;

import android.support.v4.e.a.a;
import java.util.Deque;
import java.util.LinkedList;

final class g {
    static final g a = new g(h.a, 0, 0, 0);
    private final int b;
    private final h c;
    private final int d;
    private final int e;

    private g(h hVar, int i, int i2, int i3) {
        this.c = hVar;
        this.b = i;
        this.d = i2;
        this.e = i3;
    }

    int a() {
        return this.b;
    }

    g a(int i) {
        h a;
        h hVar = this.c;
        int i2 = this.b;
        int i3 = this.e;
        if (this.b == 4 || this.b == 2) {
            int i4 = d.g[i2][0];
            i3 += i4 >> 16;
            a = hVar.a(a.a & i4, i4 >> 16);
            i2 = 0;
        } else {
            a = hVar;
        }
        int i5 = (this.d == 0 || this.d == 31) ? 18 : this.d == 62 ? 9 : 8;
        g gVar = new g(a, i2, this.d + 1, i3 + i5);
        return gVar.d == 2078 ? gVar.b(i + 1) : gVar;
    }

    g a(int i, int i2) {
        int i3;
        h a;
        int i4 = this.e;
        h hVar = this.c;
        if (i != this.b) {
            i3 = d.g[this.b][i];
            i3 = i4 + (i3 >> 16);
            a = hVar.a(a.a & i3, i3 >> 16);
        } else {
            i3 = i4;
            a = hVar;
        }
        int i5 = i == 2 ? 4 : 5;
        return new g(a.a(i2, i5), i, 0, i5 + i3);
    }

    com.c.b.c.a a(byte[] bArr) {
        Deque<h> linkedList = new LinkedList();
        for (h hVar = b(bArr.length).c; hVar != null; hVar = hVar.a()) {
            linkedList.addFirst(hVar);
        }
        com.c.b.c.a aVar = new com.c.b.c.a();
        for (h hVar2 : linkedList) {
            hVar2.a(aVar, bArr);
        }
        return aVar;
    }

    boolean a(g gVar) {
        int i = this.e + (d.g[this.b][gVar.b] >> 16);
        if (gVar.d > 0 && (this.d == 0 || this.d > gVar.d)) {
            i += 10;
        }
        return i <= gVar.e;
    }

    g b(int i) {
        return this.d == 0 ? this : new g(this.c.b(i - this.d, this.d), this.b, 0, this.e);
    }

    g b(int i, int i2) {
        h hVar = this.c;
        int i3 = this.b == 2 ? 4 : 5;
        return new g(hVar.a(d.h[this.b][i], i3).a(i2, 5), this.b, 0, (i3 + this.e) + 5);
    }

    h b() {
        return this.c;
    }

    int c() {
        return this.d;
    }

    int d() {
        return this.e;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{d.a[this.b], Integer.valueOf(this.e), Integer.valueOf(this.d)});
    }
}
