package com.c.b.b.a;

public final class J extends q {
    private final String a;
    private final String b;
    private final String c;
    private final boolean d;

    public J(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }

    public J(String str, String str2, String str3, boolean z) {
        super(r.WIFI);
        this.a = str2;
        this.b = str;
        this.c = str3;
        this.d = z;
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

    public boolean d() {
        return this.d;
    }

    public String q() {
        StringBuilder stringBuilder = new StringBuilder(80);
        q.a(this.a, stringBuilder);
        q.a(this.b, stringBuilder);
        q.a(this.c, stringBuilder);
        q.a(Boolean.toString(this.d), stringBuilder);
        return stringBuilder.toString();
    }
}
