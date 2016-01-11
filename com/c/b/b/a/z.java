package com.c.b.b.a;

public final class z extends q {
    private final String a;
    private final String b;
    private final String c;

    public z(String str, String str2, String str3) {
        super(r.TEL);
        this.a = str;
        this.b = str2;
        this.c = str3;
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

    public String q() {
        StringBuilder stringBuilder = new StringBuilder(20);
        q.a(this.a, stringBuilder);
        q.a(this.c, stringBuilder);
        return stringBuilder.toString();
    }
}
