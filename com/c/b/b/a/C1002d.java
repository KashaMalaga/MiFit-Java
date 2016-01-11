package com.c.b.b.a;

public final class C1002d extends q {
    private final String[] a;
    private final String[] b;
    private final String c;
    private final String[] d;
    private final String[] e;
    private final String[] f;
    private final String[] g;
    private final String h;
    private final String i;
    private final String[] j;
    private final String[] k;
    private final String l;
    private final String m;
    private final String n;
    private final String[] o;
    private final String[] p;

    public C1002d(String[] strArr, String[] strArr2, String str, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String str2, String str3, String[] strArr7, String[] strArr8, String str4, String str5, String str6, String[] strArr9, String[] strArr10) {
        super(r.ADDRESSBOOK);
        this.a = strArr;
        this.b = strArr2;
        this.c = str;
        this.d = strArr3;
        this.e = strArr4;
        this.f = strArr5;
        this.g = strArr6;
        this.h = str2;
        this.i = str3;
        this.j = strArr7;
        this.k = strArr8;
        this.l = str4;
        this.m = str5;
        this.n = str6;
        this.o = strArr9;
        this.p = strArr10;
    }

    public C1002d(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
        this(strArr, null, null, strArr2, strArr3, strArr4, strArr5, null, null, strArr6, strArr7, null, null, null, null, null);
    }

    public String[] a() {
        return this.a;
    }

    public String[] b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String[] d() {
        return this.d;
    }

    public String[] e() {
        return this.e;
    }

    public String[] f() {
        return this.f;
    }

    public String[] g() {
        return this.g;
    }

    public String h() {
        return this.h;
    }

    public String i() {
        return this.i;
    }

    public String[] j() {
        return this.j;
    }

    public String[] k() {
        return this.k;
    }

    public String l() {
        return this.n;
    }

    public String m() {
        return this.l;
    }

    public String[] n() {
        return this.o;
    }

    public String o() {
        return this.m;
    }

    public String[] p() {
        return this.p;
    }

    public String q() {
        StringBuilder stringBuilder = new StringBuilder(100);
        q.a(this.a, stringBuilder);
        q.a(this.b, stringBuilder);
        q.a(this.c, stringBuilder);
        q.a(this.n, stringBuilder);
        q.a(this.l, stringBuilder);
        q.a(this.j, stringBuilder);
        q.a(this.d, stringBuilder);
        q.a(this.f, stringBuilder);
        q.a(this.h, stringBuilder);
        q.a(this.o, stringBuilder);
        q.a(this.m, stringBuilder);
        q.a(this.p, stringBuilder);
        q.a(this.i, stringBuilder);
        return stringBuilder.toString();
    }
}
