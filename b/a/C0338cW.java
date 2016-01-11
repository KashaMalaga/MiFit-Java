package b.a;

import com.xiaomi.e.a;

public final class C0338cW {
    public final String a;
    public final byte b;
    public final int c;

    public C0338cW() {
        this(a.f, (byte) 0, 0);
    }

    public C0338cW(String str, byte b, int i) {
        this.a = str;
        this.b = b;
        this.c = i;
    }

    public boolean a(C0338cW c0338cW) {
        return this.a.equals(c0338cW.a) && this.b == c0338cW.b && this.c == c0338cW.c;
    }

    public boolean equals(Object obj) {
        return obj instanceof C0338cW ? a((C0338cW) obj) : false;
    }

    public String toString() {
        return "<TMessage name:'" + this.a + "' type: " + this.b + " seqid:" + this.c + ">";
    }
}
