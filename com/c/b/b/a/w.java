package com.c.b.b.a;

public final class w extends q {
    private final String[] a;
    private final String[] b;
    private final String c;
    private final String d;

    public w(String str, String str2, String str3, String str4) {
        super(r.SMS);
        this.a = new String[]{str};
        this.b = new String[]{str2};
        this.c = str3;
        this.d = str4;
    }

    public w(String[] strArr, String[] strArr2, String str, String str2) {
        super(r.SMS);
        this.a = strArr;
        this.b = strArr2;
        this.c = str;
        this.d = str2;
    }

    public String a() {
        Object obj = 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sms:");
        int i = 0;
        Object obj2 = 1;
        while (i < this.a.length) {
            if (obj2 != null) {
                obj2 = null;
            } else {
                stringBuilder.append(',');
            }
            stringBuilder.append(this.a[i]);
            if (!(this.b == null || this.b[i] == null)) {
                stringBuilder.append(";via=");
                stringBuilder.append(this.b[i]);
            }
            i++;
        }
        Object obj3 = this.d != null ? 1 : null;
        if (this.c == null) {
            obj = null;
        }
        if (!(obj3 == null && obj == null)) {
            stringBuilder.append('?');
            if (obj3 != null) {
                stringBuilder.append("body=");
                stringBuilder.append(this.d);
            }
            if (obj != null) {
                if (obj3 != null) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("subject=");
                stringBuilder.append(this.c);
            }
        }
        return stringBuilder.toString();
    }

    public String[] b() {
        return this.a;
    }

    public String[] c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.d;
    }

    public String q() {
        StringBuilder stringBuilder = new StringBuilder(100);
        q.a(this.a, stringBuilder);
        q.a(this.c, stringBuilder);
        q.a(this.d, stringBuilder);
        return stringBuilder.toString();
    }
}
