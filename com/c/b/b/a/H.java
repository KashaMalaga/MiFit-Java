package com.c.b.b.a;

public final class H extends q {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final int g;
    private final char h;
    private final String i;

    public H(String str, String str2, String str3, String str4, String str5, String str6, int i, char c, String str7) {
        super(r.VIN);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = i;
        this.h = c;
        this.i = str7;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public char h() {
        return this.h;
    }

    public String i() {
        return this.i;
    }

    public String q() {
        StringBuilder stringBuilder = new StringBuilder(50);
        stringBuilder.append(this.b).append(' ');
        stringBuilder.append(this.c).append(' ');
        stringBuilder.append(this.d).append('\n');
        if (this.e != null) {
            stringBuilder.append(this.e).append(' ');
        }
        stringBuilder.append(this.g).append(' ');
        stringBuilder.append(this.h).append(' ');
        stringBuilder.append(this.i).append('\n');
        return stringBuilder.toString();
    }
}
