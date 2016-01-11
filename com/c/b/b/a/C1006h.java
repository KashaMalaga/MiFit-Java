package com.c.b.b.a;

public final class C1006h extends q {
    private final String[] a;
    private final String[] b;
    private final String[] c;
    private final String d;
    private final String e;

    C1006h(String str) {
        this(new String[]{str}, null, null, null, null);
    }

    C1006h(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2) {
        super(r.EMAIL_ADDRESS);
        this.a = strArr;
        this.b = strArr2;
        this.c = strArr3;
        this.d = str;
        this.e = str2;
    }

    @Deprecated
    public String a() {
        return (this.a == null || this.a.length == 0) ? null : this.a[0];
    }

    public String[] b() {
        return this.a;
    }

    public String[] c() {
        return this.b;
    }

    public String[] d() {
        return this.c;
    }

    public String e() {
        return this.d;
    }

    public String f() {
        return this.e;
    }

    @Deprecated
    public String g() {
        return "mailto:";
    }

    public String q() {
        StringBuilder stringBuilder = new StringBuilder(30);
        q.a(this.a, stringBuilder);
        q.a(this.b, stringBuilder);
        q.a(this.c, stringBuilder);
        q.a(this.d, stringBuilder);
        q.a(this.e, stringBuilder);
        return stringBuilder.toString();
    }
}
