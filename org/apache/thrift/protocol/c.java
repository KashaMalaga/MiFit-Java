package org.apache.thrift.protocol;

import com.xiaomi.e.a;

public class c {
    public final String a;
    public final byte b;
    public final short c;

    public c() {
        this(a.f, (byte) 0, (short) 0);
    }

    public c(String str, byte b, short s) {
        this.a = str;
        this.b = b;
        this.c = s;
    }

    public String toString() {
        return "<TField name:'" + this.a + "' type:" + this.b + " field-id:" + this.c + ">";
    }
}
