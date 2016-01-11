package com.c.b.i.c;

import com.c.b.i.a.o;
import com.c.b.i.a.q;
import com.c.b.i.a.s;
import com.xiaomi.channel.b.v;

public final class g {
    public static final int a = 8;
    private q b;
    private o c;
    private s d;
    private int e = -1;
    private b f;

    public static boolean b(int i) {
        return i >= 0 && i < a;
    }

    public q a() {
        return this.b;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(o oVar) {
        this.c = oVar;
    }

    public void a(q qVar) {
        this.b = qVar;
    }

    public void a(s sVar) {
        this.d = sVar;
    }

    public void a(b bVar) {
        this.f = bVar;
    }

    public o b() {
        return this.c;
    }

    public s c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public b e() {
        return this.f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(v.C);
        stringBuilder.append("<<\n");
        stringBuilder.append(" mode: ");
        stringBuilder.append(this.b);
        stringBuilder.append("\n ecLevel: ");
        stringBuilder.append(this.c);
        stringBuilder.append("\n version: ");
        stringBuilder.append(this.d);
        stringBuilder.append("\n maskPattern: ");
        stringBuilder.append(this.e);
        if (this.f == null) {
            stringBuilder.append("\n matrix: null\n");
        } else {
            stringBuilder.append("\n matrix:\n");
            stringBuilder.append(this.f);
        }
        stringBuilder.append(">>\n");
        return stringBuilder.toString();
    }
}
