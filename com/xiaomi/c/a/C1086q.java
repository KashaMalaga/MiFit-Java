package com.xiaomi.c.a;

import com.xiaomi.e.a;
import java.io.Serializable;

public class C1086q implements Serializable {
    private static final String a = a.f.intern();
    private String b;
    private String c;
    private String d;

    public C1086q(String str, String str2) {
        this(str, str2, a);
    }

    public C1086q(String str, String str2, String str3) {
        this.b = str == null ? a : str.intern();
        if (str2 == null) {
            throw new IllegalArgumentException("invalid QName local part");
        }
        this.c = str2.intern();
        if (str3 == null) {
            throw new IllegalArgumentException("invalid QName prefix");
        }
        this.d = str3.intern();
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        return obj == this ? true : !(obj instanceof C1086q) ? false : this.b == ((C1086q) obj).b && this.c == ((C1086q) obj).c;
    }

    public final int hashCode() {
        return this.b.hashCode() ^ this.c.hashCode();
    }

    public String toString() {
        return this.b == a ? this.c : '{' + this.b + '}' + this.c;
    }
}
