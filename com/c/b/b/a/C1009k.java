package com.c.b.b.a;

import java.util.Map;

public final class C1009k extends q {
    public static final String a = "KG";
    public static final String b = "LB";
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final Map<String, String> q;

    public C1009k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(r.PRODUCT);
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = str7;
        this.j = str8;
        this.k = str9;
        this.l = str10;
        this.m = str11;
        this.n = str12;
        this.o = str13;
        this.p = str14;
        this.q = map;
    }

    private static int a(Object obj) {
        return obj == null ? 0 : obj.hashCode();
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.f;
    }

    public String e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1009k)) {
            return false;
        }
        C1009k c1009k = (C1009k) obj;
        return C1009k.a(this.d, c1009k.d) && C1009k.a(this.e, c1009k.e) && C1009k.a(this.f, c1009k.f) && C1009k.a(this.g, c1009k.g) && C1009k.a(this.i, c1009k.i) && C1009k.a(this.j, c1009k.j) && C1009k.a(this.k, c1009k.k) && C1009k.a(this.l, c1009k.l) && C1009k.a(this.m, c1009k.m) && C1009k.a(this.n, c1009k.n) && C1009k.a(this.o, c1009k.o) && C1009k.a(this.p, c1009k.p) && C1009k.a(this.q, c1009k.q);
    }

    public String f() {
        return this.h;
    }

    public String g() {
        return this.i;
    }

    public String h() {
        return this.j;
    }

    public int hashCode() {
        return ((((((((((((0 ^ C1009k.a(this.d)) ^ C1009k.a(this.e)) ^ C1009k.a(this.f)) ^ C1009k.a(this.g)) ^ C1009k.a(this.i)) ^ C1009k.a(this.j)) ^ C1009k.a(this.k)) ^ C1009k.a(this.l)) ^ C1009k.a(this.m)) ^ C1009k.a(this.n)) ^ C1009k.a(this.o)) ^ C1009k.a(this.p)) ^ C1009k.a(this.q);
    }

    public String i() {
        return this.k;
    }

    public String j() {
        return this.l;
    }

    public String k() {
        return this.m;
    }

    public String l() {
        return this.n;
    }

    public String m() {
        return this.o;
    }

    public String n() {
        return this.p;
    }

    public Map<String, String> o() {
        return this.q;
    }

    public String q() {
        return String.valueOf(this.c);
    }
}
