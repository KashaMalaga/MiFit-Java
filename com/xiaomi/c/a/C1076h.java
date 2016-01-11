package com.xiaomi.c.a;

public final class C1076h {
    private final C1086q a;

    private C1076h(C1086q c1086q) {
        this.a = c1086q;
    }

    public static C1076h a(String str) {
        return C1076h.a("xm", str, null);
    }

    public static C1076h a(String str, String str2) {
        return C1076h.a(str, str2, null);
    }

    public static C1076h a(String str, String str2, String str3) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("URI is required and may not be null/empty");
        } else if (str2 != null && str2.length() != 0) {
            return (str3 == null || str3.length() == 0) ? new C1076h(new C1086q(str, str2)) : new C1076h(new C1086q(str, str2, str3));
        } else {
            throw new IllegalArgumentException("Local arg is required and may not be null/empty");
        }
    }

    public String a() {
        return this.a.a();
    }

    boolean a(C1086q c1086q) {
        return this.a.equals(c1086q);
    }

    public String b() {
        return this.a.b();
    }

    public String c() {
        return this.a.c();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1076h)) {
            return false;
        }
        return this.a.equals(((C1076h) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
